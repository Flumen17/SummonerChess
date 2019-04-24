package hero.highlevel;

import hero.Fire;
import hero.Plant;
import hero.base.Hero;
import javafx.scene.paint.Color;

public class SuperPlant extends Plant {

	public SuperPlant(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean canKill(Hero hero) {
		if(hero instanceof Fire) {
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
