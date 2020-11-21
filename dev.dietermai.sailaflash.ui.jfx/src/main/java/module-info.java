module dev.dietermai.sailaflash.ui.jfx {
	exports dev.dietermai.sailaflash.ui.jfx.screen;
	exports dev.dietermai.sailaflash.ui.jfx.content;
	exports dev.dietermai.sailaflash.ui.jfx.inject;
	exports dev.dietermai.sailaflash.ui.jfx.input;
	exports dev.dietermai.sailaflash.ui.jfx.util;
	exports dev.dietermai.sailaflash.ui.jfx;
	exports dev.dietermai.sailaflash.ui.jfx.main;
	exports dev.dietermai.sailaflash.ui.jfx.service;
	exports dev.dietermai.sailaflash.ui.jfx.app;

	requires dev.dietermai.sailaflash.api;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	
	provides dev.dietermai.sailaflash.api.service.IUiService with dev.dietermai.sailaflash.ui.jfx.service.JavaFxUiService;
}