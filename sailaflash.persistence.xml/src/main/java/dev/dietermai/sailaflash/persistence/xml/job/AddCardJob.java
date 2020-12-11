package dev.dietermai.sailaflash.persistence.xml.job;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.persistence.xml.file.CardsFile;
import dev.dietermai.sailautil.dispatch.AbstractJob;
import dev.dietermai.sailautil.dispatch.JobResult;

public class AddCardJob extends AbstractJob{ // TODO

	private final CardData cardData;
	
	public AddCardJob(final CardData cardData) {
		this.cardData = cardData;
	}
	
	@Override
	public JobResult call() throws Exception {
		CardsFile.cardsFile.addCard(cardData);
		JobResult result = new JobResult(true, "Addec Card "+cardData);
		
		return result;
	}

}
