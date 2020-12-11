package dev.dietermai.sailaflash.ui.cli.commands;

import java.util.List;

import javax.inject.Inject;

import dev.dietermai.sailaflash.ui.cli.CliUtil;
import dev.dietermai.sailaflash.ui.cli.IContext;
import dev.dietermai.sailaflash.ui.cli.io.IOutput;

public class HelpCommand extends AbstractCommand {
	private static final CommandDescription defaultDescription = new CommandDescription("h", "help", "To see this message again.",
			"""
			Usage: help COMMAND
			
			help
				Lists the commands that are allowed at this time.
			
			help COMMAND
				Prints the usage of the command.
			""");
	
	private final CommandDescription description;
	private final IOutput output;
	
	private List<String> splits;
	
	
	@Inject
	public HelpCommand(IOutput output) {
		description = defaultDescription;
		this.output = output;
	}
	
	public CommandDescription getDescription() {
		return description;
	}

	@Override
	public void execute(IContext context) {
		splits = CliUtil.splitCommandLine(getCommandLine());
		
		if(noArguments()) {
			context.printCurrentHelp();
		}else if(oneArgument()){
			printCommandHelp();
		}else {
			output.line("To many arguments in '"+getCommandLine()+"'");
			output.line(description.helpDescription());
		}
	}
	
	private boolean noArguments() {
		return splits.size() == 1;
	}
	
	private boolean oneArgument() {
		return splits.size() == 2;		
	}
	
	private void printCommandHelp() {
		String commandString = splits.get(1);
		ICommand command = context.getCommand(commandString);
		if(command == null) {
			output.line("'"+commandString+"' is not a valid command.");
		}else {
			output.line(command.getDescription().helpDescription());
		}
	}
}
