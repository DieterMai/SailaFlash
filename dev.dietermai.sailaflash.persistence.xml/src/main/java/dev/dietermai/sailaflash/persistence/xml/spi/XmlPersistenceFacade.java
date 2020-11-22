package dev.dietermai.sailaflash.persistence.xml.spi;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.persistence.IPersistence;

public class XmlPersistenceFacade implements IPersistence{
	@Override
	public void addCard(CardData cardData) {
		System.err.println(Thread.currentThread().getStackTrace()[1] + " not implemented!");
	}
}
