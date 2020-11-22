package dev.dietermai.sailaflash.persistence.xml.spi.node;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sailaflash")
public class SailaFlash {

	@XmlElementWrapper(name = "cards")
	@XmlElementRefs({ @XmlElementRef(type = SimpleCard.class), @XmlElementRef(type = MultiCard.class) })
	private final List<AbstractCard> cards = new ArrayList<>();

	public List<AbstractCard> getCards() {
		return cards;
	}

	public SailaFlash addCard(AbstractCard card) {
		cards.add(card);
		return this;
	}
}
