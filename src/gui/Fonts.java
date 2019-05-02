package gui;

import javafx.scene.text.Font;

public class Fonts {
	public static Font buttonFont, settingFont, gameFont, settingFont2;
	public static void loadResource() {
		buttonFont = loadFont("gomarice_game_music_love.ttf", 30);
		settingFont = loadFont("Super FamiFont.ttf", 30);
		gameFont = loadFont("Pipe_Dream_by_TRIFORCE89.ttf", 30);
		//settingFont2 = loadFont("Argentina free promo.ttf", 30);
		settingFont2 = loadFont("namco__.ttf", 23);
	}
	public static Font loadFont(String path, double size) {
		return Font.loadFont(ClassLoader.getSystemResourceAsStream(path), size);
	}
}
