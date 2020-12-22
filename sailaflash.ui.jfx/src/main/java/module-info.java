module dev.dietermai.sailaflash.ui.jfx {

	requires dev.dietermai.sailaflash.api;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	
	provides dev.dietermai.sailaflash.api.service.IUiService with dev.dietermai.sailaflash.ui.jfx.service.JavaFxUiService;
}