package gui;

import button.ButtonBase;
import button.HomeButton;
import button.MusicButton;
import button.SoundButton;
import button.TutorialButton;
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
import scene.TutorialScene;

public class GamePart extends StackPane {
	
	private Field logicPane;
	private FieldUI paintPane;
	private HomeButton homeButton;
	private TutorialButton tutorialButton;
	private SoundButton soundButton;
	private MusicButton musicButton;
	
	public GamePart() {
		this.setPadding(new Insets(Numbers.GAMEPART_EDGEHEIGHT, Numbers.GAMEPART_EDGEWIDTH, Numbers.GAMEPART_EDGEHEIGHT, Numbers.GAMEPART_EDGEWIDTH));
		this.setPrefSize(Numbers.GAMEPART_WIDTH, Numbers.WIN_HEIGHT);
		this.setAlignment(Pos.BOTTOM_RIGHT);
		VBox buttons = new VBox(10);
		homeButton = new HomeButton(60, 60, Images.unpressedHomeButton, Images.hoverHomeButton, Images.pressedHomeButton);
		tutorialButton = new TutorialButton(60, 60, Images.unpressedHowToPlayButton, Images.hoverHowToPlayButton, Images.pressedHowToPlayButton);
		soundButton = new SoundButton(60, 60, Images.unpressedSoundButton, Images.hoverSoundButton, Images.pressedSoundButton);
		musicButton = new MusicButton(60, 60, Images.unpressedMusicButton, Images.hoverMusicButton, Images.pressedMusicButton);
		buttons.getChildren().addAll(soundButton, musicButton, tutorialButton, homeButton);
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

	public SoundButton getSoundButton() {
		return soundButton;
	}

	public MusicButton getMusicButton() {
		return musicButton;
	}
	
	
	
}
