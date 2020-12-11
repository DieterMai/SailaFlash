package dev.dietermai.sailaflash.ui.jfx.input;

import dev.dietermai.sailaflash.ui.jfx.Constants;
import dev.dietermai.sailaflash.ui.jfx.inject.PMI;
import dev.dietermai.sailaflash.ui.jfx.main.Widget;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class InputQuestion extends Widget<InputQuestion>{

	//@formatter:off
	private ReadOnlyStringWrapper text = new ReadOnlyStringWrapper(null, "QuestionText", "");
	public ReadOnlyStringProperty textProperty() { return text; }
	public String getText() { return text.get(); }
	//@formatter:on
	
	
	@Override
	public InputQuestion initialize() {
		PMI.pmi.set(this);
		
		Label title = new Label("Enter Question");
		TextArea questionTestArea = new TextArea();
		text.bind(questionTestArea.textProperty());
		
		VBox.setVgrow(questionTestArea, Priority.ALWAYS);
		
		VBox root = new VBox(10);
		root.setPadding(new Insets(10));
		root.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundContrast));
		root.getChildren().add(title);
		root.getChildren().add(questionTestArea);
		setRoot(root);
		
		return this;
	}
}
