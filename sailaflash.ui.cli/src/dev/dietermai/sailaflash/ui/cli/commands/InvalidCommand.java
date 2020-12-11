package dev.dietermai.sailaflash.ui.cli.commands;

import dev.dietermai.sailaflash.ui.cli.IContext;

public class InvalidCommand extends AbstractCommand {

	private String userSelection;
	
	public void setCommandLine(String userSelection) {
		this.userSelection = userSelection;
	}
	
	@Override
	public CommandDescription getDescription() {
		return CommandDescription.NULL;
	}
	

	@Override
	public void execute(IContext context) {
		context.printInvalidCommandMessage(userSelection);
	}
}
