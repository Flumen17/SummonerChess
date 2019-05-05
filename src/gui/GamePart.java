package gui;

import constant.Images;
import constant.Numbers;
import constant.Sounds;
import field.Field;
import field.FieldUI;
import field.FloristField;
import field.SquarizerField;
import field.TurbineField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.GameHolder;
import main.Main;

public class GamePart extends StackPane {
	
	private Field logicPane;
	private FieldUI paintPane;
	private ButtonBase homeButton, howToPlayButton, soundButton, musicButton;
	private boolean sound, music;
	
	public GamePart() {
		sound = true;
		music = true;
		this.setPadding(new Insets(Numbers.GAMEPART_EDGEHEIGHT, Numbers.GAMEPART_EDGEWIDTH, Numbers.GAMEPART_EDGEHEIGHT, Numbers.GAMEPART_EDGEWIDTH));
		this.setPrefSize(Numbers.GAMEPART_WIDTH, Numbers.WIN_HEIGHT);
		this.setAlignment(Pos.BOTTOM_RIGHT);
		VBox buttons = new VBox(10);
		homeButton = new ButtonBase(60, 60, Images.unpressedHomeButton, Images.hoverHomeButton, Images.pressedHomeButton);
		homeButton.setOnAction(e->{
			if(Main.homeScene != null) {
				Main.sceneHolder.switchScene(Main.homeScene);
			}
		});
		howToPlayButton = new ButtonBase(60, 60, Images.unpressedHowToPlayButton, Images.hoverHowToPlayButton, Images.pressedHowToPlayButton);
		howToPlayButton.setOnAction(e->{
			
		});
		soundButton = new ButtonBase(60, 60, Images.unpressedSoundButton, Images.hoverSoundButton, Images.pressedSoundButton);
		soundButton.setOnAction(e->{
			if(sound) {
				sound = false;
				Sounds.click.setVolume(0.0);
				Sounds.click2.setVolume(0.0);
				Sounds.heroButtonClick.setVolume(0.0);
				Sounds.invalidClick.setVolume(0.0);
				Sounds.move.setVolume(0.0);
				Sounds.summon.setVolume(0.0);
				Sounds.select.setVolume(0.0);
			}
			else {
				sound = true;
				Sounds.click.setVolume(1.0);
				Sounds.click2.setVolume(1.0);
				Sounds.heroButtonClick.setVolume(1.0);
				Sounds.invalidClick.setVolume(1.0);
				Sounds.move.setVolume(0.3);
				Sounds.summon.setVolume(0.5);
				Sounds.select.setVolume(1.0);
			}
		});
		musicButton = new ButtonBase(60, 60, Images.unpressedMusicButton, Images.hoverMusicButton, Images.pressedMusicButton);
		musicButton.setOnAction(e->{
			if(music) {
				music = false;
				Sounds.gameScene.stop();
				Sounds.homeScene.setVolume(0.0);
				Sounds.settingScene.setVolume(0.0);
				Sounds.winning.setVolume(0.0);
			}
			else {
				music = true;
				Sounds.gameScene.play();
				Sounds.homeScene.setVolume(0.2);
				Sounds.settingScene.setVolume(0.2);
				Sounds.winning.setVolume(1.0);
			}
		});
		buttons.getChildren().addAll(soundButton, musicButton, howToPlayButton, homeButton);
		buttons.setAlignment(Pos.CENTER);
		buttons.setMaxSize(60, 270);
		Image image;
		switch(Main.gameHolder.getGameTheme()) {
			case FIRE : image = Images.fireBackground; break;
			case WATER : image = Images.waterBackground; break;
			case PLANT : image = Images.plantBackground; break;
			case LOVE : image = Images.loveBackground; break;
			default : image = null;
		}
		this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT))); 
		if(Main.gameHolder.getGameField() == GameHolder.GameField.SQUARIZER)logicPane = new SquarizerField();
		else if(Main.gameHolder.getGameField() == GameHolder.GameField.TURBINE)logicPane = new TurbineField();
		else logicPane = new FloristField();
		paintPane = new FieldUI();
		this.getChildren().addAll(paintPane, logicPane, buttons);
	}
	
	public Field getLogicPane() {
		return logicPane;
	}
	
	public FieldUI getPaintPane() {
		return paintPane;
	}
	
}
