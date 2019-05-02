package main;




import gui.Fonts;
import gui.Images;
import heroBase.FireBase;
import heroBase.Hero;
import heroBase.PlantBase;
import heroBase.WaterBase;
import heroBase.hero.Fire;
import heroBase.hero.Plant;
import heroBase.hero.Water;
import heroBase.hybridHero.FirePlant;
import heroBase.hybridHero.PlantWater;
import heroBase.hybridHero.WaterFire;
import heroBase.property.DiagonalMoveable;
import heroBase.property.Sacrifice;
import heroBase.property.SpreadMoveable;
import heroBase.property.StraightMoveable;
import heroBase.superHero.SuperFire;
import heroBase.superHero.SuperPlant;
import heroBase.superHero.SuperWater;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameHolder;
import logic.GameRunner;
import scene.GameScene;
import scene.HomeScene;
import scene.LoadingScene;
import scene.SceneHolder;
import scene.SettingScene;

public class Main extends Application {
	
	public static SceneHolder sceneHolder;
	public static GameScene gameScene;
	public static HomeScene homeScene;
	public static GameRunner gameRunner;
	public static LoadingScene loadingScene;
	public static GameHolder gameHolder;
	public static SettingScene settingScene;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setResizable(false);
		stage.sizeToScene();
		sceneHolder = new SceneHolder(stage);
		stage.setTitle("Summoner Chess");
		stage.show();
		new Thread(() ->  {
			Fonts.loadResource();
			Images.loadResource();
			
		}).start();
	}	
	
}
