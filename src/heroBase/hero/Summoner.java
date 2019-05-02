package heroBase.hero;

import field.Cell;
import gui.Images;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.property.DiagonalMoveable;
import heroBase.property.StraightMoveable;
import javafx.scene.paint.Color;
import logic.Tower;
import main.Main;

public class Summoner extends Hero implements StraightMoveable, DiagonalMoveable{

	public Summoner(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.SUMMONER;
		if(color == Color.BLACK)this.image = Images.summoner_BG;
		else this.image = Images.summoner_WG;
	}

	@Override
	public boolean canMove(int x, int y) {
		return canMoveStraight(x, y) || canMoveDiagonal(x, y);
	}

	@Override
	public boolean canKill(int x, int y) {
		Tower tower = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower();
		Hero hero = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null && tower == null) {
			return false;
		}
		return canKillStraight(x, y) || canKillDiagonal(x, y);
	}

	@Override
	public boolean canMoveDiagonal(int x, int y) {
		Cell consider = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);

		if (consider.getType() != Cell.Type.OUTFIELD) {
			if(consider.getTower() != null)return false;
			for (int i = -1; i <= 1; i += 2)
				for (int j = -1; j <= 1; j += 2)
					if ((x == this.getRow() + i) && (y == this.getCol() + j)) {
						if (consider.getHero() == null) return true;
					}
		}
		return false;
	}

	@Override
	public boolean canKillDiagonal(int x, int y) {
		Cell consider = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
		if (consider.getType() != Cell.Type.OUTFIELD && consider.getTower()!= null) {
			for (int i = -1; i <= 1; i += 2)
				for (int j = -1; j <= 1; j += 2)
					if ((x == this.getRow() + i) && (y == this.getCol() + j) 
							&& (consider.getTower().getColor()!= this.getColor())) {
						return true;
					}
		}
		if (consider.getType() != Cell.Type.OUTFIELD && consider.getHero()!= null) {

			for (int i = -1; i <= 1; i += 2)
				for (int j = -1; j <= 1; j += 2)
					if ((x == this.getRow() + i) && (y == this.getCol() + j) 
							&& (consider.getHero().getColor()!= this.getColor())) {
							return true;
					}
		}
		return false;
	}

	@Override
	public boolean canMoveStraight(int x, int y) {
		Cell consider = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);

		if (consider.getType() != Cell.Type.OUTFIELD) {
			if(consider.getTower() != null)return false;
			for (int i = -1; i <= 1; i += 2) {
				if (((x == this.getRow() + i) && (y == this.getCol()))||
					((x == this.getRow()) && (y == this.getCol() + i))){
					if (consider.getHero() == null)return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean canKillStraight(int x, int y) {
		Cell consider = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
		if (consider.getType() != Cell.Type.OUTFIELD && consider.getTower()!= null) {

			for (int i = -1; i <= 1; i += 2) {
				if (((x == this.getRow() + i) && (y == this.getCol()))||
					((x == this.getRow()) && (y == this.getCol() + i))){
					if (consider.getTower().getColor()!= this.getColor())return true;
				}
			}
		}
		if (consider.getType() != Cell.Type.OUTFIELD && consider.getHero()!= null) {

			for (int i = -1; i <= 1; i += 2) {
				if (((x == this.getRow() + i) && (y == this.getCol()))||
					((x == this.getRow()) && (y == this.getCol() + i))){
					if (consider.getHero().getColor()!= this.getColor())return true;
				}
			}
		}
		return false;
	}
	
}