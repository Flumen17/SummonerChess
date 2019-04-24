package hero;

import hero.base.Hero;
import hero.highlevel.SuperFire;
import hero.hybrid.FirePlant;
import javafx.scene.paint.Color;
import logic.Cell;
import main.Main;
import movement.DiagonalMoveable;

public class Fire extends Hero implements DiagonalMoveable{
	
	public Fire(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean canMove(int x, int y) {
		return canMoveDiagonal(x, y);
	}
	
	@Override
	public boolean canKill(int x, int y) {
		Hero hero = Main.gameScreen.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null) {
			return false;
		}
		if(hero instanceof Water || hero instanceof SuperFire || hero instanceof FirePlant) {
			return false;
		}
		return canKillDiagonal(x, y);
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
