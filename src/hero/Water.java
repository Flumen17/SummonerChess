package hero;

import hero.base.Hero;
import hero.highlevel.SuperWater;
import hero.hybrid.WaterFire;
import javafx.scene.paint.Color;
import main.Main;
import movement.StraightMoveable;

public class Water extends Hero implements StraightMoveable {
	
	public Water(int x, int y, Color color) {
		super(x, y, color);
	}
	
	@Override
	public boolean canMove(int x, int y) {
		return canMoveStraight(x, y);
	}
	
	@Override
	public boolean canKill(int x, int y) {
		Hero hero = Main.gameScreen.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null) {
			return false;
		}
		if(hero instanceof Plant || hero instanceof SuperWater || hero instanceof WaterFire) {
			return false;
		}
		return canKillStraight(x, y);
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
