package dev.dietermai.sailaflash.ui.jfx;

import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.ui.jfx.screen.ScreenSM;
import dev.dietermai.sailaflash.ui.jfx.screen.main.MainScreens;

public class Context {
	private static final Context instance = new Context();
	
	public static Context getInstance() {
		return instance;
	}
	
	private IBlService blService;
	private ScreenSM<MainScreens> mainScreenSM;
	
	//@formatter:off
	public IBlService getBlService() { return blService; }
	public void setBlService(IBlService blService) { this.blService = blService; }
	
	public ScreenSM<MainScreens> getMainScreenSM() {	return mainScreenSM; }
	public void setMainScreenSM(ScreenSM<MainScreens> mainScreenSM) { this.mainScreenSM = mainScreenSM; }
	//@formatter:on
}
