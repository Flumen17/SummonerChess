package heroBase.hero;

import Object.Tower;
import animation.HeroAnimation;
import constant.Images;
import field.cell.Cell;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.property.DiagonalMoveable;
import heroBase.property.StraightMoveable;
import javafx.scene.paint.Color;
import main.Main;

public class Summoner extends Hero implements StraightMoveable, DiagonalMoveable{

	public Summoner(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.SUMMONER;
		if(color == Color.BLACK) {
			this.image = Images.summoner_BG;
			animationList = Images.blackSummoner;
			
		}
		else {
			this.image = Images.summoner_WG;
			animationList = Images.whiteSummoner;
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
		return canMoveStraight(x, y) || canMoveDiagonal(x, y);
	}

	@Override
	public boolean canKill(int x, int y) {
		Tower tower = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower();
		Hero hero = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null && tower == null) {
			return false;
		}
		if(this.getFlag() != null && hero.getFlag() != null) {
			return false;
		}
		return canKillStraight(x, y) || canKillDiagonal(x, y);
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
		return false;
	}

	@Override
	public boolean canKillDiagonal(int x, int y) {
		Cell cell = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
		if(cell.getType() == Cell.Type.OUTFIELD) {
			return false;
		}
		if (cell.getHero() != null) {
			for(int i = -1; i <= 1; i += 2) {
				for(int j = -1; j <= 1; j += 2) {
					if((x == this.getRow() + i) && (y == this.getCol() + j) && (cell.getHero().getColor()!= this.getColor())) {
						return true;
					}
				}
			}
		}
		else if(cell.getTower() != null) {
			for (int i = -1; i <= 1; i += 2) {
				for (int j = -1; j <= 1; j += 2) {
					if ((x == this.getRow() + i) && (y == this.getCol() + j) && (cell.getTower().getColor()!= this.getColor())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean canMoveStraight(int x, int y) {
		for(int i = -1; i <= 1; i += 2) {
			if(((x == this.getRow() + i) && (y == this.getCol()))||
			   ((x == this.getRow()) && (y == this.getCol() + i))){
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
		if(cell.getHero()!= null) {
			for(int i = -1; i <= 1; i += 2) {
				if(((x == this.getRow() + i) && (y == this.getCol()))||
				   ((x == this.getRow()) && (y == this.getCol() + i))){
					if (cell.getHero().getColor()!= this.getColor()) {
						return true;
					}
				}
			}
		}
		else if(cell.getTower() != null) {
			for(int i = -1; i <= 1; i += 2) {
				if(((x == this.getRow() + i) && (y == this.getCol()))||
				   ((x == this.getRow()) && (y == this.getCol() + i))){
					if (cell.getTower().getColor() != this.getColor()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}