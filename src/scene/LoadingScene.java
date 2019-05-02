package scene;

import gui.Images;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import main.Main;

public class LoadingScene extends Scene {
	
	private StackPane root;
	private Timeline t;
	double p = 0;
	public LoadingScene() {
		super(new StackPane(), 1600, 1000);
		root = (StackPane) getRoot();
		Canvas loadingPane = new Canvas(1600, 1000);
		GraphicsContext gc = loadingPane.getGraphicsContext2D();
		root.getChildren().add(loadingPane);
		t = new Timeline(new KeyFrame(Duration.millis(10),e->{
			double tp = Images.getProgress();
			p = tp * 0.1 + p * 0.9;
			if (tp >= 0.99) tp = 1;
			if(tp > 0.99 && p > 0.99) {
				Main.homeScene = new HomeScene();
				Main.sceneHolder.switchScene(Main.homeScene);
				t.stop();
			}
			gc.setFill(Color.AQUA);
			gc.fillRect(500, 475, p * 600, 50);
		}));
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();
	}
	
}
