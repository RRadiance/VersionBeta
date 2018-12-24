package versionBeta;

import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application {
	
	Model model; // Model
	View view; // View + Controller
	
	public static void main(String[]args) {
		
		QuandlAuthenticator QA = new QuandlAuthenticator();
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		this.model = new Model();

		// View + Controller
		this.view = new View(model, stage);
	}
}
