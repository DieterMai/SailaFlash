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

public class InputAnswer extends Widget<InputAnswer>{

	//@formatter:off
	private ReadOnlyStringWrapper text = new ReadOnlyStringWrapper(null, "AnswerText", "");
	public ReadOnlyStringProperty textProperty() { return text; }
	public String getText() { return text.get(); }
	//@formatter:on
	
	@Override
	public InputAnswer initialize() {
		Label title = new Label("Enter Answer");
		TextArea anwerTestArea = new TextArea();
		
		anwerTestArea.textProperty().bind(text);
		
		VBox.setVgrow(anwerTestArea, Priority.ALWAYS);
		
		VBox root = new VBox(10);
		root.setPadding(new Insets(10));
		root.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundContrast));
		root.getChildren().add(title);
		root.getChildren().add(anwerTestArea);
		setRoot(root);
		
		return this;
	}

}
