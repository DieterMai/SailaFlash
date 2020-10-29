package dev.dietermai.sailaflash.bl.model;

public record Audio() implements IRichText {

	@Override
	public RichTextType type() {
		return RichTextType.audio;
	}
}
