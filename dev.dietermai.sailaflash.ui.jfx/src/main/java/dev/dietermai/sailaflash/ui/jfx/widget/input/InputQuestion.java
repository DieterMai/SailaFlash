package dev.dietermai.sailaflash.ui.jfx.widget.input;

import dev.dietermai.sailaflash.ui.jfx.Constants;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import dev.dietermai.sailaflash.ui.jfx.widget.Widget;
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
	public ReadOnlyStringProperty text() { return text; }
	public String getText() { return text.get(); }
	//@formatter:on
	
	
	@Override
	public InputQuestion initialize() {
		Label title = new Label("Enter Question");
		TextArea questionTestArea = new TextArea();
		questionTestArea.textProperty().bind(text);
		
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
