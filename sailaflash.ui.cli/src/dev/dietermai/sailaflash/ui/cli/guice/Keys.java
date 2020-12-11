package dev.dietermai.sailaflash.ui.cli.guice;

import com.google.inject.Key;
import com.google.inject.name.Names;

import dev.dietermai.sailaflash.ui.cli.commands.ICommand;
import dev.dietermai.sailaflash.ui.cli.screen.ICliState;

public enum Keys {
	;
	
	public static Key<ICliState> rootState = screenKey("first");
	public static Key<ICliState> mainState = screenKey("main");
	public static Key<ICliState> inputState = screenKey("input");
	public static Key<ICliState> createCardState = screenKey("createFlash");
	
	
	
	public static Key<ICommand> inputCommand = commandKey("input");
	public static Key<ICommand> backCommand = commandKey("back");
	public static Key<ICommand> helpCommand = commandKey("help");
	public static Key<ICommand> quitCommand = commandKey("quit");
	public static Key<ICommand> inputQuestionCommand = commandKey("inputQuestion");
	public static Key<ICommand> invalidCommand = commandKey("invalid");
	
	private static Key<ICliState> screenKey(String name){
		return Key.get(ICliState.class,Names.named(name));
	}
	
	private static Key<ICommand> commandKey(String name){
		return Key.get(ICommand.class,Names.named(name));
	}
}
