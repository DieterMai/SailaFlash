package dev.dietermai.sailaflash.ui.cli.screen;

import java.util.List;

import dev.dietermai.sailaflash.ui.cli.commands.ICommand;

public interface ICliState {
	void initialize();
	void showScreen();
	List<ICommand> getCommands();
	void printHelpMessage();
	void printInvalidCommandMessage(String userSelection);
	String getPromtId();
}
