package dev.dietermai.sailaflash.bl.model;

public record LineBreak() implements IRichText {
	@Override
	public RichTextType type() {
		return RichTextType.lineBreak;
	}
}
