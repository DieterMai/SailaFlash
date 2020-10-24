package dev.dietermai.sailaflash.ui.jfx.widget.content;

import dev.dietermai.sailaflash.ui.jfx.screen.IScreen;
import dev.dietermai.sailaflash.ui.jfx.screen.IScreenProvider;

public class ContentScreenProvider implements IScreenProvider<ContentScreens> {

	@Override
	public IScreen getInitialScreen() {
		return get(ContentScreens.home);
	}

	@Override
	public IScreen get(ContentScreens screenType) {
		return switch(screenType) {
		case home -> new HomeScreen();
		case input -> new InputScreen();
		case library -> new LibraryScreen();
		case practice -> new PracticeScreen();
		case reports -> new ReportsScreen();
		default -> throw new IllegalArgumentException("Unexpected value: " + screenType);
		};
	}

}
