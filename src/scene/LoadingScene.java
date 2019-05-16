package scene;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import constant.Fonts;
import constant.Images;
import constant.Numbers;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import main.Main;

public class LoadingScene extends Scene {
	
	private StackPane root;
	private Timeline timeline;
	double progress = 0, opacity = 1.0;
	int count = 0;
	public LoadingScene() {
		super(new StackPane(), Numbers.WIN_WIDTH, Numbers.WIN_HEIGHT);
		root = (StackPane) getRoot();
		Canvas loadingPane = new Canvas(Numbers.WIN_WIDTH, Numbers.WIN_HEIGHT);
		GraphicsContext gc = loadingPane.getGraphicsContext2D();
		root.getChildren().add(loadingPane);
		FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
		timeline = new Timeline(new KeyFrame(Duration.millis(10),e->{
			gc.setGlobalAlpha(opacity);
			double imageProgress = Images.getProgress();
			progress = imageProgress * 0.1 + progress * 0.9;
			if (progress >= 0.99) progress = 1;
			gc.clearRect(0, 0, loadingPane.getWidth(), loadingPane.getHeight());
			gc.drawImage(Images.loadingBackground, 0, 0);
			gc.setLineWidth(2);
			gc.setFill(Color.YELLOWGREEN);
			gc.setStroke(Color.BLACK);
			gc.setFont(Fonts.loadingFont);
			String text;
			if((count/50) % 4 == 0) {
				text ="Loading";
			}
			else if((count/50)%4 == 1) {
				text = "Loading.";
			}
			else if((count/50)%4 == 2) {
				text = "Loading..";
			}
			else {
				text = "Loading...";
			}
			double font_width = fontLoader.computeStringWidth(text, Fonts.loadingFont);
			gc.fillText(text, 500 + (600 - font_width) / 2, 470 );
			gc.strokeText(text, 500 + (600 - font_width) / 2, 470  );
			gc.setFill(Color.DARKRED);
			gc.fillRoundRect(495, 525, 610, 60, 30, 30);
			gc.setFill(Color.WHITESMOKE);
			gc.fillRoundRect(500, 530, progress * 500 + 100, 50, 30, 30);
			gc.setFill(Color.DARKORANGE);
			gc.fillRoundRect(500, 530, progress * 500 + 90, 50, 30, 30);
			count++;
			if(progress > 0.99 && imageProgress > 0.99) {
				if(opacity>0.1)opacity *= 0.99;
				else opacity *= 0.95;
				if(opacity <= 0.001)opacity = 0.0;
				gc.setGlobalAlpha(1.0 - opacity);
				gc.drawImage(Images.loveHomeBackground, 0, 1000 - (1.0 - opacity) * 1000);
				gc.drawImage(Images.fireHomeBackground, 0, (1.0 - opacity) * 1000 - 1000);
				gc.drawImage(Images.waterHomeBackground, 0, 1000 - (1.0 - opacity) * 1000);
				gc.drawImage(Images.plantHomeBackground, 0, (1.0 - opacity) * 1000 - 1000);
				if(opacity <= 0.1) {
					gc.drawImage(Images.tabletHomeBackground, 0, (1.0 - opacity * 10) * 1000 - 1000);
					gc.drawImage(Images.summonersHomeBackground, 0, (1.0 - opacity * 10) * 1000 - 1000);
				}
				if(opacity == 0.0) {
					Main.homeScene = new HomeScene();
					Main.sceneHolder.switchScene(Main.homeScene);
					timeline.stop();
				}
			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
}
