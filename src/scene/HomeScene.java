package scene;

import constant.Fonts;
import constant.Images;
import constant.Numbers;
import gui.ButtonBase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.GameRunner;
import main.Main;
import sharedObject.RenderableHolder;

public class HomeScene extends Scene {
	private StackPane root;
	private ButtonBase newGameButton, resumeGameButton, settingButton;
	
	public HomeScene() {
		super(new StackPane(), Numbers.WIN_WIDTH, Numbers.WIN_HEIGHT);
		Main.settingScene = new SettingScene();
		root = (StackPane) getRoot();
		root.setBackground(new Background(new BackgroundImage(Images.homeBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		root.setPadding(new Insets(450, 330, 150, 330));
		newGameButton = new ButtonBase("New Game", 270, 90, Images.unPressedButton, Images.overButton, Images.pressedButton, Fonts.buttonFont);
		newGameButton.setOnAction(e->{
			RenderableHolder.getInstance().getGameObjects().clear();
			if(Main.settingScene != null) {
				Main.gameHolder = Main.settingScene.getGameHolder();
			}
			Main.gameScene = new GameScene();
			Main.sceneHolder.switchScene(Main.gameScene);
			Main.gameRunner = new GameRunner();
		});
		resumeGameButton = new ButtonBase("Resume", 270, 90, Images.unPressedButton, Images.overButton, Images.pressedButton, Fonts.buttonFont);
		resumeGameButton.setOnAction(e->{
			if(Main.gameScene != null)Main.sceneHolder.switchScene(Main.gameScene);
		});
		settingButton = new ButtonBase("Setting", 270, 90, Images.unPressedButton, Images.overButton, Images.pressedButton, Fonts.buttonFont);
		settingButton.setOnAction(e->{
			if(Main.settingScene != null) {
				Main.sceneHolder.switchScene(Main.settingScene);
			}
		});
		VBox buttons = new VBox(20);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(resumeGameButton, newGameButton, settingButton);
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(buttons);
	}

	public ButtonBase getNewGameButton() {
		return newGameButton;
	}

	public ButtonBase getResumeGameButton() {
		return resumeGameButton;
	}

	public ButtonBase getSettingButton() {
		return settingButton;
	}	
	
}
