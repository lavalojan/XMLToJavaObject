package Task;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.IOException;

import javax.xml.bind.JAXBException;
 
public class Main extends Application {
	public static void main(String[] args) throws NumberFormatException, JAXBException, IOException {
		Output op=new Output();

		op.printResult();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//private Desktop desktop = Desktop.getDesktop();
		Button btn=new Button("Open");
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open InputFile");
		
		btn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				//System.out.println("hello");
				fileChooser.showOpenDialog(primaryStage);
			}
		});
		StackPane root = new StackPane();
		root.getChildren().add(btn); 

		//Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene= new Scene(root,400,600 );
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
}