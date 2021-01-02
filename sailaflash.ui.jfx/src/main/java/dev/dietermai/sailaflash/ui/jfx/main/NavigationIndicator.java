package dev.dietermai.sailaflash.ui.jfx.main;

import static dev.dietermai.sailaflash.ui.jfx.Constants.*;


import dev.dietermai.sailaflash.ui.jfx.Constants;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class NavigationIndicator extends Widget<NavigationIndicator> {
	private final Pane pane;
	private final Group selectedImageGroup;
	private final ImageView selectedImageView;
	private final Group hoverImageGroup;
	private final ImageView hoverImageView;
	
	
	public NavigationIndicator() {
		selectedImageView = new ImageView();
		selectedImageView.setImage(FxUtil.getImage("navigationIndicator"));
		selectedImageGroup = new Group(selectedImageView);
		
		hoverImageView = new ImageView();
		hoverImageView.setImage(FxUtil.getImage("navigationIndicator"));
		hoverImageGroup = new Group(hoverImageView);
		hoverImageGroup.setVisible(false);
		
		pane = new Pane();
		pane.setMinSize(CONENT_WIDTH, 40);
		pane.setPrefSize(CONENT_WIDTH, 40);
		pane.setMaxSize(CONENT_WIDTH, 40);
		pane.setPadding(CONTENT_INSETS);
		pane.getChildren().add(selectedImageGroup);
		pane.getChildren().add(hoverImageGroup);
	}
	
	public void setSelectionBoundsProperty(ObservableValue<Bounds> selectionBounds) {
		selectionBounds.addListener((obs,old,neo) -> selectedButtonChanged(neo));
		selectedButtonChanged(selectionBounds.getValue());
	}
	
	public void setHoverBoundsProperty(ObservableValue<Bounds> hoverBounds) {
		hoverBounds.addListener((obs,old,neo) -> hoverButtonChanged(neo));
	}
	
	private void selectedButtonChanged(Bounds bounds) {
		if(bounds != null) {
			positionIndicator(selectedImageGroup, bounds);
		}
	}
	
	private void hoverButtonChanged(Bounds bounds) {
		if(bounds != null) {
			hoverImageGroup.setVisible(true);
			positionIndicator(hoverImageGroup, bounds);
		}else {
			hoverImageGroup.setVisible(false);
		}
	}
	
	private void positionIndicator(Group indicatorGroup, Bounds buttonBounds) {
		Bounds imageGroupBounds = indicatorGroup.getBoundsInParent();
		
		double buttonCenter = buttonBounds.getCenterX();
		double indicatorHalfWith = imageGroupBounds.getWidth()/2;
		double indicatorPosition = buttonCenter - indicatorHalfWith;
		indicatorGroup.setLayoutX(Constants.CONTENT_INSET_LEFT+indicatorPosition);
		pane.layout();
	}
	
	public Node getRoot() {
		return pane;
	}

	@Override
	public NavigationIndicator initialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
