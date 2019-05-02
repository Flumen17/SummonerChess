package heroBase.hero;

import field.Cell;
import gui.Images;
import heroBase.FireBase;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.WaterBase;
import heroBase.hybridHero.FirePlant;
import heroBase.property.DiagonalMoveable;
import heroBase.property.Sacrifice;
import heroBase.superHero.SuperFire;
import javafx.scene.paint.Color;
import logic.Tower;
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
		return canMoveDiagonal(x, y);
	}
	
	@Override
	public boolean canKill(int x, int y) {
		Tower tower = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower();
		Hero hero = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null && tower == null) {
			return false;
		}
		if(hero instanceof WaterBase || hero instanceof SuperFire || hero instanceof FirePlant) {
			return false;
		}
		return canKillDiagonal(x, y);
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
		if(consider.getType() != Cell.Type.OUTFIELD && consider.getTower() != null) {
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