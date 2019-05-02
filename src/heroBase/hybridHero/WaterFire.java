package heroBase.hybridHero;

import field.Cell;
import gui.Images;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.PlantBase;
import heroBase.WaterBase;
import heroBase.hero.Plant;
import heroBase.hero.Water;
import heroBase.property.DiagonalMoveable;
import heroBase.property.Sacrifice;
import javafx.scene.paint.Color;
import logic.Tower;
import main.Main;

public class WaterFire extends WaterBase implements DiagonalMoveable {

	public WaterFire(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.WATERFIRE;
		if(color == Color.BLACK)this.image = Images.waterFire_BG;
		else this.image = Images.waterFire_WG;
	}

	@Override
	public boolean canMove(int x, int y) {
		return canMoveStraight(x, y) || canMoveDiagonal(x,y);
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
		return canKillStraight(x, y) || canKillDiagonal(x, y);
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

			for (int i = 2; i <= 2; i++) {
				if (((x == this.getRow() + i) && (y == this.getCol()) && canMoveStraight(x-1, y))||
					((x == this.getRow() - i) && (y == this.getCol()) && canMoveStraight(x+1, y))||
					((x == this.getRow()) && (y == this.getCol() + i) && canMoveStraight(x, y-1))||
					((x == this.getRow()) && (y == this.getCol() - i) && canMoveStraight(x, y+1))) {
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

			for (int i = 2; i <= 2; i++) {
				if (((x == this.getRow() + i) && (y == this.getCol()) && canMoveStraight(x-1, y))||
					((x == this.getRow() - i) && (y == this.getCol()) && canMoveStraight(x+1, y))||
					((x == this.getRow()) && (y == this.getCol() + i) && canMoveStraight(x, y-1))||
					((x == this.getRow()) && (y == this.getCol() - i) && canMoveStraight(x, y+1))) {
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

			for (int i = 2; i <= 2; i++) {
				if (((x == this.getRow() + i) && (y == this.getCol()) && canMoveStraight(x-1, y))||
					((x == this.getRow() - i) && (y == this.getCol()) && canMoveStraight(x+1, y))||
					((x == this.getRow()) && (y == this.getCol() + i) && canMoveStraight(x, y-1))||
					((x == this.getRow()) && (y == this.getCol() - i) && canMoveStraight(x, y+1))) {
					if (consider.getHero().getColor()!= this.getColor())return true;
				}
			}
		}
		return false;
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

			for (int i = 2; i <= 2; i++) {
					if (((x == this.getRow() + i) && (y == this.getCol() + i) && canMoveDiagonal(x - 1, y - 1))||
						((x == this.getRow() + i) && (y == this.getCol() - i) && canMoveDiagonal(x - 1, y + 1))||
						((x == this.getRow() - i) && (y == this.getCol() + i) && canMoveDiagonal(x + 1, y - 1))||
						((x == this.getRow() - i) && (y == this.getCol() - i) && canMoveDiagonal(x + 1, y + 1))) {
						if (consider.getHero() == null) return true;
					}
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

			for (int i = 2; i <= 2; i++) {
				if (((x == this.getRow() + i) && (y == this.getCol() + i) && canMoveDiagonal(x - 1, y - 1))||
					((x == this.getRow() + i) && (y == this.getCol() - i) && canMoveDiagonal(x - 1, y + 1))||
					((x == this.getRow() - i) && (y == this.getCol() + i) && canMoveDiagonal(x + 1, y - 1))||
					((x == this.getRow() - i) && (y == this.getCol() - i) && canMoveDiagonal(x + 1, y + 1))){
						if (consider.getTower().getColor() != this.getColor())return true;
				}
			}
		}
		if (consider.getType() != Cell.Type.OUTFIELD && consider.getHero()!= null) {

			for (int i = -1; i <= 1; i += 2)
				for (int j = -1; j <= 1; j += 2)
					if ((x == this.getRow() + i) && (y == this.getCol() + j) 
							&& (consider.getHero().getColor()!= this.getColor())) {
							return true;
					}

			for (int i = 2; i <= 2; i++) {
				if (((x == this.getRow() + i) && (y == this.getCol() + i) && canMoveDiagonal(x - 1, y - 1))||
					((x == this.getRow() + i) && (y == this.getCol() - i) && canMoveDiagonal(x - 1, y + 1))||
					((x == this.getRow() - i) && (y == this.getCol() + i) && canMoveDiagonal(x + 1, y - 1))||
					((x == this.getRow() - i) && (y == this.getCol() - i) && canMoveDiagonal(x + 1, y + 1))){
						if (consider.getHero().getColor() != this.getColor())return true;
				}
			}
		}
		return false;
	}

}