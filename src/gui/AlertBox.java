package gui;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import Object.GameObject;
import constant.Fonts;
import constant.Numbers;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class AlertBox extends GameObject {
	private String message;
	private Timeline timeline;
	private double count, font_width, font_height;
	public AlertBox(String message) {
		this.message = message;
		this.destroyed = false;
		this.count = 0;
		FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
		font_width = fontLoader.computeStringWidth(this.message, Fonts.exceptionFont);
		font_height = fontLoader.getFontMetrics(Fonts.exceptionFont).getLineHeight();
		this.position = new Point2D((Numbers.FIELD_WIDTH - Numbers.FRAME_SIZE * 2 - font_width) / 2, Numbers.FIELD_HEIGHT - Numbers.FRAME_SIZE * 2 - font_height);
		this.size = new Point2D(font_width + Numbers.FRAME_SIZE * 2, font_height + Numbers.FRAME_SIZE * 2);
		timeline = new Timeline(new KeyFrame(Duration.millis(10),e->{
			if(this.count <= Numbers.ALERTBOX_MOVEFRAME)this.position = new Point2D(this.position.getX(), ((double)(Numbers.FIELD_HEIGHT - Numbers.FRAME_SIZE * 2 - font_height) - 
			   (count / Numbers.ALERTBOX_MOVEFRAME) * ((Numbers.FIELD_HEIGHT - Numbers.FRAME_SIZE * 2 - font_height) - Numbers.ALERTBOX_HEIGHTPOSITION)));
			if(this.count == Numbers.ALERTBOX_FRAMENUMBER) {
				this.destroyed = true;
				this.timeline.stop();
			}
			this.count++;
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(this.position.getX(), this.position.getY(), this.size.getX(), this.size.getY());
		gc.setFill(Color.WHITE);
		gc.setFont(Fonts.exceptionFont);
		gc.fillText(this.message, this.position.getX() + Numbers.FRAME_SIZE, this.position.getY() + this.font_height + Numbers.FRAME_SIZE);
	}

	@Override
	public int getZ() {
		return 3;
	}

}
