/**
 * 
 */
package dev.dietermai.sailaflash.ui.jfx.app;

import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.ui.jfx.inject.PMI;
import dev.dietermai.sailaflash.ui.jfx.main.MainScreenProvider;
import dev.dietermai.sailaflash.ui.jfx.main.MainScreens;
import dev.dietermai.sailaflash.ui.jfx.screen.ScreenSM;
import dev.dietermai.sailaflash.ui.jfx.service.JavaFxUiService;
import dev.dietermai.sailaflash.ui.jfx.util.LoggingHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Dieter
 *
 */
public class JavaFxApplication extends Application {

	// main method for testing purposes.  
	public static void main(String[] args) {
		JavaFxUiService service = new JavaFxUiService();
		service.initialize(args);
		service.start();
	}
	
	
	@Override
	public void init() throws Exception {
		super.init();
		System.out.println("JavaFxApplication.init()");
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("JavaFxApplication.stop()");
		IBlService bl = PMI.pmi.get(IBlService.class);
		if(bl != null) {
			bl.shutdown();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("JavaFxApplication.start() START");
		LoggingHelper.instance.setStage(primaryStage);

		MainScreenProvider mainScreenProvider = PMI.pmi.get(MainScreenProvider.class);
		ScreenSM<MainScreens> screenSM = new ScreenSM<>(mainScreenProvider);
        screenSM.initialize();
        
        
        Scene scene = new Scene(screenSM.getRoot(), 1038, 659);
        LoggingHelper.instance.setScene(scene);
		
        
        primaryStage.setTitle("SailaFlash");
        primaryStage.setScene(scene);
        primaryStage.show();
        
//        LoggingHelper.instance.dumpStageTree();
        System.out.println("JavaFxApplication.start() END");
	}
}
