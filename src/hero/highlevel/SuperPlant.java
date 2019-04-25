package hero.highlevel;

import hero.Fire;
import hero.Plant;
import hero.base.FireBase;
import hero.base.Hero;
import hero.base.HeroType;
import hero.base.PlantBase;
import javafx.scene.paint.Color;
import logic.Cell;
import main.Main;

public class SuperPlant extends PlantBase {

	public SuperPlant(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.SUPERPLANT;
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
		if(hero instanceof FireBase) {
			return false;
		}
		return canKillSpread(x, y);
	}

	@Override
	public boolean canMoveSpread(int x, int y) {
		Cell consider = Main.gameScreen.getGamePart().getLogicPane().getCellAt(x, y);

		if (consider.getType() != Cell.Type.OUTFIELD) {

			for (int i = -2; i <= 2; i++) {
				for (int j = -2; j <= 2; j++)
				{
					if(1>=i&&i>=-1&&1>=j&&j>=-1) {
						if ((x == this.getxPosition() + i) && (y == this.getyPosition() + j))return false;
					}
					else if (consider.getHero() == null)return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean canKillSpread(int x, int y) {
		Cell consider = Main.gameScreen.getGamePart().getLogicPane().getCellAt(x, y);
	
		if (consider.getType() != Cell.Type.OUTFIELD) {
	
			for (int i = -2; i <= 2; i++) {
				for (int j = -2; j <= 2; j++) {
					if(1>=i&&i>=-1&&1>=j&&j>=-1) {
						if ((x == this.getxPosition() + i) && (y == this.getyPosition() + j))
							 return false;
					}
					else if (consider.getHero() == null)return true;
				}
			}
		}
		return false;
	}
	
}
