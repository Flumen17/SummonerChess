package scene;

import constant.Sounds;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Main;

public class SceneHolder {
	
	private Scene currentScene;
	private Stage stage;
	
	public SceneHolder(Stage stage) {
		this.stage = stage;
		Main.loadingScene = new LoadingScene();
		stage.setScene(Main.loadingScene);
	}
	
	public void switchScene(Scene scene) {
		currentScene = scene;
		if(Sounds.homeScene.isPlaying())Sounds.homeScene.stop();
		if(Sounds.gameScene.isPlaying())Sounds.gameScene.stop();
		if(Sounds.settingScene.isPlaying())Sounds.settingScene.stop();
		if(Sounds.tutorial.isPlaying())Sounds.tutorial.stop();
		if(scene instanceof HomeScene) {
			Sounds.homeScene.play();
		}
		else if(scene instanceof GameScene) {
			Sounds.gameScene.play();
		}
		else if(scene instanceof SettingScene) {
			Sounds.settingScene.play();
		}
		else if(scene instanceof TutorialScene) {
			Sounds.tutorial.play();
		}
		stage.setScene(scene);
	}
	
	public Scene getScene() {
		return currentScene;
	}
	
}
