package dev.dietermai.sailaflash.ui.jfx.input;

import static dev.dietermai.sailaflash.ui.jfx.inject.PMI.pmi;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.service.IBlService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaveAction implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		System.out.println("SaveAction.handle()");
		
		InputQuestion questionWidget = pmi.get(InputQuestion.class);
		InputAnswer inputWidget = pmi.get(InputAnswer.class);
		
		String questionText = questionWidget.getText();
		String answerText = inputWidget.getText();
		
		System.out.println("Question: "+questionText);
		System.out.println("Answer: "+answerText);
		
		var bl = pmi.get(IBlService.class);
		var cardStore = bl.getCardStore();
		cardStore.createNewSimpleCard(new CardData());
	}
	
}
