package dev.dietermai.sailaflash.ui.cli.screen;

import javax.inject.Inject;

import com.google.inject.Injector;

import dev.dietermai.sailaflash.ui.cli.IContext;
import dev.dietermai.sailaflash.ui.cli.commands.ICommand;
import dev.dietermai.sailaflash.ui.cli.guice.Keys;
import dev.dietermai.sailaflash.ui.cli.io.IInput;
import dev.dietermai.sailaflash.ui.cli.io.IOutput;

public class ScreenProcessor {
	
	private final Injector injector;
	private final ICliState firstScreen;
	private final IContext context;
	private final IOutput output;
	private final IInput input;
	
	@Inject
	public ScreenProcessor(Injector injector) {
		this.injector = injector;
		firstScreen = injector.getInstance(Keys.rootState);
		context = injector.getInstance(IContext.class);
		output = injector.getInstance(IOutput.class);
		input = injector.getInstance(IInput.class);
	}
	
	public void startTraversel() {
		output.line("Welcome to Saila Flash. ");
		
		ICliState currentScreen = firstScreen;
		context.pushScreen(currentScreen);

		currentScreen.initialize();
		currentScreen.showScreen();
		
		do {
			context.updatePrompt();
			String userSelection = getUserInput();
			handleUserInput(userSelection);
		}while(context.getCurrentScreen() != null);
		
		output.line("Exiting Saila Flash.");
	}
	
	private String getUserInput() {
		
		return input.readLine(context.getPrompt());
	}
	

	private void handleUserInput(String userSelection) {
		for (ICommand command : context.getCurrentScreen().getCommands()) {
			if (command.match(userSelection)) {
				command.setCommandLine(userSelection);
				command.execute(context);
				return;
			}
		}
		ICommand invalidCommand = injector.getInstance(Keys.invalidCommand); // TODO
		invalidCommand.setCommandLine(userSelection);
		invalidCommand.execute(context);
	}

	

}
