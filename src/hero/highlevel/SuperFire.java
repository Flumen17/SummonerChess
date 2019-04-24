package hero.highlevel;

import hero.Fire;
import hero.Water;
import hero.base.Hero;
import javafx.scene.paint.Color;

public class SuperFire extends Fire {

	public SuperFire(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean canKill(Hero hero) {
		if(hero instanceof Water) {
			return false;
		}
		return true;
	}

	@Override
	public void showDiagonalMove() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean canMoveDiagonal(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
