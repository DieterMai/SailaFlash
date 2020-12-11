package dev.dietermai.sailaflash.persistence.xml.file;

import java.io.File;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.persistence.xml.node.Answer;
import dev.dietermai.sailaflash.persistence.xml.node.ObjectFactory;
import dev.dietermai.sailaflash.persistence.xml.node.Question;
import dev.dietermai.sailaflash.persistence.xml.node.Sailaflash;
import dev.dietermai.sailaflash.persistence.xml.node.Side;
import dev.dietermai.sailaflash.persistence.xml.node.SimpleCard;
import jakarta.xml.bind.JAXB;

public enum CardsFile {
	cardsFile;
	
	private File resource;
	private Sailaflash model;
	
	private volatile boolean pendingSave;
	
	public void initialize(File resource, Sailaflash model) {
		this.resource = resource;
		this.model = model;
	}
	
	public void save() {
		if(model == null) {
			return; // TODO handle error
		}
		
		JAXB.marshal(model, resource);
	}
	
	public void addCard(final CardData cardData) {
		if(model == null) {
			return; // TODO handle error
		}
		ObjectFactory factory = new ObjectFactory();
		
		SimpleCard newCard = factory.createSimpleCard();
		Question question = factory.createQuestion();
		newCard.setQuestion(question);
		question.setSide(createSimpleSide(factory, cardData.question()));
		
		Answer answer = factory.createAnswer();
		newCard.setAnswer(answer);
		answer.setSide(createSimpleSide(factory, cardData.answer()));
		
		
		model.getCards().getCardGroup().add(newCard);
	}
	
	private Side createSimpleSide(ObjectFactory factory, String s) {
		var side = factory.createSide();
		var richText = factory.createRichText();
		var text = factory.createText();
		
		side.setRichtext(richText);
		richText.setText(text);
		text.setText(s);
		return side;
	}
}
