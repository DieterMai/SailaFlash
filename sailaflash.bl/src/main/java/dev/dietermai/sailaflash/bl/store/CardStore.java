package dev.dietermai.sailaflash.bl.store;

import java.util.ArrayList;
import java.util.List;

import dev.dietermai.sailaflash.api.bl.ICardStore;
import dev.dietermai.sailaflash.api.model.CardBody;
import dev.dietermai.sailaflash.api.persistence.IPersistence;

public class CardStore implements ICardStore {

	private IPersistence persistenceFacade;
	
	private List<CardBody> cards = new ArrayList<>();
	
	private long runningUid = 0;
	
	public void setPersistence(IPersistence persistenceFacade) {
		this.persistenceFacade = persistenceFacade;
	}
	
	@Override
	public void createNewSimpleCard(String question, String answer) {
		var card = new CardBody(nextUid(), question, answer);
		cards.add(card);
		
		persistenceFacade.addCard(card);
	}
	
	private long nextUid() {
		return runningUid++;
	}
}
