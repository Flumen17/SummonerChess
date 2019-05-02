package scene;

import gui.ButtonBase;
import gui.Fonts;
import gui.Images;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameHolder;
import logic.GameRunner;
import main.Main;
import sharedObject.RenderableHolder;

public class HomeScene extends Scene {
	private StackPane root;
	private ButtonBase newGamebtn, resumeGamebtn, settingbtn;
	
	public HomeScene() {
		super(new StackPane(), 1600, 1000);
		Main.settingScene = new SettingScene();
		root = (StackPane) getRoot();
		root.setBackground(new Background(new BackgroundImage(Images.homeBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		root.setPadding(new Insets(450, 330, 150, 330));
		newGamebtn  = new ButtonBase("New Game", 270, 90, Images.unPressedButton, Fonts.buttonFont);
		newGamebtn.setOnMousePressed(e->{
			Main.homeScene.getNewGamebtn().changeBackground(Images.pressedButton);
		});
		newGamebtn.setOnMouseEntered(e->{
			Main.homeScene.getNewGamebtn().changeBackground(Images.overButton);
		});
		newGamebtn.setOnMouseExited(e->{
			Main.homeScene.getNewGamebtn().changeBackground(Images.unPressedButton);
		});
		newGamebtn.setOnMouseReleased(e->{
			RenderableHolder.getInstance().getGameObjects().clear();
			Main.gameHolder = Main.settingScene.getGameHolder();
			Main.gameScene = new GameScene();
			Main.sceneHolder.switchScene(Main.gameScene);
			Main.gameRunner = new GameRunner();
		});
		resumeGamebtn  = new ButtonBase("Resume", 270, 90, Images.unPressedButton, Fonts.buttonFont);
		resumeGamebtn.setOnMousePressed(e->{
			Main.homeScene.getResumeGamebtn().changeBackground(Images.pressedButton);
		});
		resumeGamebtn.setOnMouseReleased(e->{
			if(Main.gameScene != null)Main.sceneHolder.switchScene(Main.gameScene);
		});
		resumeGamebtn.setOnMouseEntered(e->{
			Main.homeScene.getResumeGamebtn().changeBackground(Images.overButton);
		});
		resumeGamebtn.setOnMouseExited(e->{
			Main.homeScene.getResumeGamebtn().changeBackground(Images.unPressedButton);
		});
		settingbtn = new ButtonBase("Setting", 270, 90, Images.unPressedButton, Fonts.buttonFont);
		settingbtn.setOnMousePressed(e->{
			Main.homeScene.getSettingbtn().changeBackground(Images.pressedButton);
		});
		settingbtn.setOnMouseReleased(e->{
			if(Main.settingScene != null)Main.sceneHolder.switchScene(Main.settingScene);
		});
		settingbtn.setOnMouseEntered(e->{
			Main.homeScene.getSettingbtn().changeBackground(Images.overButton);
		});
		settingbtn.setOnMouseExited(e->{
			Main.homeScene.getSettingbtn().changeBackground(Images.unPressedButton);
		});
		VBox button = new VBox(20);
		
		button.setAlignment(Pos.CENTER);
		button.getChildren().addAll(resumeGamebtn, newGamebtn, settingbtn);
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(button);
	}

	public ButtonBase getNewGamebtn() {
		return newGamebtn;
	}

	public ButtonBase getResumeGamebtn() {
		return resumeGamebtn;
	}

	public ButtonBase getSettingbtn() {
		return settingbtn;
	}	
	
}
