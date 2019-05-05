package Object;

import java.util.List;

import constant.Images;
import constant.Numbers;
import heroBase.Hero;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class GodHero extends GameObject {

	private Timeline timeline;
	private double count;
	public GodHero(Color color, List<Hero> heroes) {
		this.count = 0;
		this.destroyed = false;
		if(color == Color.BLACK) {
			this.image = Images.bGod;
		}
		else {
			this.image = Images.wGod;
		}
		this.size = new Point2D(300, 450);
		this.position = new Point2D(350, 0);
		timeline = new Timeline(new KeyFrame(Duration.millis(10), e->{
			if(this.count <= Numbers.ALERTBOX_MOVEFRAME)this.position = new Point2D(this.position.getX(), (count / Numbers.ALERTBOX_MOVEFRAME) * 225);
			int index = (int)(count / ((Numbers.ALERTBOX_FRAMENUMBER + 50) / heroes.size()));
			if(index != heroes.size())heroes.get(index).die();
			if(this.count == Numbers.ALERTBOX_FRAMENUMBER + 50) {
				this.destroyed = true;
			}
			this.count++;
		}));
		timeline.setCycleCount(Numbers.ALERTBOX_FRAMENUMBER + 51);
		timeline.play();
	}
	
	public Timeline getTimeline() {
		return timeline;
	}
	
	@Override
	public int getZ() {
		return 5;
	}

}
