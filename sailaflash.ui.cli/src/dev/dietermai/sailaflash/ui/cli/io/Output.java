package dev.dietermai.sailaflash.ui.cli.io;

import javax.inject.Singleton;

@Singleton
public class Output implements IOutput {
	
	public void line(String s) {
		System.out.println(s);
	}

	public void out(String s) {
		System.out.print(s);
	}
}
