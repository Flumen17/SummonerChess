package constant;

import javafx.scene.media.AudioClip;

public class Sounds {
	public static AudioClip click, click2, invalidClick;
	public static AudioClip summon, heroButtonClick, winning, move, select;
	public static AudioClip homeScene, settingScene, gameScene, tutorial;
	public static void loadResource() {
		click = loadSound("click1.wav");
		click2 = loadSound("click2.wav");
		invalidClick = loadSound("invalidclick.wav");
		summon = loadSound("summon.wav");
		heroButtonClick = loadSound("herobuttonclick.wav");
		winning = loadSound("winning.mp3");
		move = loadSound("move.wav");
		move.setVolume(0.3);
		summon.setVolume(0.5);
		select = loadSound("select.wav");
		homeScene = loadSound("homescene.mp3");
		homeScene.setCycleCount(AudioClip.INDEFINITE);
		homeScene.setVolume(0.2);
		settingScene = loadSound("settingscene.mp3");
		settingScene.setCycleCount(AudioClip.INDEFINITE);
		settingScene.setVolume(0.2);
		gameScene = loadSound("gamescene.mp3");
		gameScene.setCycleCount(AudioClip.INDEFINITE);
		gameScene.setVolume(0.2);
		tutorial = loadSound("tutorial.mp3");
		tutorial.setCycleCount(AudioClip.INDEFINITE);
		tutorial.setVolume(0.2);
	}
	public static AudioClip loadSound(String path) {
		return new AudioClip(ClassLoader.getSystemResource("sound/" + path).toString());
	}
}
