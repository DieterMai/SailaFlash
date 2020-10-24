package dev.dietermai.sailaflash.ui.jfx.widget.content;

import static dev.dietermai.sailaflash.ui.jfx.widget.content.ContentConstants.*;
import dev.dietermai.sailaflash.ui.jfx.Constants;
import dev.dietermai.sailaflash.ui.jfx.screen.IScreen;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class HomeScreen implements IScreen {

	private static final double COLUMN_WIDTH = 240;
	private static final double COLUMN_HEIGHT = 450;
	
	private static final Insets columnInsets = new Insets(15, 0, 15, 0);
	private static final Insets titleMargin = new Insets(0, 10, 19, 10);
	private static final Insets descriptionMargin = new Insets(0, 10, 0, 10);
	private static final Insets buttonMargin = new Insets(0, 10, 5, 10);
	
	
	
	private static final Font titleRegularFont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 16.5);
	private static final Font titleRegularSubFont = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 16.5);
	private static final Font titleItalicFont = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 16.5);
	private static final Font textFont = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12);
	private static final Font textBoldFont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 12);
	
	
			
	private HBox columsContainer;
	private VBox root;
	
	
	@Override
	public void initialize() {
		Node column1Content = getColumn1();
		Node column2Content = getColumn2();
		Node column3Content = getColumn3();
		Node column4Content = getColumn4();
		
		columsContainer = new HBox(5);
		columsContainer.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundContrast));
		columsContainer.getChildren().add(column1Content);
		columsContainer.getChildren().add(column2Content);
		columsContainer.getChildren().add(column3Content);
		columsContainer.getChildren().add(column4Content);
		columsContainer.setPadding(new Insets(0, 0, 0, 5));
		
		root = new VBox();
		root.setBackground(CONTENT_screenBackground);
		root.setPadding(CONTENT_screenPadding);
		root.getChildren().add(columsContainer);
	}
	
	private Node getColumn1() {
		Node title = createRegularColumnTitle("Choose study content");
		Node description = createDescription("Create or get you own content. You can either create your own flash cards or buy and import publisher content modules.");
		
		Button manualButton = getColumn1Button("Enter Items Manually", "manualEnter");
		Button importButton = getColumn1Button("Import content","download");
		
		VBox mainBox = new VBox();
		mainBox.setPadding(columnInsets);
		mainBox.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundContrast));
		mainBox.setPrefSize(COLUMN_WIDTH, COLUMN_HEIGHT);
		mainBox.getChildren().add(title);
		mainBox.getChildren().add(description);
		mainBox.getChildren().add(manualButton);
		mainBox.getChildren().add(importButton);
		VBox.setMargin(title, titleMargin);
		VBox.setMargin(description, descriptionMargin);
		VBox.setMargin(manualButton, buttonMargin);
		VBox.setMargin(importButton, buttonMargin);
		
		return mainBox;
	}
	
	private Button getColumn1Button(String text, String imageName) {
		Button button = new Button();
		button.setPrefSize(219, 86);
		button.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundNormal));
		
		ImageView image = new ImageView(FxUtil.getImage(imageName));
		Label title = new Label(text);
		title.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 16.5));
		title.setTextFill(Constants.COLOR_Forground);
		
		VBox box = new VBox(5);
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(image);
		box.getChildren().add(title);
		
		button.setGraphic(box);
		
		return button;
	}
	
	private Node getColumn2() {
		Node title = createItalicColumnTitle("Storage:");
		Node description = createDescription("Imported content has to be activated before you can start a practice session. Here you can see how many items are waiting and activate them easily.");
		Node tableTitle = createTableTitle("Activate flashcards for practice");
		Node tableCell  = createTableCell("MostUsed", "0");
		
		
		return createColumnBox(title,description,tableTitle,tableCell);
	}
	
	private Node getColumn3() {
		Node title = createItalicColumnTitle("Due in phase 1 to 5:");
		Node description = createDescription("How many items are waiting for activation (A)? How many items are due (P)?");
		Node tableTitle = createTableTitle("Start practice session");
		Node tableCell  = createTableCell("MostUsed", "A:0", "P:134");
		
		return createColumnBox(title,description,tableTitle,tableCell);
	}
	
	private Node getColumn4() {
		Node title = createItalicColumnTitle("phase 6:", "Long-term Memory");
		Node description = createDescription("These items have reached phase 6 andhave successfully been locked into your long-term memory.");
		Node tableTitle = createTableTitle("In long-term memory");
		Node tableCell  = createTableCell("MostUsed", "0");
		
		
		return createColumnBox(title,description,tableTitle,tableCell);
	}
	
	private Node createRegularColumnTitle(String titleText) {
		Label title = new Label(titleText);
		title.setFont(titleRegularFont);
		return title;
	}
	
	private Node createItalicColumnTitle(String titleText) {
		return createItalicColumnTitle(titleText, null);
	}
	
	private Node createItalicColumnTitle(String titleText, String titleText2) {
		HBox vbox = new HBox(3);
		
		if(titleText != null) {
			Label title = new Label(titleText);
			title.setFont(titleItalicFont);
			vbox.getChildren().add(title);
		}
		if(titleText2 != null) {
			Label title = new Label(titleText2);
			title.setFont(titleRegularSubFont);
			vbox.getChildren().add(title);
		}
		
		return vbox;
	}
	
	private Node createDescription(String text) {
		Label description = new Label(text);
		description.setFont(textFont);
		description.setWrapText(true);
		description.setPrefHeight(93);
		description.setAlignment(Pos.TOP_LEFT);
		return description;
	}
	
	private Node createTableTitle(String text) {
		Label tableTitle = new Label(text);
		tableTitle.setFont(textBoldFont);
		tableTitle.setTextFill(Constants.COLOR_BackgroundNormal);
				
		HBox tableTitlePane = new HBox();
		tableTitlePane.setBackground(FxUtil.getBg(Constants.COLOR_Forground));
		tableTitlePane.setPrefSize(235, 29);
		tableTitlePane.setPadding(new Insets(8, 10, 8, 10));
		tableTitlePane.getChildren().add(tableTitle);
		return tableTitlePane;
	}
	
	private Node createTableCell(String stackName, String right1) {
		return createTableCell(stackName, right1, "");
	}
	
	private Node createTableCell(String stackName, String right1, String right2) {
		Label stackLabel = new Label(stackName);
		stackLabel.setFont(textFont);

		Label label1 = new Label(right1);
		label1.setFont(textFont);

		Label label2 = new Label(right2);
		label2.setFont(textFont);
		
		
		GridPane.setConstraints(stackLabel, 0, 0, 1, 1, HPos.LEFT, VPos.TOP, Priority.ALWAYS, Priority.NEVER );
		GridPane.setConstraints(label1, 1, 0, 1, 1, HPos.RIGHT, VPos.TOP, Priority.NEVER, Priority.NEVER);
		GridPane.setConstraints(label2, 1, 1, 1, 1, HPos.RIGHT, VPos.TOP, Priority.NEVER, Priority.NEVER);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(8, 10, 8, 10));
		grid.getChildren().add(stackLabel);
		grid.getChildren().add(label1);
		grid.getChildren().add(label2);
		
		return grid;
		
	}
	
	private Node createColumnBox(Node title, Node description, Node tableTitle, Node tableCell) {
		VBox mainBox = new VBox();
		mainBox.setBackground(FxUtil.getBg(Constants.COLOR_BackgroundNormal));
		mainBox.setPadding(columnInsets);
		mainBox.setPrefSize(COLUMN_WIDTH, COLUMN_HEIGHT);
		mainBox.getChildren().add(title);
		mainBox.getChildren().add(description);
		mainBox.getChildren().add(tableTitle);
		mainBox.getChildren().add(tableCell);
		VBox.setMargin(title, titleMargin);
		VBox.setMargin(description, descriptionMargin);
		
		return mainBox;
	}
	
	@Override
	public Pane getRootNode() {
		return root;
	}

	@Override
	public void cleanup() {
	}
}
