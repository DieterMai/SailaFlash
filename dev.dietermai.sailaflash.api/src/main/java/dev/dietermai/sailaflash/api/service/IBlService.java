package dev.dietermai.sailaflash.api.service;

import dev.dietermai.sailaflash.api.bl.IUserFacade;

/**
 * @author Dieter
 *
 */
public interface IBlService extends IService{
	IUserFacade getUserFacade();
}
