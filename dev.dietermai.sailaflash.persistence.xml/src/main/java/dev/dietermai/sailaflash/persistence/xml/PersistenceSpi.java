package dev.dietermai.sailaflash.persistence.xml;

import dev.dietermai.sailaflash.api.service.IPersistenceService;

public class PersistenceSpi implements IPersistenceService{

	@Override
	public void initialize(String[] args) {
		System.err.println(Thread.currentThread().getStackTrace()[1] + " not implemented!");
	}

	@Override
	public void start() {
		System.err.println(Thread.currentThread().getStackTrace()[1] + " not implemented!");
	}

	@Override
	public void getSaveState() {
		// TODO Auto-generated method stub
		
	}
}
