package dev.dietermai.sailaflash.ui.jfx.input;

import dev.dietermai.sailaflash.ui.jfx.Constants;
import dev.dietermai.sailaflash.ui.jfx.inject.PMI;
import dev.dietermai.sailaflash.ui.jfx.main.Widget;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InputCardMetaSection extends Widget<InputCardMetaSection>{

	@Override
	public InputCardMetaSection initialize() {
		PMI.pmi.set(this);
		
		Label metaTitle = new Label("Additional Information");
		Label subjectPrompt = new Label("Select Subject");
		ChoiceBox<String> subjectChoice = new ChoiceBox<>();
		Button additionInfoButton = new Button("Enter additional information (optional)");
		
		VBox metaBox = new VBox(10);
		metaBox.setPadding(new Insets(10));
		metaBox.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundContrast));
		metaBox.getChildren().add(metaTitle);
		metaBox.getChildren().add(subjectPrompt);
		metaBox.getChildren().add(subjectChoice);
		metaBox.getChildren().add(additionInfoButton);
		
		setRoot(metaBox);
		
		return this;
	}

}
