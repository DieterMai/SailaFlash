package dev.dietermai.sailaflash.bl.model;

public record SimpleCard(int id, Question question, Answer answer) implements ICard{

	@Override
	public CardType type() {
		return CardType.simple;
	}
	
	
}
