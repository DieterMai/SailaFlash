package dev.dietermai.sailaflash.ui.jfx.content;

import dev.dietermai.sailaflash.ui.jfx.main.NavigationBar;
import dev.dietermai.sailaflash.ui.jfx.main.Widget;
import dev.dietermai.sailaflash.ui.jfx.main.NavigationBar.NavigationBarEntry;
import dev.dietermai.sailaflash.ui.jfx.screen.ScreenSM;
import javafx.beans.value.ObservableValue;

public class Content extends Widget<Content> {

	private static final double CONTENT_WIDTH = 992;
	private static final double CONTENT_HEIGHT = 480;
	
	
	private ScreenSM<ContentScreens> contentScreenSM;
	
	@Override
	public Content initialize() {
		contentScreenSM = new ScreenSM<>(new ContentScreenProvider());
		contentScreenSM.setMinSize(CONTENT_WIDTH, CONTENT_HEIGHT);
		contentScreenSM.initialize();
		
		super.setRoot(contentScreenSM.getRoot());
		
		return this;
	}

	public void setNavigationSelectionProperty(ObservableValue<NavigationBarEntry> nabigationSelectionProperty) {
		nabigationSelectionProperty.addListener((obs,old,neo) -> selectionChanged(neo));
	}
	
	private void selectionChanged(NavigationBarEntry entry) {
		ContentScreens screen = mapNavigationEntryToContentScreen(entry);
		if(screen != null) {
			contentScreenSM.changeScreen(screen);
		}
	}
	
	private ContentScreens mapNavigationEntryToContentScreen(NavigationBarEntry entry) {
		return switch(entry) {
		case home -> ContentScreens.home;
		case input -> ContentScreens.input;
		case library -> ContentScreens.library;
		case practice -> ContentScreens.practice;
		case reports -> ContentScreens.reports;
		default-> throw new IllegalArgumentException("invalid arguement: "+entry);
		};
	}
}
