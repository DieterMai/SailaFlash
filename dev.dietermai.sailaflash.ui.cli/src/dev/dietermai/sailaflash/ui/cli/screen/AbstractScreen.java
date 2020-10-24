package dev.dietermai.sailaflash.ui.cli.screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Injector;

import dev.dietermai.sailaflash.ui.cli.CliUtil;
import dev.dietermai.sailaflash.ui.cli.IContext;
import dev.dietermai.sailaflash.ui.cli.commands.ICommand;
import dev.dietermai.sailaflash.ui.cli.io.IInput;
import dev.dietermai.sailaflash.ui.cli.io.IOutput;

public abstract class AbstractScreen implements ICliState {

	protected final Injector injector;
	protected final IOutput output;
	protected final IInput input;
	protected final IContext context;

	protected List<ICommand> commands = new ArrayList<>();

	@Inject
	public AbstractScreen(Injector injector) {
		this.injector = injector;
		this.output = injector.getInstance(IOutput.class);
		this.input = injector.getInstance(IInput.class);
		this.context = injector.getInstance(IContext.class);
	}
	
	@Override
	public void initialize() {
		initializeCommands();
	}

	protected abstract void initializeCommands();

	public void showScreen() {
		printHelpMessage(); // TODO make configurable
	}
	
	public List<ICommand> getCommands(){
		return Collections.unmodifiableList(commands);
	}

	@Override
	public void printHelpMessage() {
		output.line("Select one of this options:");
		output.line(CliUtil.formatCommandOptions(commands));
	}

	@Override
	public void printInvalidCommandMessage(String userSelection) {
		output.line("Invalid command '" + userSelection + "'. Please select valid command.");
		printHelpMessage();
	}
}
