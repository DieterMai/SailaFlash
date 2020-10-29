package dev.dietermai.sailaflash.ui.jfx.inject;

import java.util.HashMap;
import java.util.Map;

import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.ui.jfx.screen.ScreenSM;
import dev.dietermai.sailaflash.ui.jfx.screen.main.MainScreens;

public class Context {
	private static final Context instance = new Context();
	
	public static Context getInstance() {
		return instance;
	}
	
	private record Tuple(Class<?> clazz, Keys key) {}

	private final Map<Class<?>, Object> oneMap = new HashMap<>();
	private final Map<Tuple, Object> multiMap = new HashMap<>();
	
	
//	private IBlService blService;
//	private ScreenSM<MainScreens> mainScreenSM;
	
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz) {
		return (T) oneMap.get(clazz);
	}
	
	public void set(Object o) {
		oneMap.put(o.getClass(), o);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, Keys key) {
		return (T) multiMap.get(new Tuple(clazz, key));
	}
	
	public void set(Keys key, Object instance) {
		multiMap.put(new Tuple(instance.getClass(), key), instance);
	}
	
	
//	//@formatter:off
//	public IBlService getBlService() { return blService; }
//	public void setBlService(IBlService blService) { this.blService = blService; }
//	
//	public ScreenSM<MainScreens> getMainScreenSM() {	return mainScreenSM; }
//	public void setMainScreenSM(ScreenSM<MainScreens> mainScreenSM) { this.mainScreenSM = mainScreenSM; }
//	//@formatter:on
}
