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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Desktop;
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
	String finder;
	String selectedLine;

	private Desktop desktop = Desktop.getDesktop();

	public static void main(String[] args) throws NumberFormatException, JAXBException, IOException {
		launch(args);
	}

	@Override
	public void start(final Stage stage) throws JAXBException {

		Button select = new Button("ok");
		Button sysexit = new Button("Exit");
		stage.setTitle("File Chooser Sample");
		final FileChooser fileChooser = new FileChooser();
		MenuItem open = new MenuItem("Open");
		MenuItem exit = new MenuItem("Exit");
		// MenuItem close = new MenuItem("Close");
		Label in = new Label("Input File");
		Label result = new Label("Result");

		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("File");
		menuFile.getItems().addAll(open, exit);
		menuBar.getMenus().addAll(menuFile);

		ListView<String> list = new ListView<String>();
		ListView<String> list2 = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList();
		ObservableList<String> items2 = FXCollections.observableArrayList();
		list.setPrefWidth(300);
		list.setPrefHeight(600);
		list2.setPrefWidth(300);
		list2.setPrefHeight(600);

		select.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Stage stage = new Stage();
				final GridPane inputGridPane = new GridPane();
				GridPane.setConstraints(in, 2, 3);
				GridPane.setConstraints(result, 3, 3);
				GridPane.setConstraints(list, 2, 4);
				GridPane.setConstraints(list2, 3, 4);
				inputGridPane.setHgap(6);
				inputGridPane.setVgap(6);
				items.clear();
				items2.clear();
				inputGridPane.getChildren().addAll(menuBar, list, list2, in, result);

				// Option op = new Option();
				// HashMap formatOption = op.selectOption();
				final ToggleGroup group = new ToggleGroup();
				final Pane rootGroup = new Pane();
				rootGroup.getChildren().addAll(inputGridPane);
				rootGroup.setPadding(new Insets(12, 12, 12, 12));

				stage.setScene(new Scene(rootGroup, 900, 900));
				stage.show();

			}
		});

		sysexit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		open.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				configureFileChooser(fileChooser);
				File file = fileChooser.showOpenDialog(null);
				Output op = new Output();
				ReadFile readfile = new ReadFile();
				
				//op.setidSelector(finder);
				//op.setValue(finder);
				//op.printResult2();
				//op.getInput(fileIn);
				
				if (file != null) {
					
					//ReadFile readfile = new ReadFile();

					fileIn = file.getParent() + "\\" + file.getName();
					
					
					
					try {
						ArrayList<String> lineValue = new ArrayList<String>();
						FileReader fr = new FileReader(fileIn);
						BufferedReader br = new BufferedReader(fr);
						String currentLine;
						items.clear();
						items2.clear();
						int i = 0;
						while ((currentLine = br.readLine()) != null) {
							lineValue.add(currentLine);
							i++;
							items.add("line " + i + ": " + currentLine.substring(0, 15));

						}

						list.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent arg0) {
								items2.clear();
								selectedLine = lineValue.get(list.getSelectionModel().getSelectedIndex()).toString();
								//ReadFile readfile = new ReadFile();
								readfile.setXmlFile(finder+"FileFormat.xml" );
								readfile.setMsgId(finder+"FileSelector.xml" );
								readfile.setLine(selectedLine);
								try {
									for(Object items : readfile.covertToObject().keySet()){
									items2.add(items+ ":" + readfile.covertToObject().get(items));
									}
									items2.sort(null);
								} catch (JAXBException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									
								}

								// for (Object objname :
								// hs.get(list.getSelectionModel().getSelectedIndex()).keySet())
								// {
								// items2.add(objname + " : "
								// +
								// hs.get(list.getSelectionModel().getSelectedIndex()).get(objname));
								// }
							}
						});
						list.setItems(items);
						list2.setItems(items2);

					} catch (NumberFormatException | IOException e1) {
						e1.printStackTrace();
	
					}
				}
			}
		});

		final GridPane inputGrid = new GridPane();
		// GridPane.setConstraints(in, 2, 3);
		// GridPane.setConstraints(result, 3, 3);
		GridPane.setConstraints(sysexit, 3, 10);
		GridPane.setConstraints(select, 4, 10);
		// inputGridPane.setHgap(6);
		// inputGridPane.setVgap(6);
		inputGrid.getChildren().addAll(select, sysexit);

		Option op = new Option();
		HashMap formatOption = op.selectOption();
		final ToggleGroup group = new ToggleGroup();

		for (int i = 0; i < formatOption.size(); i++) {
			RadioButton rb1 = new RadioButton();
			rb1.setText(formatOption.values().toArray()[i].toString());
			rb1.setToggleGroup(group);
			rb1.setSelected(true);
			finder = group.getSelectedToggle().toString()
					.substring(46, group.getSelectedToggle().toString().length() - 1).toString();
			GridPane.setConstraints(rb1, 2, 1 + i);
			inputGrid.getChildren().add(rb1);

		}

		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				if (group.getSelectedToggle() != null) {
					//System.out.print(group.getSelectedToggle());
					finder = group.getSelectedToggle().toString()
							.substring(46, group.getSelectedToggle().toString().length() - 1).toString();
				}
			}
		});

		final Pane rootGroup = new Pane();
		rootGroup.getChildren().addAll(inputGrid);
		rootGroup.setPadding(new Insets(12, 12, 12, 12));

		stage.setScene(new Scene(rootGroup, 300, 150));
		stage.show();
	}

	private static void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.TXT", "*.txt"));
	}

}