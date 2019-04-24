package hero.highlevel;

import hero.Plant;
import hero.Water;
import hero.base.Hero;
import javafx.scene.paint.Color;

public class SuperWater extends Water {

	public SuperWater(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean canKill(Hero hero) {
		if(hero instanceof Plant) {
			return false;
		}
		return true;
	}

	@Override
	public void showStraightMove() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public boolean canMoveStraight(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
