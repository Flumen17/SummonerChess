package heroBase.superHero;

import field.Cell;
import gui.Images;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.PlantBase;
import heroBase.hero.Fire;
import heroBase.hero.Plant;
import javafx.scene.paint.Color;
import logic.Tower;
import main.Main;

public class SuperPlant extends PlantBase {

	public SuperPlant(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.SUPERPLANT;
		if(color == Color.BLACK)this.image = Images.superPlant_BG;
		else this.image = Images.superPlant_WG;
	}
	
	@Override
	public boolean canMove(int x, int y) {
		return canMoveSpread(x, y);
	}
	
	@Override
	public boolean canKill(int x, int y) {
		Tower tower = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower();
		Hero hero = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null && tower == null) {
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
		Cell consider = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);

		if (consider.getType() != Cell.Type.OUTFIELD) {
			if(consider.getTower() != null)return false;
			for (int i = -2; i <= 2; i++) {
				for (int j = -2; j <= 2; j++)
				{
					if ((x == this.getRow() + i) && (y == this.getCol() + j)) {
						if(1>=i&&i>=-1&&1>=j&&j>=-1) return false;
						else if (consider.getHero() == null)return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean canKillSpread(int x, int y) {
			// TODO Auto-generated method stub
			Cell consider = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
	
			if (consider.getType() != Cell.Type.OUTFIELD) {
	
				for (int i = -2; i <= 2; i++) {
					for (int j = -2; j <= 2; j++)
					{
						if ((x == this.getRow() + i) && (y == this.getCol() + j)) {
							if(1>=i&&i>=-1&&1>=j&&j>=-1) return false;
							else{
								if (consider.getHero().getColor() != this.getColor())return true;
								if(consider.getTower() != null && consider.getTower().getColor() != this.getColor())return true;
							}
							
						}
					}
				}
			}
			return false;
		}

	
}