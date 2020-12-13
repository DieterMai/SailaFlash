package dev.dietermai.sailaflash.persistence.xml.spi;


import java.time.Duration;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.persistence.IPersistence;
import dev.dietermai.sailaflash.persistence.xml.job.AddCardJob;
import dev.dietermai.sailaflash.persistence.xml.job.InitializeCards;
import dev.dietermai.sailaflash.persistence.xml.job.SaveJob;
import dev.dietermai.sailautil.dispatch.DebounceJob;
import dev.dietermai.sailautil.dispatch.JobExecutor;
import dev.dietermai.sailautil.dispatch.JobResult;

public class XmlPersistenceFacade implements IPersistence{
	// TODO the faced imple should only have accessor methods. It should not initialize fields
	private JobExecutor executor;
	
	private DebounceJob<JobResult> saveTrigger;
	
	public void initialize() {
		executor = JobExecutor.createDefault();
		saveTrigger = new DebounceJob<>(executor, new SaveJob(), Duration.ofSeconds(10));
		
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

	public void shutdown() {
		saveTrigger.triggerNowIfPending();
		executor.shutdown();
	}
}
