package dev.dietermai.sailaflash.ui.jfx.content;

import dev.dietermai.sailaflash.ui.jfx.Constants;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;

public enum ContentConstants {
	;
	
	public static final Background CONTENT_screenBackground = FxUtil.getBg(Constants.COLOR_BackgroundNormal, new CornerRadii(6));
	public static final Insets CONTENT_screenPadding = new Insets(15, 0, 15, 0);
}
