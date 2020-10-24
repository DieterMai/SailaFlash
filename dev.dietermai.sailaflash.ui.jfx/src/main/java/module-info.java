
/**
 * @author Dieter
 *
 */
module dev.dietermai.sailaflash.ui.jfx {
	// required from sailaflash
	requires transitive dev.dietermai.sailaflash.api;

	
	// required from JDK
	requires java.base;
	
	
	// required from JavaFX
	requires javafx.base;
	requires javafx.controls;
	requires transitive javafx.graphics;
	
	exports dev.dietermai.sailaflash.ui.jfx.app to javafx.graphics;
	exports dev.dietermai.sailaflash.ui.jfx.service;
	
	
	
	provides dev.dietermai.sailaflash.api.service.IUiService with dev.dietermai.sailaflash.ui.jfx.service.JavaFxUiService;
}