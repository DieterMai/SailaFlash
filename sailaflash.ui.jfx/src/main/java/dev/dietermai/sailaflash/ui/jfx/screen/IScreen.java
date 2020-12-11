package dev.dietermai.sailaflash.ui.jfx.screen;

import javafx.scene.layout.Pane;

public interface IScreen {
	void initialize();
	void cleanup();
	Pane getRootNode();
	
}
