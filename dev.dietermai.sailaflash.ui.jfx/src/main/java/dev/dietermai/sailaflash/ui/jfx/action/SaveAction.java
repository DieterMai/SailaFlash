package dev.dietermai.sailaflash.ui.jfx.action;

import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.ui.jfx.inject.PMI;
import dev.dietermai.sailaflash.ui.jfx.widget.input.InputAnswer;
import dev.dietermai.sailaflash.ui.jfx.widget.input.InputQuestion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaveAction implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		System.out.println("SaveAction.handle()");
		
		InputQuestion questionWidget = PMI.pmi.get(InputQuestion.class);
		InputAnswer inputWidget = PMI.pmi.get(InputAnswer.class);
		
		String questionText = questionWidget.getText();
		String answerText = inputWidget.getText();
		
		System.out.println("Question: "+questionText);
		System.out.println("Answer: "+answerText);
		
		IBlService bl = PMI.pmi.get(IBlService.class);
		
//		bl.createNewCard();
	}
}
