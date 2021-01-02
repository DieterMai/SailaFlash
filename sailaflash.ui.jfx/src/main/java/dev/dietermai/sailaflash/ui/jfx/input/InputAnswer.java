package dev.dietermai.sailaflash.ui.jfx.input;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.StyleClassedTextArea;

import dev.dietermai.sailaflash.ui.jfx.Constants;
import dev.dietermai.sailaflash.ui.jfx.inject.PMI;
import dev.dietermai.sailaflash.ui.jfx.main.Widget;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
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
		PMI.pmi.set(this);
		
		Label title = new Label("Enter Answer");
		StyleClassedTextArea textArea = new StyleClassedTextArea();
		
		text.bind(textArea.textProperty());
		
		VBox.setVgrow(textArea, Priority.ALWAYS);
		
		VBox root = new VBox(10);
		root.setPadding(new Insets(10));
		root.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundContrast));
		root.getChildren().add(title);
		root.getChildren().add(textArea);
		setRoot(root);
		
		return this;
	}

}
