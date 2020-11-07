package dev.dietermai.sailaflash.ui.jfx.main;

import static dev.dietermai.sailaflash.ui.jfx.Constants.COLOR_LowerSpace;
import static dev.dietermai.sailaflash.ui.jfx.Constants.COLOR_UpperSpace;
import static dev.dietermai.sailaflash.ui.jfx.Constants.CONENT_WIDTH;
import static dev.dietermai.sailaflash.ui.jfx.Constants.CONTENT_INSETS;

import dev.dietermai.sailaflash.ui.jfx.content.Content;
import dev.dietermai.sailaflash.ui.jfx.screen.IScreen;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainScreen implements IScreen {
	private static final double UPPER_CONENT_HIGHT = 80;
	private static final double LOWER_CONENT_HIGHT = 600;
	
	
	private StackPane mainPane;
	private TopMenu topMenu;
	private NavigationBar navigationBar;
	private NavigationIndicator navigationIndicator;
	
	
	@Override
	public void initialize() {
		Node upperSpace = createUpperSpace();
		Node lowerSpace = createLowerSpace();
		
		VBox mainVBox = new VBox();
		mainVBox.setAlignment(Pos.TOP_CENTER);
		mainVBox.getChildren().add(upperSpace);
		mainVBox.getChildren().add(lowerSpace);
		VBox.setVgrow(lowerSpace, Priority.ALWAYS);
		
		
		BorderPane borderPane = new BorderPane();
		borderPane.setBackground(FxUtil.getBg(Color.YELLOW));
		borderPane.setCenter(mainVBox);
		BorderPane.setAlignment(mainVBox, Pos.TOP_CENTER);
		
		mainPane = new StackPane();
		mainPane.getChildren().add(borderPane);
		
	}
	
	private Node createUpperSpace() {
		Node upperContent = createUpperContent();
		
		HBox upperSpace = new HBox();
		upperSpace.setBackground(FxUtil.getBg(COLOR_UpperSpace));
		upperSpace.setAlignment(Pos.TOP_CENTER);
		upperSpace.setPrefWidth(Double.MAX_VALUE);
		upperSpace.getChildren().add(upperContent);
		
		return upperSpace;
	}
	
	private Node createUpperContent() {
		Node menuBox = createMenuBox();
		
		ImageView imageView = new ImageView();
		imageView.setImage(FxUtil.getImage("logo"));
		imageView.setPreserveRatio(true);

		HBox upperContent = new HBox();
		upperContent.setMinSize(CONENT_WIDTH, UPPER_CONENT_HIGHT);
		upperContent.setPrefSize(CONENT_WIDTH, UPPER_CONENT_HIGHT);
		upperContent.setMaxSize(CONENT_WIDTH, UPPER_CONENT_HIGHT);
		upperContent.setPadding(CONTENT_INSETS);
		upperContent.getChildren().add(menuBox);
		upperContent.getChildren().add(imageView);
		HBox.setHgrow(menuBox, Priority.ALWAYS);
		
		return upperContent;
	}
	
	private Node createMenuBox() {
		topMenu = new TopMenu();
		navigationBar = new NavigationBar();
		
		VBox menusBox = new VBox();
		menusBox.getChildren();
		menusBox.getChildren().add(topMenu.getRoot());
		menusBox.getChildren().add(navigationBar.getRoot());
		VBox.setVgrow(navigationBar.getRoot(), Priority.ALWAYS);
		
		return menusBox;
	}
	
	private Node createLowerSpace() {
		navigationIndicator = new NavigationIndicator();
		navigationIndicator.setSelectionBoundsProperty(navigationBar.selectedPageBounds());
		navigationIndicator.setHoverBoundsProperty(navigationBar.hoverPageBounds());
		
		Node content = createContent();
		
		VBox lowerSpace = new VBox();
		lowerSpace.setBackground(FxUtil.getBg(COLOR_LowerSpace));
		lowerSpace.setAlignment(Pos.TOP_CENTER);
		lowerSpace.setPrefWidth(Double.MAX_VALUE);
		lowerSpace.setMinHeight(200);
		lowerSpace.setMinWidth(200);
		lowerSpace.getChildren().add(navigationIndicator.getRoot());
		lowerSpace.getChildren().add(content);
		
		return lowerSpace;
	}
	
	
	private Node createContent() {
		Content content = new Content().initialize();
		content.setNavigationSelectionProperty(navigationBar.selectedPage());
		
		VBox contentBox = new VBox();
		contentBox.setMinSize(CONENT_WIDTH, LOWER_CONENT_HIGHT);
		contentBox.setPrefSize(CONENT_WIDTH, LOWER_CONENT_HIGHT);
		contentBox.setMaxSize(CONENT_WIDTH, LOWER_CONENT_HIGHT);
		contentBox.setPadding(CONTENT_INSETS);
		contentBox.setFillWidth(true);
		contentBox.getChildren().add(content.getRoot());
		
		return contentBox;
	}

	//@formatter:off
	public Pane getRootNode() { return mainPane; }
	//@formatter:on
	

	@Override
	public void cleanup() {
		
	}
}
