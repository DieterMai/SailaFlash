/**
 * 
 */
package dev.dietermai.sailaflash.bl.service;

import dev.dietermai.sailaflash.api.bl.ICardStore;
import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.api.service.IPersistenceService;
import dev.dietermai.sailaflash.bl.store.CardStore;

/**
 * @author Dieter
 *
 */
public class BlService implements IBlService {

	private CardStore cardStore;
	private IPersistenceService persistence;
	
	@Override
	public void setPersistence(IPersistenceService persistenceService) {
		this.persistence = persistenceService;
	}
	
	@Override
	public void initialize(String[] args) {
		cardStore = new CardStore();
		cardStore.setPersistence(persistence.getPersistence());
	}

	@Override
	public void start() {
		System.out.println("BlService.start()");
	}

	@Override
	public ICardStore getCardStore() {
		return cardStore;
	}

	@Override
	public void shutdown() {
		persistence.shutdown();
	}
	
}
