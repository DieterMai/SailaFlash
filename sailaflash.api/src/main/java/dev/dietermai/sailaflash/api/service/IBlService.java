package dev.dietermai.sailaflash.api.service;

import dev.dietermai.sailaflash.api.bl.ICardStore;

/**
 * @author Dieter
 *
 */
public interface IBlService extends IService{
	void setPersistence(IPersistenceService persistenceService);

	ICardStore getCardStore();
}
