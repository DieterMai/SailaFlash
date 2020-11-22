package dev.dietermai.sailaflash.bl.store;

import dev.dietermai.sailaflash.api.bl.ICardStore;
import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.service.IPersistenceService;

public class CardStore implements ICardStore {

	private IPersistenceService persistence;
	
	public void setPersistence(IPersistenceService persistence) {
		this.persistence = persistence;
	}
	
	@Override
	public void createNewSimpleCard(CardData cardData) {
//		persistence.saveNewSimpleCard(cardData);
	}
}
