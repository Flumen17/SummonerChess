package hero;

import hero.base.Hero;
import hero.highlevel.SuperFire;
import hero.hybrid.FirePlant;
import javafx.scene.paint.Color;
import logic.Cell;
import movement.DiagonalMoveable;

public class Fire extends Hero implements DiagonalMoveable{
	
	public Fire(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void showMove() {
		showDiagonalMove();
	}

	@Override
	public boolean canMove(int x, int y) {
		return canMoveDiagonal(x, y);
	}
	
	@Override
	public boolean canKill(Hero hero) {
		if(hero instanceof Water || hero instanceof SuperFire || hero instanceof FirePlant) {
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
