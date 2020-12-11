package dev.dietermai.sailaflash.bl.store;

import java.util.ArrayList;
import java.util.List;

import dev.dietermai.sailaflash.api.bl.ICardStore;
import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.persistence.IPersistence;

public class CardStore implements ICardStore {

	private IPersistence persistenceFacade;
	
	private List<CardData> cards = new ArrayList<>();
	
	public void setPersistence(IPersistence persistenceFacade) {
		this.persistenceFacade = persistenceFacade;
	}
	
	@Override
	public void createNewSimpleCard(CardData cardData) {
		cards.add(cardData);
		
		persistenceFacade.addCard(cardData);
	}
}
