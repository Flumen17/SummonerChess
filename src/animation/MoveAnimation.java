package animation;

import Object.GameObject;
import constant.Numbers;
import heroBase.Hero;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.beans.property.DoubleProperty;
import javafx.util.Duration;

public class MoveAnimation extends Transition {
	
	private double x1, y1, x2, y2, size;
	private GameObject object;
	
	public MoveAnimation(double x1, double y1, double x2, double y2, GameObject object) {
		//System.out.printf("%f %f %f %f\n", x1, y1, x2, y2);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.object = object;
		this.setCycleCount(1);
		this.setInterpolator(Interpolator.EASE_OUT);
		this.setCycleDuration(new Duration(Numbers.HERO_MOVE_DURATION));
		this.play();
	}

	@Override
	protected void interpolate(double arg0) {
		if(arg0 > 0.5) {
			size = 150 - (arg0 - 0.5) * 2 * 50;
			this.setInterpolator(Interpolator.EASE_IN);
		}
		else {
			size = (arg0 * 2) * 50 + 100;	
		}
		object.setSize(size, size);
		double x = x1 + (x2 - x1) * arg0;
		double y = y1 + (y2 - y1) * arg0;
		object.setPostion(x - size / 2, y - size / 2);
	}

}
