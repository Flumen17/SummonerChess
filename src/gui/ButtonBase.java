package gui;

import constant.Sounds;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Font;

public class ButtonBase extends Button {
	
	public ButtonBase(String text, int width, int height, Image unpressedImage, Image hoverImage, Image pressedImage, Font font) {
		super(text);
		this.setFont(font);
		this.setPrefSize(width, height);
		changeBackground(unpressedImage);
		setMouseAction(unpressedImage, hoverImage, pressedImage);
		
	}
	
	public ButtonBase(int width, int height, Image unpressedImage, Image hoverImage, Image pressedImage) {
		this.setPrefSize(width, height);
		changeBackground(unpressedImage);
		setMouseAction(unpressedImage, hoverImage, pressedImage);
	}
	
	public void setMouseAction(Image unpressedImage, Image hoverImage, Image pressedImage) {
		this.setOnMousePressed(e->{
			this.changeBackground(pressedImage);
		});
		this.setOnMouseReleased(e->{
			this.changeBackground(unpressedImage);
			Sounds.click.play();
		});
		this.setOnMouseEntered(e->{
			this.changeBackground(hoverImage);
		});
		this.setOnMouseExited(e->{
			if(!e.isPrimaryButtonDown()) {
				this.changeBackground(unpressedImage);
			}
		});
	}
	
	public void changeBackground(Image image) {
		this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
	}
	
}
