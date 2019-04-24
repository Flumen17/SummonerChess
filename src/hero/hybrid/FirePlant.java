package hero.hybrid;

import hero.Fire;
import hero.Water;
import hero.base.Hero;
import javafx.scene.paint.Color;
import main.Main;
import movement.SpreadMoveable;

public class FirePlant extends Fire implements SpreadMoveable {

	
	public FirePlant(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean canMove(int x, int y) {
		return super.canMove(x, y) || canMoveSpread(x,y);
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
		return canKillDiagonal(x, y) || canKillSpread(x, y);
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
