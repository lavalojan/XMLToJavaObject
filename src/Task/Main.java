package Task;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.awt.TextField;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;


 
public class Main extends Application {
	static String inputFile;
	static String fileIn;
	
	private Desktop desktop = Desktop.getDesktop();
	 
	public static void main(String[] args) throws NumberFormatException, JAXBException, IOException {
		launch(args);	
	}

	
	
	@Override
    public void start(final Stage stage) {
        stage.setTitle("File Chooser Sample");
 
        final FileChooser fileChooser = new FileChooser();
        final Button openButton = new Button("Open TestFile");
        Button exitButton= new Button("Close");
        Label label1 = new Label();
        exitButton.setOnAction(new EventHandler<ActionEvent>(){
        
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
        	
        });
        openButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    configureFileChooser(fileChooser);
                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                    	Output op=new Output();
                    	
                       fileIn=file.getParent()+"\\"+file.getName();
                  
                       op.getInput(fileIn);
                       try {
						String out = op.printResult();
						
						label1.setText(out);

					} catch (NumberFormatException | JAXBException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    }
                }
            });
 

 
        final GridPane inputGridPane = new GridPane();
 
        GridPane.setConstraints(openButton, 0, 1);
        GridPane.setConstraints(exitButton, 1, 1);
        GridPane.setConstraints(label1, 2, 1);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton,exitButton,label1);
        
        final Pane rootGroup = new Pane();
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        stage.setScene(new Scene(rootGroup,700,900));
        stage.show();
    }
	
	 private static void configureFileChooser(
		        final FileChooser fileChooser) {      
		            fileChooser.setTitle("View Pictures");
		            fileChooser.setInitialDirectory(
		                new File(System.getProperty("user.home"))
		            );                 
		            fileChooser.getExtensionFilters().addAll(
		                new FileChooser.ExtensionFilter("*.TXT", "*.txt")
		            );
		    }

		}