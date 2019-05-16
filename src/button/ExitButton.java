package button;

import javafx.scene.image.Image;

public class ExitButton extends ButtonBase {

	public ExitButton(int width, int height, Image unpressedImage, Image hoverImage, Image pressedImage) {
		super(width, height, unpressedImage, hoverImage, pressedImage);
		this.setOnAction(e->{
			System.exit(0);
		});
	}

}
