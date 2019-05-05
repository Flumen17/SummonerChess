package heroBase.hybridHero;

import Object.Tower;
import constant.Images;
import field.cell.Cell;
import heroBase.FireBase;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.PlantBase;
import heroBase.property.StraightMoveable;
import javafx.scene.paint.Color;
import main.Main;

public class PlantWater extends PlantBase implements StraightMoveable {
	
	public PlantWater(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.PLANTWATER;
		if(color == Color.BLACK)this.image = Images.plantWater_BG;
		else this.image = Images.plantWater_WG;
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
		return canMoveSpread(x, y) || canMoveStraight(x, y);
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
		return canKillSpread(x, y) || canKillStraight(x, y);
	}
	
	@Override
	public boolean canMoveSpread(int x, int y) {
		for(int i = -1; i <= 1; i += 2) {
			for(int j = -2; j <= 2 ; j += 4) {
				if(((x == this.getRow() + j) && (y == this.getCol() + i) ) || ((x == this.getRow() + i) && (y == this.getCol() + j))) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean canKillSpread(int x, int y) {
		Cell cell = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
		if (cell.getType() == Cell.Type.OUTFIELD) {
			return false;
		}
		if(cell.getHero() != null) {
			for(int i = -1; i <= 1; i += 2) {
				for(int j = -2; j <= 2 ; j += 4) {
					if(((x == this.getRow() + j) && (y == this.getCol() + i) ) || ((x == this.getRow() + i) && (y == this.getCol() + j) )) {
						if (cell.getHero().getColor() != this.getColor()) {
							return true;
						}
					}
				}
			}
		}
		else if(cell.getTower() != null) {
			for(int i = -1; i <= 1; i += 2) {
				for(int j = -2; j <= 2 ; j += 4) {
					if(((x == this.getRow() + j) && (y == this.getCol() + i) ) || ((x == this.getRow() + i) && (y == this.getCol() + j) )) {
						if (cell.getTower().getColor() != this.getColor()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean canMoveStraight(int x, int y) {
		for(int i = -1; i <= 1; i += 2) {
			if(((x == this.getRow() + i) && (y == this.getCol())) || ((x == this.getRow()) && (y == this.getCol() + i))){
				return true;
			}
		}
		if (((x == this.getRow() + 2) && (y == this.getCol()) && canMoveStraight(x-1, y))||
			((x == this.getRow() - 2) && (y == this.getCol()) && canMoveStraight(x+1, y))||
			((x == this.getRow()) && (y == this.getCol() + 2) && canMoveStraight(x, y-1))||
			((x == this.getRow()) && (y == this.getCol() - 2) && canMoveStraight(x, y+1))) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canKillStraight(int x, int y) {
		Cell cell = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
		if(cell.getType() == Cell.Type.OUTFIELD) {
			return false;
		}
		if(cell.getHero() != null) {
			for(int i = -1; i <= 1; i += 2) {
				if(((x == this.getRow() + i) && (y == this.getCol()))||
				   ((x == this.getRow()) && (y == this.getCol() + i))){
					if(cell.getHero().getColor()!= this.getColor()) {
						return true;
					}
				}
			}
			for(int i = 2; i <= 2; i++) {
				if(((x == this.getRow() + i) && (y == this.getCol()) && canMoveStraight(x-1, y))||
				   ((x == this.getRow() - i) && (y == this.getCol()) && canMoveStraight(x+1, y))||
				   ((x == this.getRow()) && (y == this.getCol() + i) && canMoveStraight(x, y-1))||
				   ((x == this.getRow()) && (y == this.getCol() - i) && canMoveStraight(x, y+1))) {
					if(cell.getHero().getColor()!= this.getColor()) {
						return true;
					}
				}
			}
		}
		if (cell.getTower()!= null) {
			for(int i = -1; i <= 1; i += 2) {
				if(((x == this.getRow() + i) && (y == this.getCol()))||
				   ((x == this.getRow()) && (y == this.getCol() + i))){
					if(cell.getTower().getColor()!= this.getColor()) {
						return true;
					}
				}
			}
			for (int i = 2; i <= 2; i++) {
				if(((x == this.getRow() + i) && (y == this.getCol()) && canMoveStraight(x-1, y))||
				   ((x == this.getRow() - i) && (y == this.getCol()) && canMoveStraight(x+1, y))||
			       ((x == this.getRow()) && (y == this.getCol() + i) && canMoveStraight(x, y-1))||
				   ((x == this.getRow()) && (y == this.getCol() - i) && canMoveStraight(x, y+1))) {
					if(cell.getTower().getColor()!= this.getColor()) {
						return true;
					}
				}
			}
		}
		return false;
	}

}