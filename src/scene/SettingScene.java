package scene;

import gui.ButtonBase;
import gui.Fonts;
import gui.Images;
import gui.SettingBox;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import logic.GameHolder;
import logic.GameRunner;
import main.Main;
import sharedObject.RenderableHolder;

public class SettingScene extends Scene {
	HBox root;
	GraphicsContext gc;
	GameHolder gameHolder;
	AnimationTimer animation;
	ButtonBase ok;
	public SettingScene() {
		super(new HBox(), 1600, 1000);
		gameHolder = new GameHolder();
		root = (HBox) getRoot();
		root.setAlignment(Pos.CENTER);
		root.setBackground(new Background(new BackgroundImage(Images.settingBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		VBox buttons = new VBox(50);
		buttons.setPrefSize(500, 1000);
		buttons.setAlignment(Pos.CENTER);
		Canvas bg = new Canvas(1100, 1000);
		gc = bg.getGraphicsContext2D();
		draw();
		SettingBox setGameMode = new SettingBox("Summon The God", "Steal The Flag", "Tower Destroy");
		SettingBox setGameField = new SettingBox("Squarizer", "Turbine", "Florist");
		SettingBox setGameTheme = new SettingBox("Love", "Fire", "Water", "Plant");
		ok = new ButtonBase("ok", 270, 90, Images.unPressedButton, Fonts.settingFont);
		ok.setOnMousePressed(e->{
			this.getOk().changeBackground(Images.pressedButton);
		});
		ok.setOnMouseEntered(e->{
			this.getOk().changeBackground(Images.overButton);
		});
		ok.setOnMouseExited(e->{
			this.getOk().changeBackground(Images.unPressedButton);
		});
		ok.setOnMouseReleased(e->{
			if(Main.homeScene != null) {
				Main.sceneHolder.switchScene(Main.homeScene);
			}
			else System.out.println("null");
		});
		Label label1 = new Label("game mode");
		label1.setFont(Fonts.settingFont2);
		Label label2 = new Label("game field");
		label2.setFont(Fonts.settingFont2);
		Label label3 = new Label("game theme");
		label3.setFont(Fonts.settingFont2);
		VBox box1 = new VBox(10);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(label1, setGameMode);
		VBox box2 = new VBox(10);
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(label2, setGameField);
		VBox box3 = new VBox(10);
		box3.setAlignment(Pos.CENTER);
		box3.getChildren().addAll(label3, setGameTheme);
		buttons.getChildren().addAll(box1, box2, box3, ok);
		root.getChildren().addAll(buttons, bg);
		animation = new AnimationTimer() {
			public void handle(long now) {
				if(setGameMode.getCurrentLabelText() == "Summon The God") {
					gameHolder.setGameMode(GameHolder.GameMode.SUMMONTHEGOD);
				}
				else if(setGameMode.getCurrentLabelText() == "Steal The Flag") {
					gameHolder.setGameMode(GameHolder.GameMode.STEALTHEFLAG);
				}
				else {
					gameHolder.setGameMode(GameHolder.GameMode.TOWERDESTROY);
				}
				if(setGameField.getCurrentLabelText() == "Squarizer") {
					gameHolder.setGameField(GameHolder.GameField.SQUARIZER);
				}
				else if(setGameField.getCurrentLabelText() == "Turbine") {
					gameHolder.setGameField(GameHolder.GameField.TURBINE);
				}
				else {
					gameHolder.setGameField(GameHolder.GameField.FLORIST);
				}
				if(setGameTheme.getCurrentLabelText() == "Love") {
					gameHolder.setGameTheme(GameHolder.GameTheme.LOVE);
				}
				else if(setGameTheme.getCurrentLabelText() == "Fire") {
					gameHolder.setGameTheme(GameHolder.GameTheme.FIRE);
				}
				else if(setGameTheme.getCurrentLabelText() == "Water") {
					gameHolder.setGameTheme(GameHolder.GameTheme.WATER);
				}
				else {
					gameHolder.setGameTheme(GameHolder.GameTheme.PLANT);
				}
				Main.settingScene.draw();
			}
		};
		animation.start();
		
	}
	
	public void draw() {
		Image image;
		gc.clearRect(0, 0, 1100, 1000);
		if(gameHolder.getGameTheme() == GameHolder.GameTheme.FIRE) {
			if(gameHolder.getGameField() == GameHolder.GameField.SQUARIZER) {
				image = Images.fireSquarizer;
			}
			else if(gameHolder.getGameField() == GameHolder.GameField.TURBINE) {
				image = Images.fireTurbine;
			}
			else {
				image = Images.fireFlorist;
			}
		}
		else if(gameHolder.getGameTheme() == GameHolder.GameTheme.WATER) {
			if(gameHolder.getGameField() == GameHolder.GameField.SQUARIZER) {
				image = Images.waterSquarizer;
			}
			else if(gameHolder.getGameField() == GameHolder.GameField.TURBINE) {
				image = Images.waterTurbine;
			}
			else {
				image = Images.waterFlorist;
			}
		}
		else if(gameHolder.getGameTheme() == GameHolder.GameTheme.PLANT) {
			if(gameHolder.getGameField() == GameHolder.GameField.SQUARIZER) {
				image = Images.plantSquarizer;
			}
			else if(gameHolder.getGameField() == GameHolder.GameField.TURBINE) {
				image = Images.plantTurbine;
			}
			else {
				image = Images.plantFlorist;
			}
		}
		else {
			if(gameHolder.getGameField() == GameHolder.GameField.SQUARIZER) {
				image = Images.loveSquarizer;
			}
			else if(gameHolder.getGameField() == GameHolder.GameField.TURBINE) {
				image = Images.loveTurbine;
			}
			else {
				image = Images.loveFlorist;
			}
		}
		gc.drawImage(image, 62.5, 125, 975, 750);
	}
	
	public GameHolder getGameHolder() {
		return this.gameHolder;
	}
	public ButtonBase getOk() {
		return ok;
	}
}
