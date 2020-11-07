
/**
 * @author Dieter
 *
 */
module dev.dietermai.sailaflash.ui.jfx {
	/* ******** */
	/* Requires */
	/* ******** */
	
	// required from SailaFlash
	requires transitive dev.dietermai.sailaflash.api;
//	requires dev.dietermai.sailaflash.bl;

	// required from JDK
	requires java.base;
	
	// required from JavaFX
	requires javafx.base;
	requires javafx.controls;
	requires transitive javafx.graphics;
	

	/* ******* */
	/* Exports */
	/* ******* */
	
	// Export to all
	exports dev.dietermai.sailaflash.ui.jfx.service;

	// Export to JavaFX
	exports dev.dietermai.sailaflash.ui.jfx.app to javafx.graphics;
	
	
	
	
	/* ***** */
	/* Opens */
	/* ***** */
	opens dev.dietermai.sailaflash.ui.jfx.inject to com.google.guice;
	
	
	/* ************************** */
	/* Service Provider Interface */
	/* ************************** */
	provides dev.dietermai.sailaflash.api.service.IUiService with dev.dietermai.sailaflash.ui.jfx.service.JavaFxUiService;


	/* ***** */
	/* Opens */
	/* ***** */
	
}