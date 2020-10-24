package dev.dietermai.sailaflash.ui.jfx.util;

import java.io.InputStream;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public enum FxUtil {
	;
	
	public static Background getBg(Paint fill) {
		return new Background(getBgFill(fill));
	}
	
	public static Background getBg(Paint fill, CornerRadii radii) {
		return new Background(getBgFill(fill, radii));
	}
	
	public static Background getBg(Paint fill, double radius) {
		return new Background(getBgFill(fill, radius));
	}
	
	public static Background getBg(Paint fill, CornerRadii radii, Insets insets) {
		return new Background(getBgFill(fill, radii, insets));
	}
	
	public static Background getBg(Paint fill, double radius, double insets) {
		return new Background(getBgFill(fill, radius, insets));
	}
	
	public static BackgroundFill getBgFill(Paint color) {
		return new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
	}
	
	public static BackgroundFill getBgFill(Paint fill, CornerRadii radii) {
		return new BackgroundFill(fill, radii, Insets.EMPTY);
	}
	
	public static BackgroundFill getBgFill(Paint fill, double radius) {
		return new BackgroundFill(fill, new CornerRadii(radius), Insets.EMPTY);
	}
	
	public static BackgroundFill getBgFill(Paint fill, CornerRadii radii, Insets insets) {
		return new BackgroundFill(fill, radii, insets);
	}
	
	public static BackgroundFill getBgFill(Paint fill, double radius, double insets) {
		return new BackgroundFill(fill, new CornerRadii(radius), new Insets(insets));
	}
	
	// image
	public static InputStream getImageAsStream(String name) {
		try {
			return FxUtil.class.getClassLoader().getResourceAsStream("res/"+name+".png");
		}catch(SecurityException se) {
			se.printStackTrace();// TODO
		}
		return null;
	}
	
	public static Image getImage(InputStream stream) {
		if(stream != null) {
			return new Image(stream);
		}else {
			return null;
		}
	}
	
	public static Image getImage(String name) {
		return getImage(getImageAsStream(name));
	}
	
	
	// Threading
	public static void inFx(Runnable r) {
		if(Platform.isFxApplicationThread()) {
			r.run();
		}else {
			Platform.runLater(r);
		}
	}
	
	// other
	public static void save(Runnable r) {
		try {
			r.run();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
