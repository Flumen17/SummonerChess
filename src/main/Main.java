package main;

import constant.Fonts;
import constant.Images;
import constant.Sounds;
import javafx.application.Application;
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
			Sounds.loadResource();
			Images.loadResource();
			
		}).start();
	}	
	
}
