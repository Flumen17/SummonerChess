package button;

import java.util.ArrayList;
import java.util.List;

import constant.Images;
import constant.Sounds;
import javafx.scene.image.Image;
import logic.GameHolder;
import main.Main;
import scene.GameScene;
import scene.HomeScene;
import scene.SettingScene;
import scene.TutorialScene;

public class MusicButton extends ButtonBase {
	
	public static List<MusicButton> musicButtons = new ArrayList<MusicButton>();
	
	public MusicButton(int width, int height, Image unpressedImage, Image hoverImage, Image pressedImage) {
		super(width, height, unpressedImage, hoverImage, pressedImage);
		if(!GameHolder.music) {
			this.changeBackground(Images.muteMusicButton);
		}
		this.setOnAction(e->{
			if(GameHolder.music) {
				GameHolder.music = false;
				for(int i = 0; i < musicButtons.size(); i++) {
					musicButtons.get(i).changeBackground(Images.muteMusicButton);
				}
				Sounds.gameScene.setVolume(0.0);
				Sounds.homeScene.setVolume(0.0);
				Sounds.settingScene.setVolume(0.0);
				Sounds.winning.setVolume(0.0);
				Sounds.tutorial.setVolume(0.0);
				if(Sounds.gameScene.isPlaying())Sounds.gameScene.stop();
				if(Sounds.homeScene.isPlaying())Sounds.homeScene.stop();
				if(Sounds.settingScene.isPlaying())Sounds.settingScene.stop();
				if(Sounds.winning.isPlaying())Sounds.winning.stop();
				if(Sounds.tutorial.isPlaying())Sounds.tutorial.stop();
			}
			else {
				GameHolder.music = true;
				for(int i = 0; i < musicButtons.size(); i++) {
					musicButtons.get(i).changeBackground(Images.unpressedMusicButton);
				}
				Sounds.gameScene.setVolume(0.2);
				Sounds.homeScene.setVolume(0.2);
				Sounds.settingScene.setVolume(0.2);
				Sounds.winning.setVolume(1.0);
				Sounds.tutorial.setVolume(0.2);
				if(Main.sceneHolder.getScene() instanceof GameScene) {
					if(!Sounds.gameScene.isPlaying())Sounds.gameScene.play();
					else {
						Sounds.gameScene.stop();
						Sounds.gameScene.play();
					}
				}
				else if(Main.sceneHolder.getScene() instanceof HomeScene) {
					if(!Sounds.homeScene.isPlaying())Sounds.homeScene.play();
					else {
						Sounds.homeScene.stop();
						Sounds.homeScene.play();
					}
				}
				else if(Main.sceneHolder.getScene() instanceof SettingScene) {
					if(!Sounds.settingScene.isPlaying())Sounds.settingScene.play();
					else {
						Sounds.settingScene.stop();
						Sounds.settingScene.play();
					}
				}
				else if(Main.sceneHolder.getScene() instanceof TutorialScene) {
					if(!Sounds.tutorial.isPlaying())Sounds.tutorial.play();
					else {
						Sounds.tutorial.stop();
						Sounds.tutorial.play();
					}
				}
			}
		});
		MusicButton.musicButtons.add(this);
	}

	@Override
	public void setMouseAction(Image unpressedImage, Image hoverImage, Image pressedImage) {
		this.setOnMousePressed(e->{
			if(GameHolder.music)this.changeBackground(pressedImage);
		});
		this.setOnMouseReleased(e->{
			if(GameHolder.music)this.changeBackground(unpressedImage);
			Sounds.click.play();
		});
		this.setOnMouseEntered(e->{
			if(GameHolder.music)this.changeBackground(hoverImage);
		});
		this.setOnMouseExited(e->{
			if(!e.isPrimaryButtonDown()) {
				if(GameHolder.music)this.changeBackground(unpressedImage);
			}
		});
	}
	
	
	
}
