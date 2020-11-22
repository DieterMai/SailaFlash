package dev.dietermai.sailaflash.api.service;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.persistence.IPersistence;

public interface IPersistenceService extends IService {
	
	IPersistence getPersistence();
}
