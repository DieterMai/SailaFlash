package dev.dietermai.sailaflash.ui.cli.commands;

public record CommandDescription(
		String shortCommand,
		String longCommand,
		String description,
		String helpDescription) {
	
	public static final CommandDescription NULL = new CommandDescription("","","","");
}
