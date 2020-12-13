package dev.dietermai.sailaflash.persistence.xml.file;

import java.io.File;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.persistence.xml.node.Answer;
import dev.dietermai.sailaflash.persistence.xml.node.ObjectFactory;
import dev.dietermai.sailaflash.persistence.xml.node.Question;
import dev.dietermai.sailaflash.persistence.xml.node.Sailaflash;
import dev.dietermai.sailaflash.persistence.xml.node.SimpleCard;
import dev.dietermai.sailaflash.persistence.xml.node.Text;
import jakarta.xml.bind.JAXB;

public enum CardsFile {
	cardsFile;
	
	private File resource;
	private Sailaflash model;
	
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
		question.setText(createSimpleSide(factory, cardData.question()));
		
		Answer answer = factory.createAnswer();
		newCard.setAnswer(answer);
		answer.setText(createSimpleSide(factory, cardData.answer()));
		
		
		model.getCards().getCardGroup().add(newCard);
	}
	
	private Text createSimpleSide(ObjectFactory factory, String s) {
		var text = factory.createText();
		
		text.setText(s);
		return text;
	}
}
