package versionBeta;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ButtonChooserPanel extends VBox implements EventHandler<ActionEvent>{
	private View view; // So we can talk to our parent or other components of the view
	private Button previousButton; 


	/**
	 * Constructs a ShapeChooserPanel with their corresponding button and image
	 * @param view
	 */
	public ButtonChooserPanel(View view) {
		this.view = view;
		
		Button getData = new Button("Get Data");
		getData.setMinWidth(120);
		getData.setOnAction(this);
		
		Button displayData = new Button("Display Data");
		displayData.setMinWidth(120);
		displayData.setOnAction(this);
		
		Button analyzeData = new Button("Analyze Data");
		analyzeData.setMinWidth(120);
		analyzeData.setOnAction(this);
		
		Button displayAnalysis = new Button("Show Analysis");
		displayAnalysis.setMinWidth(120);
		displayAnalysis.setOnAction(this);
		
		this.getChildren().add(getData);
		this.getChildren().add(displayData);
		this.getChildren().add(analyzeData);
		this.getChildren().add(displayAnalysis);
		
	}

	/**
	 * handler to handle the ActionEvent for a button in ShapeChooserPanel
	 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getText();
		System.out.println(command);
	}
}
