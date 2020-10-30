package dev.dietermai.sailaflash.ui.jfx;

import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.ui.jfx.app.JavaFxApplication;
import dev.dietermai.sailaflash.ui.jfx.inject.PMI;
import dev.dietermai.sailaflash.ui.jfx.screen.ScreenSM;
import dev.dietermai.sailaflash.ui.jfx.screen.main.MainScreenProvider;
import dev.dietermai.sailaflash.ui.jfx.screen.main.MainScreens;

public enum JfxBoot {
	instance;
	
	private String[] programmArgs;
	private IBlService blService;
	
	public void initialize(String[] args) {
		programmArgs = args.clone();
		
		PMI.pmi.set(blService);
	}

	public void start() {
		new Thread(() -> JavaFxApplication.launch(JavaFxApplication.class, programmArgs)).start();
	}

	public void setBlService(IBlService blService) {
		this.blService = blService;
	}
}
