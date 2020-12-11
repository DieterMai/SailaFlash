package dev.dietermai.sailaflash.ui.cli.commands;

import javax.inject.Inject;

import dev.dietermai.sailaflash.ui.cli.IContext;
import dev.dietermai.sailaflash.ui.cli.io.IOutput;

public class CreateQuestionCommand extends AbstractCommand {
	private static final CommandDescription defaultDescription = new CommandDescription("u", "question", "Enter the question to this flash card.",
			"""
			Usage: question QUESTION_TEXT
			
			question QUESTION_TEXT
				Sets the question text of the flash card. 
				If called multiple times, only the last input is used as question.
			""");
	
	private final CommandDescription description;
	private final IOutput output;
	
	
	
	@Inject
	public CreateQuestionCommand(IOutput output) {
		description = defaultDescription;
		this.output = output;
	}
	
	public CommandDescription getDescription() {
		return description;
	}

	@Override
	public void execute(IContext context) {
		String commandLine = getCommandLine();
		
		System.out.println("CreateQuestionCommand.execute() commandLine: "+commandLine);
		
	}
}
