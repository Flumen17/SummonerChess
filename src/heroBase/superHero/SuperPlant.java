package heroBase.superHero;

import Object.Tower;
import constant.Images;
import field.cell.Cell;
import heroBase.FireBase;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.PlantBase;
import javafx.scene.paint.Color;
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
		Cell cell = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
		if(cell.getType() == Cell.Type.OUTFIELD){
			return false;
		}
		if(cell.getTower() != null || cell.getHero() != null) {
			return false;
		}
		if(cell.getFlag() != null && this.getFlag() != null) {
			return false;
		}
		return canMoveSpread(x, y);
	}
	
	@Override
	public boolean canKill(int x, int y) {
		Tower tower = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower();
		Hero hero = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null && tower == null) {
			return false;
		}
		if(hero instanceof FireBase) {
			return false;
		}
		return canKillSpread(x, y);
	}

	@Override
	public boolean canMoveSpread(int x, int y) {
		for(int i = -2; i <= 2; i++) {
			for(int j = -2; j <= 2; j++) {
				if((x == this.getRow() + i) && (y == this.getCol() + j)) {
					if(1 >= i && i >= -1 && 1 >= j && j >= -1) {
						return false;
					}
					else return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean canKillSpread(int x, int y) {
		Cell cell = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
		if(cell.getType() == Cell.Type.OUTFIELD) {
			return false;
		}
		if(cell.getHero() != null) {
			for(int i = -2; i <= 2; i++) {
				for(int j = -2; j <= 2; j++) {
					if((x == this.getRow() + i) && (y == this.getCol() + j)) {
						if(1 >= i && i >= -1 && 1 >= j && j >= -1) {
							return false;
						}
						else if(cell.getHero().getColor() != this.getColor()) {
							return true;
						}
					}
				}
			}
		}
		else if(cell.getTower() != null) {
			for(int i = -2; i <= 2; i++) {
				for(int j = -2; j <= 2; j++) {
					if((x == this.getRow() + i) && (y == this.getCol() + j)) {
						if(1 >= i && i >= -1 && 1 >= j && j >= -1) {
							return false;
						}
						else if(cell.getTower().getColor() != this.getColor()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}