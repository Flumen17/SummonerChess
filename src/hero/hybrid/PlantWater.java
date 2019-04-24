package hero.hybrid;

import hero.Fire;
import hero.Plant;
import hero.base.Hero;
import javafx.scene.paint.Color;
import movement.StraightMoveable;

public class PlantWater extends Plant implements StraightMoveable {
	
	public PlantWater(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void showMove() {
		super.showMove();
		showStraightMove();
	}

	@Override
	public boolean canMove(int x, int y) {
		return super.canMove(x, y) || canMoveStraight(x, y);
	}

	@Override
	public boolean canKill(Hero hero) {
		if(hero instanceof Fire) {
			return true;
		}
		return false;
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
