package dev.dietermai.sailaflash.ui.cli.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import javax.inject.Inject;

import dev.dietermai.sailaflash.ui.cli.IContext;

public abstract class AbstractCommand implements ICommand {

	@Inject
	protected IContext context;
	
	private String commandLine;
	
	@Override
	public CommandDescription getDescription() {
		return null;
	}

	@Override
	public void setCommandLine(String commandLine) {
		this.commandLine = commandLine;
	}
	
	public String getCommandLine() {
		return commandLine;
	}

	@Override
	public void execute(IContext context) {
	}
	
	@Override
	public boolean match(String s){
		CommandDescription description = requireNonNull(getDescription());
		requireNonNull(s);
		if(s.isBlank()) {
			return false;
		}
		s = s.trim();
		if(s.indexOf(' ') > -1) {
			s = s.substring(0, s.indexOf(' '));
		}
		
		
		if(Objects.equals(s, description.shortCommand())) {
			return true;
		}
		
		if(Objects.equals(s, description.longCommand())) {
			return true;
		}
		
		return false;
	}
}
