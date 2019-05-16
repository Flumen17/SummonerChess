package heroBase.superHero;

import Object.Tower;
import animation.HeroAnimation;
import constant.Images;
import field.cell.Cell;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.PlantBase;
import heroBase.WaterBase;
import javafx.scene.paint.Color;
import main.Main;

public class SuperWater extends WaterBase {

	public SuperWater(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.SUPERWATER;
		if(color == Color.BLACK) {
			this.image = Images.superWater_BG;
			animationList = Images.blackSuperWater;
			
		}
		else {
			this.image = Images.superWater_WG;
			animationList = Images.whiteSuperWater;
		}
		this.heroAnimation = new HeroAnimation(animationList, this);
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
		if(hero instanceof PlantBase) {
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
			if(((x == this.getRow() + i) && (y == this.getCol()))||
			   ((x == this.getRow()) && (y == this.getCol() + i))){
				return true;
			}
		}
		for(int i = 2; i <= 4; i++) {
			if(((x == this.getRow() + i) && (y == this.getCol()) && canMoveStraight(x-1, y))||
			   ((x == this.getRow() - i) && (y == this.getCol()) && canMoveStraight(x+1, y))||
			   ((x == this.getRow()) && (y == this.getCol() + i) && canMoveStraight(x, y-1))||
		       ((x == this.getRow()) && (y == this.getCol() - i) && canMoveStraight(x, y+1))) {
					return true;
			}
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
					if(cell.getHero().getColor() != this.getColor()) {
						return true;
					}
				}
			}
			for(int i = 2; i <= 4; i++) {
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
		else if(cell.getTower() != null) {
			for(int i = -1; i <= 1; i += 2) {
				if(((x == this.getRow() + i) && (y == this.getCol()))||
					((x == this.getRow()) && (y == this.getCol() + i))){
					if(cell.getTower().getColor() != this.getColor()) {
						return true;
					}
				}
			}
			for (int i = 2; i <= 4; i++) {
				if (((x == this.getRow() + i) && (y == this.getCol()) && canMoveStraight(x-1, y))||
					((x == this.getRow() - i) && (y == this.getCol()) && canMoveStraight(x+1, y))||
					((x == this.getRow()) && (y == this.getCol() + i) && canMoveStraight(x, y-1))||
					((x == this.getRow()) && (y == this.getCol() - i) && canMoveStraight(x, y+1))) {
					if (cell.getTower().getColor()!= this.getColor()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	

}