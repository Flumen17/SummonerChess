package button;

import javafx.scene.image.Image;
import logic.GameHolder;
import main.Main;
import scene.TutorialScene;

public class TutorialButton extends ButtonBase {

	public TutorialButton(int width, int height, Image unpressedImage, Image hoverImage, Image pressedImage) {
		super(width, height, unpressedImage, hoverImage, pressedImage);
		this.setOnAction(e->{
			GameHolder.latestScene = Main.sceneHolder.getScene();
			Main.sceneHolder.switchScene(TutorialScene.instance);
		});

	}

}
