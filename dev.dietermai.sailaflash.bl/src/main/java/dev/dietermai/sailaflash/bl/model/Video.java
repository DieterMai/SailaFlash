package dev.dietermai.sailaflash.bl.model;

public record Video() implements IRichText {

	@Override
	public RichTextType type() {
		return RichTextType.video;
	}

}
