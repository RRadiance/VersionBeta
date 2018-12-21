package versionBeta;

import com.jimmoores.quandl.DataSetRequest;
import com.jimmoores.quandl.TabularResult;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application {
	
	Model model; // Model
	View view; // View + Controller
	
	public static void main(String[]args) {
		
		// Example1.java
		ClassicQuandlSession session = ClassicQuandlSession.create();
		TabularResult tabularResult = session.getDataSet(
		  DataSetRequest.Builder.of("WIKI/AAPL").build());
		System.out.println(tabularResult.toPrettyPrintedString());
		
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		this.model = new Model();

		// View + Controller
		this.view = new View(model, stage);
	}
}
