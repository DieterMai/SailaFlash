package dev.dietermai.sailaflash.persistence.xml.spi;


import java.time.Duration;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.persistence.IPersistence;
import dev.dietermai.sailaflash.persistence.xml.job.AddCardJob;
import dev.dietermai.sailaflash.persistence.xml.job.InitializeCards;
import dev.dietermai.sailaflash.persistence.xml.job.SaveJob;
import dev.dietermai.sailautil.dispatch.DebounceJob;
import dev.dietermai.sailautil.dispatch.JobExecutor;

public class XmlPersistenceFacade implements IPersistence{
	private JobExecutor executor;
	
	private DebounceJob saveTrigger;
	
	public void initialize() {
		executor = JobExecutor.createDefault();
		saveTrigger = new DebounceJob(executor, new SaveJob(), Duration.ofSeconds(10));
		
	}
	
	public void start() {
	}
	
	public void loadSaveState() {
		executor.addJob(new InitializeCards());
	}
	
	
	@Override
	public void addCard(CardData cardData) {
		executor.addJob(new AddCardJob(cardData));
		saveTrigger.trigger();
	}
}
