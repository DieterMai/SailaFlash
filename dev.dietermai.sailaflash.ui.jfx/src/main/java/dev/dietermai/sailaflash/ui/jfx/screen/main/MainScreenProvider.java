package dev.dietermai.sailaflash.ui.jfx.screen.main;

import dev.dietermai.sailaflash.ui.jfx.screen.IScreen;
import dev.dietermai.sailaflash.ui.jfx.screen.IScreenProvider;

public class MainScreenProvider implements IScreenProvider<MainScreens> {
	
	public IScreen get(MainScreens screenType) {
		return switch(screenType) {
		case main -> new MainScreen();
		default -> throw new IllegalArgumentException("Unsupported screen type: '"+screenType+"'");
		};
		
	}

	@Override
	public IScreen getInitialScreen() {
		return get(MainScreens.main);
	}
}
