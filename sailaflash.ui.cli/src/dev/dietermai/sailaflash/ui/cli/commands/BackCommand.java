package dev.dietermai.sailaflash.ui.cli.commands;

import dev.dietermai.sailaflash.ui.cli.IContext;

public class BackCommand extends AbstractCommand {
	private static CommandDescription defaultDescription = new CommandDescription("b", "back", "Transition to the previous state.",
			"""
			Usage: back 
			
			back	transitions to the previous state in the state breadcrumb.	
			""");
	
	private final CommandDescription description;
	
	public BackCommand() {
		description = defaultDescription;
	}
	
	public CommandDescription getDescription() {
		return description;
	}

	@Override
	public void execute(IContext context) {
		context.popScreen();
	}
}
