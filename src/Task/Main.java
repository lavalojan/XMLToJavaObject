package Task;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        int m;
        final FileChooser fileChooser = new FileChooser();
        //final Button openButton = new Button("Open TestFile");
        //Button exitButton= new Button("Close");
        MenuItem open = new MenuItem("Open");
        MenuItem exit = new MenuItem("Exit");
        Label in = new Label("Input File");
        Label result = new Label("Result");
        
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        menuFile.getItems().addAll(open, exit);
        menuBar.getMenus().addAll(menuFile, menuEdit);
        
        ListView<String> list = new ListView<String>();
        ListView<String> list2 = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList();
        ObservableList<String> items2 =FXCollections.observableArrayList();
        list.setPrefWidth(300);
        list.setPrefHeight(600);
        list2.setPrefWidth(300);
        list2.setPrefHeight(600);
        exit.setOnAction(new EventHandler<ActionEvent>(){
        
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
        	
        });
        open.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    configureFileChooser(fileChooser);
                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                    	Output op=new Output();
                    	ReadFile rf=new ReadFile();
                       fileIn=file.getParent()+"\\"+file.getName();
                  
                       op.getInput(fileIn);
                       try {
						//String out = op.printResult();
						
						ArrayList<HashMap> hs=op.printResult();
						
						FileReader fr = new FileReader(fileIn);
						BufferedReader br = new BufferedReader(fr);
						String currentLine;
						items.clear();
						items2.clear();
						while ((currentLine = br.readLine()) != null) {
							
							items.add(currentLine);
							}
					      list.setOnMouseClicked(new EventHandler<MouseEvent>(){

					          @Override
					          public void handle(MouseEvent arg0) {
					        	  items2.clear();
					        	  for (Object objname : hs.get(list.getSelectionModel().getSelectedIndex()).keySet()) {
					        		  items2.add(objname+" : " + hs.get(list.getSelectionModel().getSelectedIndex()).get(objname));
					        	  }

					          }

					      });
						list.setItems(items);
						list2.setItems(items2);

					} catch (NumberFormatException | JAXBException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    }
                }
                
            });
 
 
        final GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(in, 2, 1);
        GridPane.setConstraints(result, 3, 1);
        GridPane.setConstraints(list, 2, 2);
        GridPane.setConstraints(list2, 3, 2);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(menuBar,list,list2,in,result);
        
        final Pane rootGroup = new Pane();
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        stage.setScene(new Scene(rootGroup,900,900));
        stage.show();
    }
	
	 private static void configureFileChooser(
		        final FileChooser fileChooser) {      
		           // fileChooser.setTitle("View Pictures");
		            fileChooser.setInitialDirectory(
		                new File(System.getProperty("user.home"))
		            );                 
		            fileChooser.getExtensionFilters().addAll(
		                new FileChooser.ExtensionFilter("*.TXT", "*.txt")
		            );
		    }

		}