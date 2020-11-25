package dev.dietermai.sailaflash.bl.store;

import dev.dietermai.sailaflash.api.bl.ICardStore;
import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.persistence.IPersistence;

public class CardStore implements ICardStore {

	private IPersistence persistenceFacade;
	
	public void setPersistence(IPersistence persistenceFacade) {
		this.persistenceFacade = persistenceFacade;
	}
	
	@Override
	public void createNewSimpleCard(CardData cardData) {
//		persistence.saveNewSimpleCard(cardData);
	}
}
