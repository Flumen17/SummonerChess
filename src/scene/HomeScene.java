package scene;

import button.ButtonBase;
import button.ExitButton;
import button.MusicButton;
import button.SoundButton;
import button.TutorialButton;
import constant.Fonts;
import constant.Images;
import constant.Numbers;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.GameRunner;
import main.Main;
import sharedObject.RenderableHolder;

public class HomeScene extends Scene {
	private StackPane root;
	private ButtonBase newGameButton, resumeGameButton, settingButton;
	private TutorialButton tutorialButton;
	private SoundButton soundButton;
	private MusicButton musicButton;
	private ExitButton exitButton;
	public HomeScene() {
		super(new StackPane(), Numbers.WIN_WIDTH, Numbers.WIN_HEIGHT);
		Main.settingScene = new SettingScene();
		root = (StackPane) getRoot();
		root.setBackground(new Background(new BackgroundImage(Images.homeBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		root.setPadding(new Insets(20));
		newGameButton = new ButtonBase("New Game", 270, 90, Images.unPressedButton, Images.overButton, Images.pressedButton, Fonts.buttonFont);
		newGameButton.setOnAction(e->{
			RenderableHolder.getInstance().getGameObjects().clear();
			if(Main.settingScene != null) {
				Main.gameHolder = Main.settingScene.getGameHolder();
			}
			if(Main.gameScene != null) {
				SoundButton.soundButtons.remove(Main.gameScene.getGamePart().getSoundButton());
				MusicButton.musicButtons.remove(Main.gameScene.getGamePart().getMusicButton());
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
		buttons.setPrefSize(1560, 960);
		buttons.setAlignment(Pos.CENTER);
		buttons.setPadding(new Insets(430, 310, 130, 320));
		buttons.getChildren().addAll(resumeGameButton, newGameButton, settingButton);
		root.setAlignment(Pos.BOTTOM_RIGHT);
		HBox gameButtons = new HBox(10);
		gameButtons.setMaxSize(270, 60);
		gameButtons.setAlignment(Pos.CENTER);
		tutorialButton = new TutorialButton(60, 60, Images.unpressedHowToPlayButton, Images.hoverHowToPlayButton, Images.pressedHowToPlayButton);
		soundButton = new SoundButton(60, 60, Images.unpressedSoundButton, Images.hoverSoundButton, Images.pressedSoundButton);
		musicButton = new MusicButton(60, 60, Images.unpressedMusicButton, Images.hoverMusicButton, Images.pressedMusicButton);
		exitButton = new ExitButton(60, 60, Images.unpressedExitButton, Images.hoverExitButton, Images.pressedExitButton);
		gameButtons.getChildren().addAll(soundButton, musicButton, tutorialButton, exitButton);
		root.getChildren().addAll(buttons, gameButtons);
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
