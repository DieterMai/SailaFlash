package dev.dietermai.sailaflash.persistence.xml.job;

import java.io.File;

import dev.dietermai.sailaflash.persistence.xml.file.CardsFile;
import dev.dietermai.sailaflash.persistence.xml.node.ObjectFactory;
import dev.dietermai.sailaflash.persistence.xml.node.Sailaflash;
import dev.dietermai.sailautil.dispatch.AbstractJob;
import dev.dietermai.sailautil.dispatch.JobResult;
import jakarta.xml.bind.JAXB;

public class InitializeCards extends AbstractJob<JobResult>  {

	private static final String CARDS_FILE_NAME = "cards.xml";

	@Override
	public JobResult call() {
		final JobResult result;
		File file = new File(CARDS_FILE_NAME);
		if(!file.exists()) {
			createCardsXml(file);
			result = new JobResult(true, "Created "+CARDS_FILE_NAME);
		}else {
			loadCardsXml(file);
			result = new JobResult(true, "Loaded "+CARDS_FILE_NAME);
		}
		
		return result;
	}

	private void createCardsXml(File file) {
		var factory = new ObjectFactory();
		var sailaFlash = factory.createSailaflash();
		var cards = factory.createCards();

		sailaFlash.setCards(cards);
		
		JAXB.marshal(sailaFlash, file);
	}
	
	private void loadCardsXml(File file) {
		var sailaflash = JAXB.unmarshal(file, Sailaflash.class);
		CardsFile.cardsFile.initialize(file, sailaflash);
		
		
		
	}
}
