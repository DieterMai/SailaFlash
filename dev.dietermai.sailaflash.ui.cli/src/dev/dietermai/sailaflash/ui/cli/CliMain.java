package dev.dietermai.sailaflash.ui.cli;

import com.google.inject.Guice;
import com.google.inject.Injector;

import dev.dietermai.sailaflash.ui.cli.guice.CliModule;
import dev.dietermai.sailaflash.ui.cli.screen.ScreenProcessor;

public class CliMain {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new CliModule());
		
		ScreenProcessor traverse = injector.getInstance(ScreenProcessor.class);
		
		traverse.startTraversel();
	}

}
