package heroBase.superHero;

import Object.Tower;
import animation.HeroAnimation;
import constant.Images;
import field.cell.Cell;
import heroBase.FireBase;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.WaterBase;
import javafx.scene.paint.Color;
import main.Main;

public class SuperFire extends FireBase {

	public SuperFire(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.SUPERFIRE;
		if(color == Color.BLACK) {
			this.image = Images.superFire_BG;
			animationList = Images.blackSuperFire;
			
		}
		else {
			this.image = Images.superFire_WG;
			animationList = Images.whiteSuperFire;
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
		return canMoveDiagonal(x, y);
	}

	@Override
	public boolean canKill(int x, int y) {
		Tower tower = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower();
		Hero hero = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null && tower == null) {
			return false;
		}
		if(hero instanceof WaterBase) {
			return false;
		}
		if(this.getFlag() != null && hero.getFlag() != null) {
			return false;
		}
		return canKillDiagonal(x, y);
	}
	
	@Override
	public boolean canMoveDiagonal(int x, int y) {
		if((this.getRow() - x == this.getCol() - y) || (x - this.getRow() == this.getCol() - y)) {
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
			if((this.getRow() - x == this.getCol() - y) || (x - this.getRow() == this.getCol() - y)) {
				if(cell.getHero().getColor() != this.getColor()) {
					return true;
				}
			}
		}
		else if(cell.getTower() != null) {
			if((this.getRow() - x == this.getCol() - y) || (x - this.getRow() == this.getCol() - y)) {
				if(cell.getTower().getColor() != this.getColor()) {
					return true;
				}
			}
		}
		return false;
	}

}