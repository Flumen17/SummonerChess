package hero.hybrid;

import hero.Fire;
import hero.Plant;
import hero.base.Hero;
import javafx.scene.paint.Color;
import main.Main;
import movement.StraightMoveable;

public class PlantWater extends Plant implements StraightMoveable {
	
	public PlantWater(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean canMove(int x, int y) {
		return super.canMove(x, y) || canMoveStraight(x, y);
	}

	@Override
	public boolean canKill(int x, int y) {
		Hero hero = Main.gameScreen.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null) {
			return false;
		}
		if(hero instanceof Fire) {
			return false;
		}
		return canKillSpread(x, y) || canKillStraight(x, y);
	}

	@Override
	public boolean canMoveStraight(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canKillStraight(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
