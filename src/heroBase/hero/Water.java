package heroBase.hero;

import Object.Tower;
import constant.Images;
import field.cell.Cell;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.PlantBase;
import heroBase.WaterBase;
import heroBase.hybridHero.WaterFire;
import heroBase.property.Sacrifice;
import heroBase.property.StraightMoveable;
import heroBase.superHero.SuperWater;
import javafx.scene.paint.Color;
import main.Main;

public class Water extends WaterBase implements StraightMoveable, Sacrifice {
	
	public Water(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.WATER;
		if(color == Color.BLACK)this.image = Images.water_BG;
		else this.image = Images.water_WG;
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
		return canMoveStraight(x, y);
	}
	
	@Override
	public boolean canKill(int x, int y) {
		Tower tower = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower();
		Hero hero = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null && tower == null) {
			return false;
		}
		if(hero != null && (hero instanceof PlantBase || hero instanceof SuperWater || hero instanceof WaterFire)) {
			return false;
		}
		if(this.getFlag() != null && hero.getFlag() != null) {
			return false;
		}
		return canKillStraight(x, y);
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

	@Override
	public boolean canBeSacrifice(HeroType heroType) {
		return heroType == HeroType.SUPERWATER || heroType == HeroType.WATERFIRE || heroType == HeroType.PLANTWATER;
	}

	@Override
	public boolean canBeSacrifice(HeroType heroType1, HeroType heroType2) {
		if(heroType2 == HeroType.FIRE && heroType1 == HeroType.WATERFIRE) {
			return true;
		}
		else if(heroType2 == HeroType.WATER && heroType1 == HeroType.SUPERWATER) {
			return true;
		}
		else if(heroType2 == HeroType.PLANT && heroType1 == HeroType.PLANTWATER) {
			return true;
		}
		return false;
	}

}