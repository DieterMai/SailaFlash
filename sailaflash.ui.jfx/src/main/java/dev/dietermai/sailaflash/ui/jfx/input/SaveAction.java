package dev.dietermai.sailaflash.ui.jfx.input;

import static dev.dietermai.sailaflash.ui.jfx.inject.PMI.pmi;

import dev.dietermai.sailaflash.api.model.CardBody;
import dev.dietermai.sailaflash.api.service.IBlService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaveAction implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		InputQuestion questionWidget = pmi.get(InputQuestion.class);
		InputAnswer inputWidget = pmi.get(InputAnswer.class);
		
		String questionText = questionWidget.getText();
		String answerText = inputWidget.getText();
		
		var bl = pmi.get(IBlService.class);
		var cardStore = bl.getCardStore();
		cardStore.createNewSimpleCard(questionText, answerText);
	}
}
