package dev.dietermai.sailaflash.ui.jfx.screen.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import dev.dietermai.sailaflash.api.bl.IUserFacade;
import dev.dietermai.sailaflash.api.model.IUser;
import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.ui.jfx.Context;
import dev.dietermai.sailaflash.ui.jfx.screen.IScreen;
import dev.dietermai.sailaflash.ui.jfx.util.FxUtil;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LoginScene implements IScreen {
	
	private final IBlService businessLogic;
	private final IUserFacade userStore;
	
	private Label sailaFlashLogo;
	private Label userSelectionPromt;
	private VBox userButtonBox;
	private VBox mainVBox;
	private BorderPane borderPane;
	private StackPane mainPane;
	
	private List<? extends IUser> userList;
	private Map<IUser,Button> userButtonMap;
	
	
	private Consumer<IUserFacade> userListChangedCallback = this::userListChanged;
	
	public LoginScene(){
		this.businessLogic = Context.getInstance().getBlService();
		this.userStore = businessLogic .getUserFacade();
	}

	//@formatter:off
	public Label getSailaFlashLogo() { return sailaFlashLogo; }
	public Label getUserSelectionPromt() { return userSelectionPromt;}
	public VBox getUserButtonBox() { return userButtonBox; }
	public VBox getMainVBox() { return mainVBox; }
	public BorderPane getBorderPane() { return borderPane; }
	public StackPane getMainPane() { return mainPane; }
	public Pane getRootNode() { return mainPane; }
	//@formatter:on
	
	public void initialize() {
		this.userList = new ArrayList<>();
		this.userButtonMap = new HashMap<>();
		
		construct();
		
		businessLogic.getUserFacade().addUserListListener(userListChangedCallback);
		
		refreshUserList();
	}
	
	private void construct() {
		sailaFlashLogo = new Label("Saila Flash");
		sailaFlashLogo.setBackground(FxUtil.getBg(Color.AQUA));
		sailaFlashLogo.setAlignment(Pos.CENTER_LEFT);
		
		userSelectionPromt = new Label("Select User");
		userSelectionPromt.setAlignment(Pos.CENTER_LEFT);
		
		userButtonBox = new VBox();
		userButtonBox.setBackground(FxUtil.getBg(Color.AZURE));
		userButtonBox.setAlignment(Pos.CENTER_LEFT);
		
		mainVBox = new VBox();
		mainVBox.setBackground(FxUtil.getBg(Color.AQUAMARINE));
		mainVBox.setAlignment(Pos.CENTER_LEFT);
		mainVBox.getChildren().add(sailaFlashLogo);
		mainVBox.getChildren().add(userSelectionPromt);
		mainVBox.getChildren().add(userButtonBox);
		
		borderPane = new BorderPane();
		borderPane.setCenter(mainVBox);
		BorderPane.setAlignment(mainVBox, Pos.CENTER_LEFT);
		BorderPane.setMargin(mainVBox, new Insets(0,0,0,200));
		
		mainPane = new StackPane();
		mainPane.getChildren().add(borderPane);
	}

	@Override
	public void cleanup() {
		
	}
	
	
	private void userListChanged(IUserFacade source) {
		FxUtil.inFx(()->refreshUserList());
	}
	
	private void refreshUserList() {
		userButtonBox.getChildren().removeAll(userButtonMap.values());
		userList = userStore.getUserList();
		List<Button> buttonList = new ArrayList<>();
		for(IUser user : userList) {
			Button userButton = new Button(user.getName());
			userButton.setOnAction(actionEvent -> userButtonPressed(actionEvent));
			userButtonMap.put(user, userButton);
			buttonList.add(userButton);
		}
		userButtonBox.getChildren().addAll(buttonList);
	}
	
	private void userButtonPressed(ActionEvent actionEvent) {
		System.out.println("LoginScene.userButtonPressed()");
		Context.getInstance().getMainScreenSM().changeScreen(MainScreens.main);
	}
}
