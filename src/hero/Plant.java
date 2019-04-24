package hero;

import hero.base.Hero;
import hero.highlevel.SuperPlant;
import hero.hybrid.PlantWater;
import javafx.scene.paint.Color;
import movement.SpreadMoveable;

public class Plant extends Hero implements SpreadMoveable {
	
	public Plant(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void showMove() {
		showSpreadMove();
	}

	@Override
	public boolean canMove(int x, int y) {
		return canMoveSpread(x, y);
	}

	@Override
	public boolean canKill(Hero hero) {
		if(hero instanceof Fire || hero instanceof SuperPlant || hero instanceof PlantWater) {
			return false;
		}
		return true;
	}

	@Override
	public void showSpreadMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canMoveSpread(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
