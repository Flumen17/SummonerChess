package heroBase.hero;

import Object.Tower;
import constant.Images;
import field.cell.Cell;
import heroBase.FireBase;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.WaterBase;
import heroBase.hybridHero.FirePlant;
import heroBase.property.DiagonalMoveable;
import heroBase.property.Sacrifice;
import heroBase.superHero.SuperFire;
import javafx.scene.paint.Color;
import main.Main;

public class Fire extends FireBase implements DiagonalMoveable, Sacrifice {
	
	public Fire(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.FIRE;
		if(color == Color.BLACK)this.image = Images.fire_BG;
		else this.image = Images.fire_WG;
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
		return canMoveDiagonal(x, y);
	}
	
	@Override
	public boolean canKill(int x, int y) {
		Tower tower = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower();
		Hero hero = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null && tower == null) {
			return false;
		}
		if(hero != null && (hero instanceof WaterBase || hero instanceof SuperFire || hero instanceof FirePlant)) {
			return false;
		}
		return canKillDiagonal(x, y);
	}

	@Override
	public boolean canMoveDiagonal(int x, int y) {
		for(int i = -1; i <= 1; i += 2) {
			for(int j = -1; j <= 1; j += 2) {
				if((x == this.getRow() + i) && (y == this.getCol() + j)) {
					return true;
				}
			}
		}
		if(((x == this.getRow() + 2) && (y == this.getCol() + 2) && canMoveDiagonal(x - 1, y - 1))||
		   ((x == this.getRow() + 2) && (y == this.getCol() - 2) && canMoveDiagonal(x - 1, y + 1))||
		   ((x == this.getRow() - 2) && (y == this.getCol() + 2) && canMoveDiagonal(x + 1, y - 1))||
		   ((x == this.getRow() - 2) && (y == this.getCol() - 2) && canMoveDiagonal(x + 1, y + 1))) {						
			return true;
		}
		return false;
	}

	@Override
	public boolean canKillDiagonal(int x, int y) {
		Cell cell = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
		if(cell.getType() == Cell.Type.OUTFIELD) {
			return false;
		}
		if(cell.getHero() != null) {
			for (int i = -1; i <= 1; i += 2) {
				for (int j = -1; j <= 1; j += 2) {
					if ((x == this.getRow() + i) && (y == this.getCol() + j) && (cell.getHero().getColor() != this.getColor())) {
						return true;
					}	
				}
			}
			if (((x == this.getRow() + 2) && (y == this.getCol() + 2) && canMoveDiagonal(x - 1, y - 1))||
				((x == this.getRow() + 2) && (y == this.getCol() - 2) && canMoveDiagonal(x - 1, y + 1))||
				((x == this.getRow() - 2) && (y == this.getCol() + 2) && canMoveDiagonal(x + 1, y - 1))||
				((x == this.getRow() - 2) && (y == this.getCol() - 2) && canMoveDiagonal(x + 1, y + 1))){						
				if (cell.getHero().getColor() != this.getColor()) {
					return true;
				}
			}
		}
		else if(cell.getTower() != null) {
			for (int i = -1; i <= 1; i += 2) {
				for (int j = -1; j <= 1; j += 2) {
					if ((x == this.getRow() + i) && (y == this.getCol() + j) && (cell.getTower().getColor() != this.getColor())) {
						return true;
					}	
				}
			}
			if (((x == this.getRow() + 2) && (y == this.getCol() + 2) && canMoveDiagonal(x - 1, y - 1))||
				((x == this.getRow() + 2) && (y == this.getCol() - 2) && canMoveDiagonal(x - 1, y + 1))||
				((x == this.getRow() - 2) && (y == this.getCol() + 2) && canMoveDiagonal(x + 1, y - 1))||
				((x == this.getRow() - 2) && (y == this.getCol() - 2) && canMoveDiagonal(x + 1, y + 1))){						
				if (cell.getTower().getColor() != this.getColor()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean canBeSacrifice(HeroType heroType) {
		return heroType == HeroType.SUPERFIRE || heroType == HeroType.FIREPLANT || heroType == HeroType.WATERFIRE;
	}

	@Override
	public boolean canBeSacrifice(HeroType heroType1, HeroType heroType2) {
		if(heroType2 == HeroType.FIRE && heroType1 == HeroType.SUPERFIRE) {
			return true;
		}
		else if(heroType2 == HeroType.WATER && heroType1 == HeroType.WATERFIRE) {
			return true;
		}
		else if(heroType2 == HeroType.PLANT && heroType1 == HeroType.FIREPLANT) {
			return true;
		}
		return false;
	}

}