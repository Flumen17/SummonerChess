package scene;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Main;
//import main.Main;

public class SceneHolder {
	
	private Scene currentScene;
	private Stage stage;
	
	public SceneHolder(Stage stage) {
		super();
		this.stage = stage;
		Main.loadingScene = new LoadingScene();
		stage.setScene(Main.loadingScene);
	}
	
	public void switchScene(Scene scene) {
		stage.setScene(scene);
	}
	
	public Scene getScene() {
		return currentScene;
	}
	
}
