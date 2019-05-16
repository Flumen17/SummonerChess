package button;

import javafx.scene.image.Image;
import main.Main;

public class HomeButton extends ButtonBase {

	public HomeButton(int width, int height, Image unpressedImage, Image hoverImage, Image pressedImage) {
		super(width, height, unpressedImage, hoverImage, pressedImage);
		this.setOnAction(e->{
			if(Main.homeScene != null) {
				Main.sceneHolder.switchScene(Main.homeScene);
			}
		});
	}
	
}
