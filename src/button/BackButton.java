package button;

import javafx.scene.image.Image;
import logic.GameHolder;
import main.Main;

public class BackButton extends ButtonBase {

	public BackButton(int width, int height, Image unpressedImage, Image hoverImage, Image pressedImage) {
		super(width, height, unpressedImage, hoverImage, pressedImage);
		this.setOnAction(e->{
			Main.sceneHolder.switchScene(GameHolder.latestScene);
		});
	}

}
