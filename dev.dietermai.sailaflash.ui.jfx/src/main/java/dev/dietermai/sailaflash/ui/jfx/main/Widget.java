package dev.dietermai.sailaflash.ui.jfx.main;

import javafx.scene.Node;

public abstract class Widget<T extends Widget<T>> {
	private Node root;
	
	public abstract T initialize();
	
	protected void setRoot(Node root) {
		this.root = root;
	}
	
	public Node getRoot() {
		return root;
	}
}
