package dev.dietermai.sailaflash.bl.model;

public record Image() implements IRichText {
	@Override
	public RichTextType type() {
		return RichTextType.audio;
	}
}
