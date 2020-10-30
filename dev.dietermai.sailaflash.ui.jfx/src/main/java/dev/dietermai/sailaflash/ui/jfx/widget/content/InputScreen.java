package dev.dietermai.sailaflash.ui.jfx.widget.content;

import static dev.dietermai.sailaflash.ui.jfx.widget.content.ContentConstants.CONTENT_screenBackground;

import dev.dietermai.sailaflash.ui.jfx.action.SaveAction;
import dev.dietermai.sailaflash.ui.jfx.inject.PMI;
import dev.dietermai.sailaflash.ui.jfx.screen.IScreen;
import dev.dietermai.sailaflash.ui.jfx.widget.input.InputAnswer;
import dev.dietermai.sailaflash.ui.jfx.widget.input.InputCardMetaSection;
import dev.dietermai.sailaflash.ui.jfx.widget.input.InputMenuBar;
import dev.dietermai.sailaflash.ui.jfx.widget.input.InputQuestion;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class InputScreen implements IScreen {

	private VBox root;
	
	@Override
	public void initialize() {
		Node topButtonBar = new InputMenuBar().initialize().getRoot();
		Node cardSection = createCardSection();
		Node bottonButtonBar = createSaveSection();
		
		VBox.setVgrow(cardSection, Priority.ALWAYS);
		
		root = new VBox();
		root.setBackground(CONTENT_screenBackground);
		root.getChildren().add(topButtonBar);
		root.getChildren().add(cardSection);
		root.getChildren().add(bottonButtonBar);
	}
	
	private Node createCardSection() {
		Node metaBox = PMI.pmi.create(InputCardMetaSection.class).initialize().getRoot();
		Node questionBox = PMI.pmi.create(InputQuestion.class).initialize().getRoot();
		Node answerBox = PMI.pmi.create(InputAnswer.class).initialize().getRoot();
		
		HBox.setHgrow(questionBox, Priority.ALWAYS);
		HBox.setHgrow(answerBox, Priority.ALWAYS);
		
		HBox mainHBox = new HBox(5);
		mainHBox.getChildren().add(metaBox);
		mainHBox.getChildren().add(questionBox);
		mainHBox.getChildren().add(answerBox);
		
		return mainHBox;
	}
	
	private Node createSaveSection() {
		Button saveButton = new Button("Save and Next");
		saveButton.setOnAction(actionEvent -> PMI.pmi.get(SaveAction.class).execute());
//		saveButton.onActionProperty()
		
		HBox mainHBox =new HBox(5);
		mainHBox.setAlignment(Pos.CENTER_RIGHT);
		mainHBox.getChildren().add(saveButton);
		
		return mainHBox;
	}
	
	
	@Override
	public Pane getRootNode() {
		return root;
	}

	@Override
	public void cleanup() {
	}
}
