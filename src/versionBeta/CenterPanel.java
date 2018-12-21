package versionBeta;

import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class CenterPanel extends GridPane{

	public CenterPanel(Model model) {
		TextArea textArea = new TextArea("Default Text");
		this.add(textArea, 1, 1);
		textArea.setEditable(false);
	}
}
