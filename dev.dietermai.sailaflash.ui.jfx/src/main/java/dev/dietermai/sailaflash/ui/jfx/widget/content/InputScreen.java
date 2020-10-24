package dev.dietermai.sailaflash.ui.jfx.widget.content;

import static dev.dietermai.sailaflash.ui.jfx.widget.content.ContentConstants.CONTENT_screenBackground;

import dev.dietermai.sailaflash.ui.jfx.Constants;
import dev.dietermai.sailaflash.ui.jfx.screen.IScreen;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class InputScreen implements IScreen {

	private VBox root;
	
	@Override
	public void initialize() {
		Node topButtonBar = createUpperMenu();
		Node cardSection = createCardSection();
		Node bottonButtonBar = createSaveSection();
		
		VBox.setVgrow(cardSection, Priority.ALWAYS);
		
		root = new VBox();
		root.setBackground(CONTENT_screenBackground);
		root.getChildren().add(topButtonBar);
		root.getChildren().add(cardSection);
		root.getChildren().add(bottonButtonBar);
	}
	
	private Node createUpperMenu() {
		Node mounten = createMountenImage();
		Node spellcheck = createMenuButton("Spellchecker", "spellcheck");
		Node symbols = createMenuButton("Show Symbols", "symbols");
		Node format = createMenuButton("Format Text", "format");
		Node image = createMenuButton("Image", "image");
		Node music = createMenuButton("Audio", "music");
		Node video = createMenuButton("Video", "video");
		Node record = createMenuButton("Record", "record");
		
		HBox leftBox = new HBox();
		leftBox.getChildren().add(mounten);
		leftBox.getChildren().add(spellcheck);
		
		HBox centerBox = new HBox();
		centerBox.setAlignment(Pos.CENTER);
		centerBox.getChildren().add(symbols);
		centerBox.getChildren().add(format);
		
		HBox rightBox = new HBox();
		rightBox.getChildren().add(image);
		rightBox.getChildren().add(music);
		rightBox.getChildren().add(video);
		rightBox.getChildren().add(record);
		
		HBox.setHgrow(centerBox, Priority.ALWAYS);
		
		HBox buttonBox = new HBox();
		buttonBox.getChildren().add(leftBox);
		buttonBox.getChildren().add(centerBox);
		buttonBox.getChildren().add(rightBox);
		return buttonBox;
	}
	
	private Node createMountenImage() {
		ImageView image = new ImageView(FxUtil.getImage("mounten"));
		
		HBox panel = new HBox();
		panel.setPrefSize(130, 80);
		panel.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundContrast, new CornerRadii(6, 0, 0, 0, false)));
		panel.setPadding(new Insets(13, 0, 0, 15));
		panel.getChildren().add(image);
		
		
		return panel;
	}
	
	private Node createMenuButton(String title, String imageName) {
		ImageView image = new ImageView(FxUtil.getImage(imageName));
		Label  text = new Label(title);
		
		VBox box = new VBox(-2);
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(image);
		box.getChildren().add(text);
		
		Button button = new Button();
		button.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundNormal));
		button.setGraphic(box);
		button.setPrefHeight(80);
		button.setPadding(new Insets(13, 12, 14, 12));
		
		return button;
	}
	
	private Node createCardSection() {
		Node metaBox = createCardMetaSection();
		Node questionBox = createCardQuestionSection();
		Node answerBox = createCardAnswerSection();
		
		HBox.setHgrow(questionBox, Priority.ALWAYS);
		HBox.setHgrow(answerBox, Priority.ALWAYS);
		
		HBox mainHBox = new HBox(5);
		mainHBox.getChildren().add(metaBox);
		mainHBox.getChildren().add(questionBox);
		mainHBox.getChildren().add(answerBox);
		
		return mainHBox;
	}
	
	private Node createCardMetaSection() {
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
		
		return metaBox;
	}
	
	private Node createCardQuestionSection() {
		Label metaTitle = new Label("Enter Question");
		TextArea questionTestArea = new TextArea();
		
		VBox.setVgrow(questionTestArea, Priority.ALWAYS);
		
		VBox metaBox = new VBox(10);
		metaBox.setPadding(new Insets(10));
		metaBox.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundContrast));
		metaBox.getChildren().add(metaTitle);
		metaBox.getChildren().add(questionTestArea);
		
		return metaBox;
	}
	
	private Node createCardAnswerSection() {
		Label metaTitle = new Label("Enter Answer");
		TextArea anwerTestArea = new TextArea();
		
		VBox.setVgrow(anwerTestArea, Priority.ALWAYS);
		
		VBox metaBox = new VBox(10);
		metaBox.setPadding(new Insets(10));
		metaBox.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundContrast));
		metaBox.getChildren().add(metaTitle);
		metaBox.getChildren().add(anwerTestArea);
		
		return metaBox;
	}
	
	private Node createSaveSection() {
		
		Button saveButton = new Button("Save and Next");
		
		HBox mainHBox = new HBox(5);
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
