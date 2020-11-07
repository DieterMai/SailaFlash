package dev.dietermai.sailaflash.ui.jfx.content;

import dev.dietermai.sailaflash.ui.jfx.screen.IScreen;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PracticeScreen implements IScreen {

	private HBox root;
	
	@Override
	public void initialize() {
		root = new HBox();
		root.setBackground(FxUtil.getBg(Color.YELLOW));
		root.setMinSize(200, 200);
	}
	
	@Override
	public Pane getRootNode() {
		return root;
	}

	@Override
	public void cleanup() {
	}
}
