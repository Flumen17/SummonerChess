package heroBase.hybridHero;

import field.Cell;
import gui.Images;
import heroBase.FireBase;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.PlantBase;
import heroBase.hero.Fire;
import heroBase.hero.Plant;
import heroBase.property.Sacrifice;
import heroBase.property.StraightMoveable;
import javafx.scene.paint.Color;
import logic.Tower;
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
		Cell consider = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);

		if (consider.getType() != Cell.Type.OUTFIELD) {
			if(consider.getTower() != null)return false;
			for (int i = -1; i <= 1; i += 2)
				for (int j = -2; j <= 2 ; j += 4) {
						if (((x == this.getRow() + j) && (y == this.getCol() + i) )||
							((x == this.getRow() + i) && (y == this.getCol() + j) )) {
							if (consider.getHero() == null) return true;
						}
				}
		}
		return false;
	}

	@Override
	public boolean canKillSpread(int x, int y) {
		Cell consider = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);

		if (consider.getType() != Cell.Type.OUTFIELD) {

			for (int i = -1; i <= 1; i += 2)
				for (int j = -2; j <= 2 ; j += 4) {
						if (((x == this.getRow() + j) && (y == this.getCol() + i) )||
							((x == this.getRow() + i) && (y == this.getCol() + j) )) {
							if (consider.getHero().getColor()!= this.getColor()) return true;
							if(consider.getTower() != null && consider.getTower().getColor() != this.getColor())return true;
						}
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

}