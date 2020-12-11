package dev.dietermai.sailaflash.ui.cli.screen;

import com.google.inject.Inject;
import com.google.inject.Injector;

import dev.dietermai.sailaflash.ui.cli.guice.Keys;

public class InputScreen extends AbstractScreen {

	private String question;
	private String answer;
	
	@Inject
	public InputScreen(Injector injector) {
		super(injector);
	}
	
	protected void initializeCommands() {
		// TODO create
		// TODO interactive
		
		commands.add(injector.getInstance(Keys.inputQuestionCommand));
		commands.add(injector.getInstance(Keys.backCommand));
		commands.add(injector.getInstance(Keys.helpCommand));
		commands.add(injector.getInstance(Keys.quitCommand));
	}

	@Override
	public String getPromtId() {
		return "input";
	}
}
