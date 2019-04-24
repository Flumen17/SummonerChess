package hero;

import hero.base.Hero;
import javafx.scene.paint.Color;
import movement.DiagonalMoveable;
import movement.StraightMoveable;

public class Summoner extends Hero implements StraightMoveable, DiagonalMoveable{

	public Summoner(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void showMove() {
		showStraightMove();
		showDiagonalMove();
	}

	@Override
	public boolean canMove(int x, int y) {
		return canMoveStraight(x, y) || canMoveDiagonal(x, y);
	}

	@Override
	public boolean canKill(Hero hero) {
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
