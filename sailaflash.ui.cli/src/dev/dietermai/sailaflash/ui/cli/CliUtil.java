package dev.dietermai.sailaflash.ui.cli;

import java.util.List;

import com.google.common.base.Splitter;

import dev.dietermai.sailaflash.ui.cli.commands.ICommand;

public enum CliUtil {
	;
	
	public static String formatCommandOptions(List<ICommand> commands) {
		
		int shortOption = 0;
		int longOption = 0;
		
		for(ICommand command : commands) {
			shortOption = Math.max(shortOption, command.getDescription().shortCommand().length());
			longOption = Math.max(longOption, command.getDescription().longCommand().length());
		}
		
		StringBuilder sb = new StringBuilder();
		for(ICommand command : commands) {
			sb.append(leadingSpaces("["+command.getDescription().shortCommand()+"]",shortOption+2)).append(" ");
			sb.append(tailingSpaces("["+command.getDescription().longCommand()+"]",longOption+2)).append(" ");
			sb.append(command.getDescription().description()).append("\n");
		}
		return sb.toString();
	}
	
	public static String leadingSpaces(String s, int lenght) {
		char[] newChars = new char[lenght];
		for(int i = 0; i < lenght-s.length(); i++) {
			newChars[i] = ' ';
		}
		for(int i = lenght-s.length(), j = 0; i < lenght; i++, j++) {
			newChars[i] = s.charAt(j);
		}
		return new String(newChars);
	}
	
	public static String tailingSpaces(String s, int lenght) {
		char[] newChars = new char[lenght];
		for(int i = 0; i < s.length(); i++) {
			newChars[i] = s.charAt(i);
		}
		for(int i = s.length(); i < lenght; i++) {
			newChars[i] = ' ';
		}
		return new String(newChars);
	}
	
	public static List<String> splitCommandLine(String commandLine) {
		return Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(commandLine);
	}
}
