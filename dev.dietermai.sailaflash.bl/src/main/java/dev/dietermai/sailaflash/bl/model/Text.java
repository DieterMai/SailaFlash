package dev.dietermai.sailaflash.bl.model;

public record Text(String text) implements IRichText {

	@Override
	public RichTextType type() {
		return RichTextType.text;
	}
}
