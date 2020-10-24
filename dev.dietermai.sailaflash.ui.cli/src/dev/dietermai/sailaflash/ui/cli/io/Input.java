package dev.dietermai.sailaflash.ui.cli.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class Input implements IInput {
	
	@Inject
	private IOutput output;
	
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public String readLine(String prompt) {
		try {
			output.line("");
			output.out(prompt);
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void close() throws Exception {
		reader.close();
	}
}
