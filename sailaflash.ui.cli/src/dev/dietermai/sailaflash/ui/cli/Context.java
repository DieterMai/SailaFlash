package dev.dietermai.sailaflash.ui.cli;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import dev.dietermai.sailaflash.ui.cli.commands.ICommand;
import dev.dietermai.sailaflash.ui.cli.screen.ICliState;

public class Context implements IContext {

	private final Deque<ICliState> screenStack = new ArrayDeque<>();
	private String prompt = "> ";
	
	@Override
	public void pushScreen(ICliState screen) {
		screenStack.push(screen);
	}

	@Override
	public ICliState popScreen() {
		return screenStack.pop();
	}

	@Override
	public void printCurrentHelp() {
		screenStack.peek().printHelpMessage();
	}

	@Override
	public void printInvalidCommandMessage(String userSelection) {
		screenStack.peek().printInvalidCommandMessage(userSelection);
	}

	@Override
	public ICliState getCurrentScreen() {
		return screenStack.peek();
	}

	@Override
	public boolean hasScreenOnStack() {
		return getCurrentScreen() != null;
	}

	@Override
	public void updatePrompt() {
		StringBuilder sb = new StringBuilder();
		Iterator<ICliState> iter = screenStack.descendingIterator();
		while(iter.hasNext()) {
			sb.append(iter.next().getPromtId()).append(" > ");
		}
		prompt = sb.toString();
	}

	@Override
	public String getPrompt() {
		return prompt;
	}

	@Override
	public ICommand getCommand(String commandString) {
		ICliState currentScreen = screenStack.peek();
		for(ICommand command : currentScreen.getCommands()) {
			if(command.match(commandString)) {
				return command;
			}
		}
		return null;
	}
}
