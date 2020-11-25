package dev.dietermai.sailaflash.persistence.xml.spi;

import dev.dietermai.sailaflash.api.persistence.IPersistence;
import dev.dietermai.sailaflash.api.service.IPersistenceService;

public class XmlPersistenceSpi implements IPersistenceService {

	private XmlPersistenceFacade facade;
	
	@Override
	public void initialize(String[] args) {
		facade = new XmlPersistenceFacade();
		
		facade.initialize();
	}

	@Override
	public void start() {
		facade.start();
	}


	@Override
	public IPersistence getPersistence() {
		return facade;
	}

}
