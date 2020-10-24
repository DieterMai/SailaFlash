package dev.dietermai.sailaflash.ui.cli;

import dev.dietermai.sailaflash.ui.cli.commands.ICommand;
import dev.dietermai.sailaflash.ui.cli.screen.ICliState;

public interface IContext {
	
	void pushScreen(ICliState screen);
	ICliState popScreen();
	ICliState getCurrentScreen();
	boolean hasScreenOnStack();
	
	void printCurrentHelp();
	void printInvalidCommandMessage(String userSelection);

	void updatePrompt();
	String getPrompt();
	ICommand getCommand(String commandString);
}
