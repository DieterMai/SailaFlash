package dev.dietermai.sailaflash.ui.cli.commands;

import dev.dietermai.sailaflash.ui.cli.IContext;

public interface ICommand {
	CommandDescription getDescription();
	void setCommandLine(String commandLine);
	String getCommandLine();
	void execute(IContext context);
	boolean match(String s);
	
	
}
