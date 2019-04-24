package hero;

import hero.base.Hero;
import hero.highlevel.SuperWater;
import hero.hybrid.WaterFire;
import javafx.scene.paint.Color;
import movement.StraightMoveable;

public class Water extends Hero implements StraightMoveable {
	
	public Water(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void showMove() {
		showStraightMove();
	}
	
	@Override
	public boolean canMove(int x, int y) {
		return canMoveStraight(x, y);
	}
	
	@Override
	public boolean canKill(Hero hero) {
		if(hero instanceof Plant || hero instanceof SuperWater || hero instanceof WaterFire) {
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
