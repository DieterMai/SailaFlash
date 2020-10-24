package dev.dietermai.sailaflash.ui.jfx.widget;

import static dev.dietermai.sailaflash.ui.jfx.Constants.*;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * @author Dieter
 *
 */
public class TopMenu extends Widget<TopMenu> {

	private Button extrasButton;
	private Button helpButton;
	private Button switchUserButton;
	private Button quitButton;
	
	private HBox topMenuBox;
	
	public TopMenu() {
		extrasButton = createUpperMenuButton("Extras", true, false);
		helpButton = createUpperMenuButton("Help", false, false);
		switchUserButton = createUpperMenuButton("Switch User", false, false);
		quitButton = createUpperMenuButton("Quit", false, true);
		
		topMenuBox = new HBox(3);
		topMenuBox.getChildren().add(extrasButton);
		topMenuBox.getChildren().add(helpButton);
		topMenuBox.getChildren().add(switchUserButton);
		topMenuBox.getChildren().add(quitButton);
	}
	
	@Override
	public Node getRoot() {
		return topMenuBox;
	}
	
	private Button createUpperMenuButton(String text, boolean mostLeft, boolean mostRight) {
		double radiBottomLeft = mostLeft ? 5 : 0;
		double radiBottomRight = mostRight ? 5 : 0;
		
		Button button = new Button(text);
		button.setFont(Font.font(12));
		button.setPadding(new Insets(3, 15, 4, 15));
		button.setBackground(FxUtil.getBg(COLOR_BackgroundContrast, new CornerRadii(0, 0, radiBottomRight, radiBottomLeft, false)));
		button.setPrefHeight(HIGHT_PREF_UPPERBUTTON);
		return button;
	}

	@Override
	public TopMenu initialize() {
		// TODO Auto-generated method stub
		return null;
	}

}
