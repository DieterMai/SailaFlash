module dev.dietermai.sailaflash.ui.cli {
	requires java.base;
	
	requires javax.inject;

	requires com.google.guice;
	requires com.google.common;

	requires dev.dietermai.sailaflash.bl;

	opens dev.dietermai.sailaflash.ui.cli;
	opens dev.dietermai.sailaflash.ui.cli.commands;
	opens dev.dietermai.sailaflash.ui.cli.io;
	opens dev.dietermai.sailaflash.ui.cli.screen;
	
}