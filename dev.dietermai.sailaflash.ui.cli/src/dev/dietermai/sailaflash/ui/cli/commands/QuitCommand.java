package dev.dietermai.sailaflash.ui.cli.commands;

import dev.dietermai.sailaflash.ui.cli.IContext;

public class QuitCommand extends AbstractCommand {
	private static CommandDescription defaultDescription = new CommandDescription("q", "quit", "To quit this application.",
			"""
			Usage: quit
			
			quit	Quits the application without saving.		
			""");
	
	private final CommandDescription description;
	
	public QuitCommand() {
		description = defaultDescription;
	}
	
	public CommandDescription getDescription() {
		return description;
	}

	@Override
	public void execute(IContext context) {
		while(context.hasScreenOnStack()) {
			context.popScreen();
		}
	}
}
