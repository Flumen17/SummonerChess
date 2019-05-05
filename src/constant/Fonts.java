package constant;

import javafx.scene.text.Font;

public class Fonts {
	public static Font buttonFont, settingFont, gameFont, gameFont2, settingFont2, loadingFont, exceptionFont;
	static {
		loadingFont = loadFont("font/Super Mario Bros.ttf", 80);
	}
	public static void loadResource() {	
		buttonFont = loadFont("font/gomarice_game_music_love.ttf", 30);
		settingFont = loadFont("font/Super FamiFont.ttf", 30);
		gameFont = loadFont("font/Pipe_Dream_by_TRIFORCE89.ttf", 30);
		gameFont2 = loadFont("font/Argentina free promo.ttf", 30);
		settingFont2 = loadFont("font/namco__.ttf", 23);
		exceptionFont = loadFont("font/UQ_0.ttf", 50);
	}
	public static Font loadFont(String path, double size) {
		return Font.loadFont(ClassLoader.getSystemResourceAsStream(path), size);
	}
}
