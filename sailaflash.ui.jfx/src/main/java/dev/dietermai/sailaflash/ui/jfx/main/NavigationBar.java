package dev.dietermai.sailaflash.ui.jfx.main;

import static dev.dietermai.sailaflash.ui.jfx.util.FxUtil.getImage;

import java.util.HashMap;
import java.util.Map;

import dev.dietermai.sailaflash.ui.jfx.Constants;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class NavigationBar extends Widget<NavigationBar> {
	public enum NavigationBarEntry { home, input, practice, library, reports}

	
	private static final int HIGHT_PREF_LOWERBUTTON = 30;
	
	private final Button homeButton;
	private final Button inputButton; 
	private final Button practiceButton;
	private final Button libraryButton;
	private final Button reportsButton;
	private final HBox navigationMenuBox;
	
	private final ReadOnlyObjectWrapper<NavigationBarEntry> selectedPage = new ReadOnlyObjectWrapper<>();
	public ReadOnlyObjectProperty<NavigationBarEntry> selectedPage() { return selectedPage.getReadOnlyProperty(); }
	public NavigationBarEntry getSelectedPage() { return selectedPage().get(); }
	private void setSelectedPage(NavigationBarEntry entry) { selectedPage.set(entry); }
	
	private final ReadOnlyObjectWrapper<NavigationBarEntry> hoverPage = new ReadOnlyObjectWrapper<>();
	public ReadOnlyObjectProperty<NavigationBarEntry> hoverPage() { return hoverPage.getReadOnlyProperty(); }
	public NavigationBarEntry getHoverPage() { return hoverPage().get(); }
	private void setHoverPage(NavigationBarEntry entry) { hoverPage.set(entry); }
	
	private final ReadOnlyObjectWrapper<Bounds> selectedPageBounds = new ReadOnlyObjectWrapper<>();
	public ReadOnlyObjectProperty<Bounds> selectedPageBounds() { return selectedPageBounds.getReadOnlyProperty(); }
	public Bounds getSelectedPageBounds() { return selectedPageBounds().get(); }
//	private void setSelectedPage(Bounds entry) { activePageBounds.set(entry); }
	
	private final ReadOnlyObjectWrapper<Bounds> hoverPageBounds = new ReadOnlyObjectWrapper<>();
	public ReadOnlyObjectProperty<Bounds> hoverPageBounds() { return hoverPageBounds.getReadOnlyProperty(); }
	public Bounds getHoverPageBounds() { return hoverPageBounds().get(); }
	private void setHoverPageBounds(Bounds entry) { hoverPageBounds.set(entry); }
	
	private final Map<Button, NavigationBarEntry> buttonEntryMap = new HashMap<>();
	private Button currentSelection;
	private Button currentHover;
	
	
	public NavigationBar() {
		ImageView homeImage = new ImageView(getImage("home"));
		homeButton = createLowerMenuButton("", homeImage, NavigationBarEntry.home);
		inputButton = createLowerMenuButton("INPUT", NavigationBarEntry.input);
		practiceButton = createLowerMenuButton("PRACTICE", NavigationBarEntry.practice);
		libraryButton = createLowerMenuButton("LIBRARY", NavigationBarEntry.library);
		reportsButton = createLowerMenuButton("REPORTS", NavigationBarEntry.reports);

		navigationMenuBox = new HBox();
		navigationMenuBox.setAlignment(Pos.BOTTOM_LEFT);
		navigationMenuBox.getChildren().add(homeButton);
		navigationMenuBox.getChildren().add(inputButton);
		navigationMenuBox.getChildren().add(practiceButton);
		navigationMenuBox.getChildren().add(libraryButton);
		navigationMenuBox.getChildren().add(reportsButton);
		
		swapSelection(homeButton);
		applyNewSelection();
	}
	
	
	private Button createLowerMenuButton(String text, NavigationBarEntry page) {
		return createLowerMenuButton(text, null, page);
	}
	
	
	private Button createLowerMenuButton(String text, Node graphic, NavigationBarEntry page) {
		Button button = new Button(text, graphic);
		button.setPrefHeight(HIGHT_PREF_LOWERBUTTON);
		button.setBackground(null);
		button.setPadding(new Insets(11, 17, 11, 17));
		button.setFont(Font.font(null,FontWeight.BOLD,17));
		button.setTextFill(Color.rgb(58, 122, 80));
		button.setOnAction(this::buttonSelected);
		button.setOnMouseMoved(this::buttonHover);
		button.setOnMouseExited(this::buttonExit);
		
		buttonEntryMap.put(button, page);
		
		return button;
	}

	@Override
	public Node getRoot() {
		return navigationMenuBox;
	}
	
	private void buttonSelected(ActionEvent actionEvent) {
		swapSelection((Button) actionEvent.getSource());
	}
	
	private void swapSelection(Button newSelection) {
		Button oldSelection = currentSelection;
		currentSelection = newSelection;
		clearOldSelection(oldSelection);
		applyNewSelection();
	}
	
	private void clearOldSelection(Button oldSelection) {
		setButtonColor(oldSelection);
		selectedPageBounds.unbind();
	}
	
	private void applyNewSelection() {
		if(currentSelection != null) {
			setButtonColor(currentSelection);
			setSelectedPage(buttonEntryMap.get(currentSelection));
			selectedPageBounds.bind(currentSelection.boundsInParentProperty());
		}
	}
	
	private void buttonHover(MouseEvent mouseEvent) {
		swapHover((Button) mouseEvent.getSource());
	}
	
	private void swapHover(Button newHover) {
		Button oldHover = currentHover;
		currentHover = newHover;
		clearOldHover(oldHover);
		applyNewHover();
	}
	
	private void clearOldHover(Button oldHover) {
		setButtonColor(oldHover);
		setHoverPage(null);
		hoverPageBounds.unbind();
		setHoverPageBounds(null);
	}
	
	private void applyNewHover() {
		if(currentHover != null) {
			setButtonColor(currentHover);
			setHoverPage(buttonEntryMap.get(currentHover));
			hoverPageBounds.bind(currentHover.boundsInParentProperty());
		}
	}
	
	private void buttonExit(MouseEvent mouseEvent) {
		swapHover(null);
	}

	private void setButtonColor(Button button) {
		if(button != null) {
			if(button == currentSelection || button == currentHover) {
				button.setTextFill(Constants.COLOR_Highlight);
			}else {
				button.setTextFill(Constants.COLOR_Forground);
			}
		}
	}
	
	@Override
	public NavigationBar initialize() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
