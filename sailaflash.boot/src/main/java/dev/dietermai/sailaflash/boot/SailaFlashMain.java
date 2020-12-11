package dev.dietermai.sailaflash.boot;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.api.service.IPersistenceService;
import dev.dietermai.sailaflash.api.service.IService;
import dev.dietermai.sailaflash.api.service.IUiService;


public class SailaFlashMain {
	public static void main(String[] args) {
		new SailaFlashMain(args).run();
	}
	
	private final String[] args;
	
	public SailaFlashMain(String[] args) {
		this.args = args;
	}
	
	private void run() {
		var persistenceService = fetchService(IPersistenceService.class);
		var blService = fetchService(IBlService.class);
		var uiService = fetchService(IUiService.class);
		
		blService.setPersistence(persistenceService);
		uiService.setBlService(blService);
		
		
		persistenceService.initialize(args);
		blService.initialize(args);
		uiService.initialize(args);
		
		persistenceService.start();
		blService.start();
		uiService.start();
	}
	
	
	private <T extends IService> T fetchService(Class<T> serviceClass) {
		ServiceLoader<T> serviceLoader = ServiceLoader.load(serviceClass);
		List<T> serviceList = new ArrayList<>();
		for(T service : serviceLoader) {
			serviceList.add(service);
		}
		
		if(serviceList.size() == 0) {
			throw new IllegalStateException("Did not find any "+serviceClass.getSimpleName());
		}else if(serviceList.size() > 1) {
			throw new IllegalStateException("Did find "+serviceList.size()+" IUiService's. There can only be one!");
		}else {
			System.out.println("SailaFlashMain.fetchUiService() found "+serviceList.get(0)+" as "+serviceClass.getSimpleName());
			return serviceList.get(0);
		}
	}
	
	
	

}
