package dev.dietermai.sailaflash.persistence.xml.spi;

import dev.dietermai.sailaflash.api.persistence.IPersistence;
import dev.dietermai.sailaflash.api.service.IPersistenceService;
import dev.dietermai.sailaflash.persistence.xml.XmlPersistenceFacade;
import dev.dietermai.sailautil.dispatch.JobExecutor;

public class XmlPersistenceSpi implements IPersistenceService {

	private XmlPersistenceFacade facade;
	
	@Override
	public void initialize(String[] args) {
		JobExecutor executor = JobExecutor.createDefault();
		facade = new XmlPersistenceFacade(executor);
		facade.initialize();
		facade.start();
	}

	@Override
	public void start() {
		facade.loadSaveState();
	}


	@Override
	public IPersistence getPersistence() {
		return facade;
	}

	@Override
	public void shutdown() {
		facade.shutdown();
	}

}
