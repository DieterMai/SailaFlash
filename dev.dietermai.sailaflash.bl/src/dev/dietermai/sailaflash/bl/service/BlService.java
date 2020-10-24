/**
 * 
 */
package dev.dietermai.sailaflash.bl.service;

import dev.dietermai.sailaflash.api.bl.IUserFacade;
import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.bl.user.UserFacade;
import dev.dietermai.sailaflash.bl.user.UserStore;

/**
 * @author Dieter
 *
 */
public class BlService implements IBlService {

	private UserFacade userFacade;
	
	@Override
	public void initialize(String[] args) {
		userFacade = new UserFacade(new UserStore());
	}

	@Override
	public void start() {
		System.out.println("BlService.start()");
	}

	@Override
	public IUserFacade getUserFacade() {
		return userFacade;
	}
}
