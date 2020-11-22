package dev.dietermai.sailaflash.persistence.xml.spi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.persistence.IPersistence;
import dev.dietermai.sailaflash.api.service.IPersistenceService;
import dev.dietermai.sailaflash.persistence.xml.spi.node.SailaFlash;
import dev.dietermai.sailaflash.persistence.xml.spi.node.SimpleCard;
import jakarta.xml.bind.JAXB;

public class XmlPersistenceSpi implements IPersistenceService {

	private ExecutorService executor;
	
	@Override
	public void initialize(String[] args) {
		executor = Executors.newSingleThreadExecutor(); // TODO supply own thread factory
	}

	@Override
	public void start() {
		executor.execute(this::initializeCardDocument);
	}


	private void initializeCardDocument() {
		var sailaFlash = new SailaFlash();
		var simpleCard = new SimpleCard();
		sailaFlash.addCard(simpleCard);
		JAXB.marshal(sailaFlash, System.out);
		
	}

	@Override
	public IPersistence getPersistence() {
		// TODO Auto-generated method stub
		return null;
	}

}
