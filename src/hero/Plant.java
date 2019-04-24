package hero;

import hero.base.Hero;
import hero.highlevel.SuperPlant;
import hero.hybrid.PlantWater;
import javafx.scene.paint.Color;
import main.Main;
import movement.SpreadMoveable;

public class Plant extends Hero implements SpreadMoveable {
	
	public Plant(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean canMove(int x, int y) {
		return canMoveSpread(x, y);
	}

	@Override
	public boolean canKill(int x, int y) {
		Hero hero = Main.gameScreen.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null) {
			return false;
		}
		if(hero instanceof Fire || hero instanceof SuperPlant || hero instanceof PlantWater) {
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
