package dev.dietermai.sailaflash.ui.jfx;

import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.ui.jfx.app.JavaFxApplication;
import dev.dietermai.sailaflash.ui.jfx.screen.ScreenSM;
import dev.dietermai.sailaflash.ui.jfx.screen.main.MainScreenProvider;

public enum JfxBoot {
	instance;
	
	private String[] programmArgs;
	private IBlService blService;
	
	public void initialize(String[] args) {
		programmArgs = args.clone();
		
		Context context = Context.getInstance();
		context.setBlService(blService);
		
		MainScreenProvider screenProvider = new MainScreenProvider();
		ScreenSM mainScreenSM = new ScreenSM(screenProvider);

		
		context.setMainScreenSM(mainScreenSM);
	}

	public void start() {
		new Thread(() -> JavaFxApplication.launch(JavaFxApplication.class, programmArgs)).start();
	}

	public void setBlService(IBlService blService) {
		this.blService = blService;
	}
	
	public Context getContext() {
		return Context.getInstance();
	}
}
