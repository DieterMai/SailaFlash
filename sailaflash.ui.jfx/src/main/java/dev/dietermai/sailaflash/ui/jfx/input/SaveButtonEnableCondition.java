package dev.dietermai.sailaflash.ui.jfx.input;

import static dev.dietermai.sailaflash.ui.jfx.inject.PMI.pmi;
import static dev.dietermai.sailaflash.ui.jfx.inject.Keys.*;

import javafx.scene.control.Button;

public class SaveButtonEnableCondition {

	private Button button;
	private InputAnswer answer;
	private InputQuestion question;
	
	@Override
	public String toString() {
		return "SaveButtonEnableCondition [button=" + button + ", answer=" + answer + ", question=" + question + "]";
	}
	
	
	
	public void initialize() {
		button = pmi.get(Button.class, inputSaveButton);
		answer = pmi.get(InputAnswer.class);
		question = pmi.get(InputQuestion.class);
		
		if(!sanity()) {
			System.err.println("SaveButtonEnableCondition not correctly initialized");
		}
		
		answer.textProperty().addListener((obs,old,neo) -> evaluate());
		question.textProperty().addListener((obs,old,neo) -> evaluate());
		
		evaluate();
	}
	
	private boolean sanity() {
		return button != null && answer != null && question != null;
	}
	

	private void evaluate() {
		String answerText = answer.getText();
		String questionText = question.getText();
		
		if(answerText.isBlank() || questionText.isBlank()) {
			button.setDisable(true);
		}else {
			button.setDisable(false);
		}
	}
}
