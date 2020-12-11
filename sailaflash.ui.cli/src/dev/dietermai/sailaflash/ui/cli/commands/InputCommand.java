package dev.dietermai.sailaflash.ui.cli.commands;

import javax.inject.Inject;

import com.google.inject.Injector;

import dev.dietermai.sailaflash.ui.cli.IContext;
import dev.dietermai.sailaflash.ui.cli.guice.Keys;
import dev.dietermai.sailaflash.ui.cli.screen.ICliState;

public class InputCommand extends AbstractCommand {
	private static CommandDescription defaultDescription = new CommandDescription("i", "input", "Enter the question to this flash card.",
			"""
			Usage: input
			  or:  input OPTION...
			
			input 
				Starts the input of a flash card in an interactive mode.
			
			input OPTION...
				Creates a flash card with the given arguments.
			
			Options:
			-q QUESTION		Sets the question of the flash card. Required.
			-a ANSWER		Sets the answer of the flash card. Required.
			-t TAG...		Comma separated list of tags.
			-c CATEGORY		Sets the category of the flash card.
			-s SUBJECT		Sets the subject of the flash card.
			""");
	
	@Inject
	private Injector injector;
	
	private final CommandDescription description;
	
	public InputCommand() {
		description = defaultDescription;
	}
	
	public CommandDescription getDescription() {
		return description;
	}

	@Override
	public void execute(IContext context) {
		ICliState inputState = injector.getInstance(Keys.inputState);
		inputState.initialize();
		context.pushScreen(inputState);
	}
	
}
