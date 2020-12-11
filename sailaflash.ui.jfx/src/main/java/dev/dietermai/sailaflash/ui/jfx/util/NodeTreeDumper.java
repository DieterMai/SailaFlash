package dev.dietermai.sailaflash.ui.jfx.util;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public enum NodeTreeDumper {
	;
	public static void dump(Stage stage) {
		StringBuilder sb = new StringBuilder();
		sb.append(stage).append("\n");
		Scene scene = stage.getScene();
		if(scene != null) {
			dump(sb, "\t", scene);
		}
		System.out.println(sb.toString());
	}
	
	public static void dump(Scene scene) {
		StringBuilder sb = new StringBuilder();
		dump(sb, "", scene);
		System.out.println(sb.toString());
	}
	
	public static void dump(StringBuilder sb, String indent, Scene scene) {
		sb.append(indent).append(scene).append("\n");
		Parent parent = scene.getRoot();
		if(parent != null) {
			dump(sb, indent+"\t", parent);
		}
	}
	
	public static void dump(Node node) {
		StringBuilder sb = new StringBuilder();
		dump(sb, "", node);
		System.out.println(sb.toString());
	}
	
	public static void dump(StringBuilder sb, String indent, Node node) {
		sb.append(indent).append(node).append(" - ").append(node.getBoundsInParent()).append("\n");
		if(node instanceof Parent parent) {
			for(Node child : parent.getChildrenUnmodifiable()) {
				dump(sb, indent+"\t", child);
			}
		}
	}
}
