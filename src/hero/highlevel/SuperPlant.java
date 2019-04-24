package hero.highlevel;

import hero.Fire;
import hero.Plant;
import hero.base.Hero;
import javafx.scene.paint.Color;
import main.Main;

public class SuperPlant extends Plant {

	public SuperPlant(int x, int y, Color color) {
		super(x, y, color);
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
		return canKillSpread(x, y);
	}

	@Override
	public boolean canMoveSpread(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canKillSpread(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
