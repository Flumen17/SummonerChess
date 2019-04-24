package hero.hybrid;

import hero.Plant;
import hero.Water;
import hero.base.Hero;
import javafx.scene.paint.Color;
import movement.DiagonalMoveable;

public class WaterFire extends Water implements DiagonalMoveable{

	public WaterFire(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void showMove() {
		super.showMove();
		showDiagonalMove();
	}

	@Override
	public boolean canMove(int x, int y) {
		return super.canMove(x, y) || canMoveDiagonal(x,y);
	}

	@Override
	public boolean canKill(Hero hero) {
		if(hero instanceof Plant) {
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
