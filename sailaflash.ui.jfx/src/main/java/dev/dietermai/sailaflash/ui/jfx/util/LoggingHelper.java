package dev.dietermai.sailaflash.ui.jfx.util;

import javafx.scene.Scene;
import javafx.stage.Stage;

public enum LoggingHelper {
	instance;
	
	private Stage stage;
	private Scene scene;
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void dumpStageTree() {
		NodeTreeDumper.dump(stage);
	}
	
	public void dumpSceneTree() {
		NodeTreeDumper.dump(scene);
	}
}
