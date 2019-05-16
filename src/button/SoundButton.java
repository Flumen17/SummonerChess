package button;

import java.util.ArrayList;
import java.util.List;

import constant.Images;
import constant.Sounds;
import javafx.scene.image.Image;
import logic.GameHolder;

public class SoundButton extends ButtonBase {

	public static List<SoundButton> soundButtons = new ArrayList<SoundButton>();
	public SoundButton(int width, int height, Image unpressedImage, Image hoverImage, Image pressedImage) {
		super(width, height, unpressedImage, hoverImage, pressedImage);
		if(!GameHolder.sound) {
			this.changeBackground(Images.muteSoundButton);
		}
		this.setOnAction(e->{
			if(GameHolder.sound) {
				GameHolder.sound = false;
				for(int i = 0; i < soundButtons.size(); i++) {
					soundButtons.get(i).changeBackground(Images.muteSoundButton);
				}
				Sounds.click.setVolume(0.0);
				Sounds.click2.setVolume(0.0);
				Sounds.heroButtonClick.setVolume(0.0);
				Sounds.invalidClick.setVolume(0.0);
				Sounds.move.setVolume(0.0);
				Sounds.summon.setVolume(0.0);
				Sounds.select.setVolume(0.0);
			}
			else {
				GameHolder.sound = true;
				for(int i = 0; i < soundButtons.size(); i++) {
					soundButtons.get(i).changeBackground(Images.unpressedSoundButton);
				}
				Sounds.click.setVolume(1.0);
				Sounds.click2.setVolume(1.0);
				Sounds.heroButtonClick.setVolume(1.0);
				Sounds.invalidClick.setVolume(1.0);
				Sounds.move.setVolume(0.3);
				Sounds.summon.setVolume(0.5);
				Sounds.select.setVolume(1.0);
			}
		});
		SoundButton.soundButtons.add(this);
	}
	
	@Override
	public void setMouseAction(Image unpressedImage, Image hoverImage, Image pressedImage) {
		this.setOnMousePressed(e->{
			if(GameHolder.sound)this.changeBackground(pressedImage);
		});
		this.setOnMouseReleased(e->{
			if(GameHolder.sound)this.changeBackground(unpressedImage);
			Sounds.click.play();
		});
		this.setOnMouseEntered(e->{
			if(GameHolder.sound)this.changeBackground(hoverImage);
		});
		this.setOnMouseExited(e->{
			if(!e.isPrimaryButtonDown()) {
				if(GameHolder.sound)this.changeBackground(unpressedImage);
			}
		});
	}

}
