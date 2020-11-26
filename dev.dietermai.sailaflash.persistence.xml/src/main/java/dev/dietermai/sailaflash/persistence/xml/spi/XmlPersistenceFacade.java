package dev.dietermai.sailaflash.persistence.xml.spi;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.persistence.IPersistence;
import dev.dietermai.sailaflash.persistence.xml.node.Sailaflash;
import dev.dietermai.sailaflash.persistence.xml.node.Sailaflash;
import dev.dietermai.sailaflash.persistence.xml.node.SimpleCard;
import jakarta.xml.bind.JAXB;

public class XmlPersistenceFacade implements IPersistence{
	private ExecutorService executor;
	
	public void initialize() {
		executor = Executors.newSingleThreadExecutor(); // TODO supply own thread factory
	}
	
	public void start() {
		executor.execute(this::initializeCardDocument);
	}
	
	private void initializeCardDocument() {
		var sailaFlash = new Sailaflash();
		var simpleCard1 = new SimpleCard();
		var simpleCard2 = new SimpleCard();
		
		sailaFlash.addCard(simpleCard1);
		sailaFlash.addCard(simpleCard2);
		
		File xmlFile = new File("alpha.xml");
		System.out.println("file: "+xmlFile.getAbsolutePath());
//		JAXB.marshal(sailaFlash, System.out);
//		JAXB.marshal(sailaFlash, xmlFile);
		
		var unmarchald = JAXB.unmarshal(xmlFile, SailaFlash.class);
		
		System.out.println(unmarchald);
	}
	
	@Override
	public void addCard(CardData cardData) {
		System.err.println(Thread.currentThread().getStackTrace()[1] + " not implemented!");
	}
}
