package hero.hybrid;

import hero.Plant;
import hero.Water;
import hero.base.Hero;
import javafx.scene.paint.Color;
import main.Main;
import movement.DiagonalMoveable;

public class WaterFire extends Water implements DiagonalMoveable{

	public WaterFire(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean canMove(int x, int y) {
		return super.canMove(x, y) || canMoveDiagonal(x,y);
	}

	@Override
	public boolean canKill(int x, int y) {
		Hero hero = Main.gameScreen.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null) {
			return false;
		}
		if(hero instanceof Plant) {
			return false;
		}
		return canKillStraight(x, y) || canKillDiagonal(x, y);
	}

	@Override
	public boolean canMoveDiagonal(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canKillDiagonal(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
