/**
 * 
 */
package dev.dietermai.sailaflash.bl.service;

import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.api.service.IPersistenceService;

/**
 * @author Dieter
 *
 */
public class BlService implements IBlService {

	
	@Override
	public void initialize(String[] args) {
	}

	@Override
	public void start() {
		System.out.println("BlService.start()");
	}

	@Override
	public void setPersistenceService(IPersistenceService persistenceService) {
		System.err.println(Thread.currentThread().getStackTrace()[1] + " not implemented!");
		
	}
	
}
