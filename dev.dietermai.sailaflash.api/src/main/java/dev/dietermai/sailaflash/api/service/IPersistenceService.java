package dev.dietermai.sailaflash.api.service;

import dev.dietermai.sailaflash.api.model.CardData;

public interface IPersistenceService extends IService {
	void saveNewSimpleCard(CardData cardData);
}
