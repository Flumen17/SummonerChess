package animation;

import java.util.List;

import constant.Numbers;
import heroBase.Hero;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class HeroAnimation extends Transition {
	
	private Image[] animationList;
	private Hero hero;

	public HeroAnimation(Image[] animationList, Hero hero) {
		this.animationList = animationList;
		this.hero = hero;
		this.setCycleCount(INDEFINITE);
		this.setInterpolator(Interpolator.LINEAR);
		this.setCycleDuration(new Duration(Numbers.HERO_ANIMATION_DURATION));
		this.play();
	}
	
	@Override
	protected void interpolate(double arg0) {
		if(arg0 != 1)hero.setImage(animationList[(int)(arg0 * animationList.length)]);
	}
	
}
