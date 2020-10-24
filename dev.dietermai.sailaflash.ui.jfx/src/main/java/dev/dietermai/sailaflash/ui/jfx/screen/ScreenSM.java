package dev.dietermai.sailaflash.ui.jfx.screen;

import java.util.LinkedList;

import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import dev.dietermai.sailaflash.ui.jfx.util.LoggingHelper;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ScreenSM<T extends IScreenGroup<T>> {
	private final LinkedList<IScreen> screenHistory = new LinkedList<>();
	private BorderPane root;
	private final IScreenProvider<T> screenProvider;
	private IScreen currentScreen;

	private boolean hasMinSize;
	private double minWidth;
	private double minHeight;
	
	public ScreenSM(final IScreenProvider<T> screenProvider){
		this.screenProvider = screenProvider;
	}
	
	public void setMinSize(double w, double h) {
		hasMinSize = true;
		minWidth = w;
		minHeight = h;
	}
	
	
	public void initialize() {
		currentScreen = screenProvider.getInitialScreen();
		screenHistory.add(currentScreen);
		currentScreen.initialize();
		root = new BorderPane(currentScreen.getRootNode());
		if(hasMinSize) {
			root.setMinSize(minWidth, minHeight);
		}
	}
	
	public Pane getRoot() {
		return root;
	}


	public void changeScreen(T screenType) {
		IScreen newScreen = screenProvider.get(screenType); 
		IScreen oldScreen = currentScreen; 
		
		root.getChildren().remove(oldScreen.getRootNode());
		oldScreen.cleanup();
		
		newScreen.initialize();
		root.setCenter(newScreen.getRootNode());
		currentScreen = newScreen;
	}
}
