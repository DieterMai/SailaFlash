package dev.dietermai.sailaflash.ui.jfx.input;

import dev.dietermai.sailaflash.ui.jfx.Constants;
import dev.dietermai.sailaflash.ui.jfx.inject.PMI;
import dev.dietermai.sailaflash.ui.jfx.main.Widget;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class InputMenuBar extends Widget<InputMenuBar>{

	@Override
	public InputMenuBar initialize() {
		PMI.pmi.set(this);
		
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
		
		setRoot(buttonBox);
		
		return this;
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
}
