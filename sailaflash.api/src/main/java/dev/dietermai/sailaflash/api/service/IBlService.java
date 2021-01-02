package dev.dietermai.sailaflash.api.service;

import dev.dietermai.sailaflash.api.bl.ICardStore;

/**
 * @author Dieter
 *
 */
public interface IBlService extends IService{ // add IBLFacade
	void setPersistence(IPersistenceService persistenceService); // TODO user IPersistence instead

	ICardStore getCardStore();
	
	void shutdown();
}
