package hero.highlevel;

import hero.Fire;
import hero.Water;
import hero.base.Hero;
import javafx.scene.paint.Color;
import main.Main;

public class SuperFire extends Fire {

	public SuperFire(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean canKill(int x, int y) {
		Hero hero = Main.gameScreen.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null) {
			return false;
		}
		if(hero instanceof Water) {
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
