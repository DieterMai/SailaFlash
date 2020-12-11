package dev.dietermai.sailaflash.ui.cli.io;

public interface IInput extends AutoCloseable{
	String readLine(String prompt);
}
