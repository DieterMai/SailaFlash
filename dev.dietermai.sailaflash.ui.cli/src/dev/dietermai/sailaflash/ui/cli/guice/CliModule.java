package dev.dietermai.sailaflash.ui.cli.guice;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import dev.dietermai.sailaflash.ui.cli.Context;
import dev.dietermai.sailaflash.ui.cli.IContext;
import dev.dietermai.sailaflash.ui.cli.commands.BackCommand;
import dev.dietermai.sailaflash.ui.cli.commands.CreateQuestionCommand;
import dev.dietermai.sailaflash.ui.cli.commands.HelpCommand;
import dev.dietermai.sailaflash.ui.cli.commands.InputCommand;
import dev.dietermai.sailaflash.ui.cli.commands.InvalidCommand;
import dev.dietermai.sailaflash.ui.cli.commands.QuitCommand;
import dev.dietermai.sailaflash.ui.cli.io.IInput;
import dev.dietermai.sailaflash.ui.cli.io.IOutput;
import dev.dietermai.sailaflash.ui.cli.io.Input;
import dev.dietermai.sailaflash.ui.cli.io.Output;
import dev.dietermai.sailaflash.ui.cli.screen.InputScreen;
import dev.dietermai.sailaflash.ui.cli.screen.MainScreen;

public class CliModule extends AbstractModule {
	
	@Qualifier @Retention(RetentionPolicy.RUNTIME)
	@interface FirstScreen {}
	
	
	protected void configure() {
		bind(IOutput.class).to(Output.class).in(Scopes.SINGLETON); // TODO
		bind(IInput.class).to(Input.class).in(Scopes.SINGLETON); // TODO
		bind(IContext.class).to(Context.class).in(Scopes.SINGLETON); // TODO
		
		// Screens
		bind(Keys.rootState).to(MainScreen.class);
		bind(Keys.inputState).to(InputScreen.class);
		bind(Keys.mainState).to(MainScreen.class);
		
		// commands
		bind(Keys.backCommand).to(BackCommand.class);
		bind(Keys.helpCommand).to(HelpCommand.class);
		bind(Keys.inputCommand).to(InputCommand.class);
		bind(Keys.invalidCommand).to(InvalidCommand.class);
		bind(Keys.quitCommand).to(QuitCommand.class);
		bind(Keys.inputQuestionCommand).to(CreateQuestionCommand.class);
		
	}
}
