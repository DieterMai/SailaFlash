package dev.dietermai.sailaflash.ui.cli.screen;

import com.google.inject.Inject;
import com.google.inject.Injector;

import dev.dietermai.sailaflash.ui.cli.guice.Keys;

public class MainScreen extends AbstractScreen {

	@Inject
	public MainScreen(Injector injector) {
		super(injector);
	}
	
	protected void initializeCommands() {
//		commands.add(new CommandDescription(1, "e", "exercise", "To start exercising the flash cards currently due."));
//		commands.add(new CommandDescription(2, "c", "custom", "To configure a custom set of flash cards to exercise."));
//		commands.add(new CommandDescription(3, "i", "input", "To input new flash cards."));
//		commands.add(new CommandDescription(4, "t", "statistic", "To see statistics."));
//		commands.add(new CommandDescription(5, "s", "settings", "To change settings."));
		
		commands.add(injector.getInstance(Keys.inputCommand));
		commands.add(injector.getInstance(Keys.helpCommand));
		commands.add(injector.getInstance(Keys.quitCommand));
	}

	@Override
	public String getPromtId() {
		return "Saila Flash";
	}
}
