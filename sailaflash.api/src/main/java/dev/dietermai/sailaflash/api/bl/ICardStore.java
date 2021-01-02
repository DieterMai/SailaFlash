package dev.dietermai.sailaflash.api.bl;

import dev.dietermai.sailaflash.api.model.CardBody;

public interface ICardStore {
	void createNewSimpleCard(String question, String answer);
}
