package dev.dietermai.sailaflash.persistence.xml;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.service.IPersistenceService;
import dev.dietermai.sailaflash.persistence.xml.node.SailaFlash;
import jakarta.xml.bind.JAXB;

public class XmlPersistenceSpi implements IPersistenceService {

	@Override
	public void initialize(String[] args) {
	}

	@Override
	public void start() {
		initializeCardDocument();
		System.err.println(Thread.currentThread().getStackTrace()[1] + " not implemented!");
	}

	@Override
	public void saveNewSimpleCard(CardData cardData) {
		System.err.println(Thread.currentThread().getStackTrace()[1] + " not implemented!");

	}

	private void initializeCardDocument() {
		var sailaFlash = new SailaFlash();
		JAXB.marshal(sailaFlash, System.out);
		
	}

	@Override
	public void addCard(CardData cardData) {
		// TODO Auto-generated method stub
		
	}

	
}
