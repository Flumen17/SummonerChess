package hero.highlevel;

import hero.Plant;
import hero.Water;
import hero.base.Hero;
import javafx.scene.paint.Color;
import main.Main;

public class SuperWater extends Water {

	public SuperWater(int x, int y, Color color) {
		super(x, y, color);
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
