package scene;

import button.ButtonBase;
import constant.Fonts;
import constant.Images;
import constant.Numbers;
import gui.SettingBox;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameHolder;
import main.Main;

public class SettingScene extends Scene {
	
	HBox root;
	GraphicsContext gc;
	GameHolder gameHolder;
	AnimationTimer animation;
	ButtonBase okButton;
	
	public SettingScene() {
		super(new HBox(), Numbers.WIN_WIDTH, Numbers.WIN_HEIGHT);
		gameHolder = new GameHolder();
		root = (HBox) getRoot();
		root.setAlignment(Pos.CENTER);
		root.setBackground(new Background(new BackgroundImage(Images.settingBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		VBox buttons = new VBox(50);
		buttons.setPrefSize(Numbers.SETTINGBOX_WIDTH, Numbers.WIN_HEIGHT);
		buttons.setAlignment(Pos.CENTER);
		Canvas bg = new Canvas(Numbers.SIMULATEFIELD_WIDTH, Numbers.WIN_HEIGHT);
		gc = bg.getGraphicsContext2D();
		draw();
		SettingBox setGameMode = new SettingBox("Summon The God", "Steal The Flag", "Tower Destroy");
		SettingBox setGameField = new SettingBox("Squarizer", "Turbine", "Florist");
		SettingBox setGameTheme = new SettingBox("Love", "Fire", "Water", "Plant");
		okButton = new ButtonBase("ok", 270, 90, Images.unPressedButton, Images.overButton, Images.pressedButton, Fonts.settingFont);
		okButton.setOnAction(e->{
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
		buttons.getChildren().addAll(box1, box2, box3, okButton);
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
		gc.setFill(Color.BLACK);
		gc.fillRect(52.5, 115, 995, 770);
		gc.drawImage(image, 62.5, 125, 975, 750);
	}
	
	public GameHolder getGameHolder() {
		return this.gameHolder;
	}
	
	public ButtonBase getOkButton() {
		return okButton;
	}
	
}
