/**
 * 
 */
package dev.dietermai.sailaflash.ui.jfx.app;

import dev.dietermai.sailaflash.ui.jfx.Context;
import dev.dietermai.sailaflash.ui.jfx.JfxBoot;
import dev.dietermai.sailaflash.ui.jfx.screen.ScreenSM;
import dev.dietermai.sailaflash.ui.jfx.screen.main.MainScreen;
import dev.dietermai.sailaflash.ui.jfx.screen.main.MainScreens;
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
	
	private Context context;
	
	@Override
	public void init() throws Exception {
		super.init();
		System.out.println("JavaFxApplication.init()");
		context = JfxBoot.instance.getContext();
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("JavaFxApplication.stop()");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("JavaFxApplication.start() START");
		LoggingHelper.instance.setStage(primaryStage);

		
        ScreenSM<MainScreens> screenSM = context.getMainScreenSM();
        screenSM.initialize();
        
        
        Scene scene = new Scene(screenSM.getRoot(), 1038, 659);
        LoggingHelper.instance.setScene(scene);
		
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
//        LoggingHelper.instance.dumpStageTree();
        System.out.println("JavaFxApplication.start() END");
	}
}
