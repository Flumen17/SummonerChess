package scene;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import constant.Fonts;
import constant.Images;
import constant.Numbers;
import constant.Sounds;
import gui.ActionPart;
import gui.GamePart;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class GameScene extends Scene {
	
	private ActionPart actionPart;
	private GamePart gamePart;
	private Canvas canvas;
	private StackPane root;
	private Timeline winningScene;
	private double count;
	private int winner;
	
	public GameScene() {
		super(new StackPane(), Numbers.WIN_WIDTH, Numbers.WIN_HEIGHT);
		root = (StackPane) getRoot();
		HBox game = new HBox();
		actionPart = new ActionPart();
		gamePart = new GamePart();
		game.getChildren().addAll(actionPart, gamePart);
		canvas = new Canvas(Numbers.WIN_WIDTH, Numbers.WIN_HEIGHT);
		canvas.setVisible(false);
		this.count = 0;
		root.getChildren().addAll(game, canvas);
		winningScene = new Timeline(new KeyFrame(Duration.millis(10),e->{
			if(count == 0) {
				Sounds.gameScene.stop();
				Sounds.winning.play();
			}
			canvas.setVisible(true);
			double size = (double)(count/130)*700;
			double width;
			
			if((int)(count/10)%2 == 0){
				width = ((double)(count%10)/10)*size;
			}
			else {
				width = (1.0-(double)(count%10)/10)*size;
			}
			GraphicsContext gc = this.canvas.getGraphicsContext2D();
			if(count <= 130) {
			gc.clearRect(0, 0, Numbers.WIN_WIDTH, Numbers.WIN_HEIGHT);gc.setFill(Color.BLACK);
			gc.setGlobalAlpha(0.8);
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, Numbers.WIN_WIDTH, Numbers.WIN_HEIGHT);
			gc.setGlobalAlpha(1.0);
			if((int)(count/10)%4 == 0 || (int)(count/10)%4 == 3) {
				gc.drawImage(Images.winningFrame, (Numbers.WIN_WIDTH - width) / 2, (Numbers.WIN_HEIGHT - size) / 2, width, size);
			}
			else {
				gc.drawImage(Images.winningFrame, Numbers.WIN_WIDTH - (Numbers.WIN_WIDTH - width) / 2, (Numbers.WIN_HEIGHT - size) / 2, -width, size);
			}
			}
			else if(count == 131) {
				gc.setFill(Color.WHITE);
				FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
				
				gc.setFont(Fonts.gameFont2);
				if(this.winner == 1) {
					double font_width = fontLoader.computeStringWidth("player one win", Fonts.gameFont2);
					double font_height = fontLoader.getFontMetrics(Fonts.gameFont2).getLineHeight();
					gc.fillText("player one win", (Numbers.WIN_WIDTH - font_width)/2, (Numbers.WIN_HEIGHT - font_height)/2);
					gc.drawImage(Images.summoner_BF, 700, (Numbers.WIN_HEIGHT - font_height)/2 + 20, 200, 200);
				}
				else {
					double font_width = fontLoader.computeStringWidth("player two win", Fonts.gameFont2);
					double font_height = fontLoader.getFontMetrics(Fonts.gameFont2).getLineHeight();
					gc.fillText("player two win", (Numbers.WIN_WIDTH - font_width)/2, (Numbers.WIN_HEIGHT - font_height)/2);
					gc.drawImage(Images.summoner_WF, 700, (Numbers.WIN_HEIGHT - font_height)/2 + 20, 200, 200);
				}		
			}
			this.count++;
		}));
		winningScene.setCycleCount(600);
	}
	
	public ActionPart getActionPart() {
		return actionPart;
	}

	public GamePart getGamePart() {
		return gamePart;
	}
	
	public Timeline getWinningScene() {
		return winningScene;
	}
	
	public void setWinner(int winner) {
		this.winner = winner;
	}

}
