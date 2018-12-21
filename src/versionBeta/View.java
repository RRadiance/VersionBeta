package versionBeta;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View implements EventHandler<ActionEvent>{

	private Model model;
	private GridPane organizeRight;
	private VBox organizeSecondScene;

	private Scene primary;
	private BorderPane root;

	/**
	 * The constructor for View. 
	 * 
	 * @param model
	 * @param stage
	 */
	public View(Model model, Stage stage) {
		this.model = model;
		initUI(stage);
	}

	/**
	 * This method creates the panels that store most of the graphical elements
	 * that the user will see. This method is also in charge of laying out
	 * the elements in a specified order.
	 * 
	 * @param stage
	 */
	private void initUI(Stage stage) {


		// BorderPane root = new BorderPane();
		root = new BorderPane();
		root.setTop(createMenuBar());

		primary = new Scene(root);
		stage.setScene(primary);
		stage.setTitle("Version Beta");
		stage.show();

		
	}

	/**
	 * Creates a menubar that is located at the top of the program.
	 * 
	 */
	private MenuBar createMenuBar() {

		MenuBar menuBar = new MenuBar();
		Menu menu;
		MenuItem menuItem;

		// A menu for File

		menu = new Menu("File");

		menuItem = new MenuItem("New");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Open");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Save");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Exit");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for Edit

		menu = new Menu("Edit");

		menuItem = new MenuItem("Cut");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Copy");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Paste");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Undo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Redo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		return menuBar;
	}

	@Override
	public void handle(ActionEvent event) {
		//System.out.println(((MenuItem) event.getSource()).getText());
	}
}
