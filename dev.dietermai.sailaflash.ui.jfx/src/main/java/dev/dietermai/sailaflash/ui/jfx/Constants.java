package dev.dietermai.sailaflash.ui.jfx;

import javafx.geometry.Insets;
import javafx.scene.paint.Color;

public enum Constants {
	;
	
	// TODO think about a consistent name schema
	
	public static final double CONTENT_INSET_LEFT = 24;
	public static final double CONTENT_INSET_TOP = 0;
	public static final double CONTENT_INSET_RIGHT = 24;
	public static final double CONTENT_INSET_BOTTOM = 0;
	
	public static final int HIGHT_PREF_UPPERBUTTON = 24;
	
	public static final double CONENT_WIDTH = 1040;
	public static final Insets CONTENT_INSETS = new Insets(CONTENT_INSET_TOP, CONTENT_INSET_RIGHT, CONTENT_INSET_BOTTOM, CONTENT_INSET_LEFT);
	
	
	public static final Color COLOR_BackgroundNormal = Color.WHITE;
	public static final Color COLOR_BackgroundContrast = Color.rgb(238, 238, 238);
	public static final Color COLOR_Forground = Color.rgb(0, 122, 80);
	public static final Color COLOR_Highlight = Color.rgb(252, 124, 0);;
	
	
	public static final Color COLOR_UpperSpace = Color.WHITE;
	public static final Color COLOR_LowerSpace = COLOR_Forground;
}
