package heroBase.superHero;

import field.Cell;
import gui.Images;
import heroBase.FireBase;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.WaterBase;
import heroBase.hero.Fire;
import heroBase.hero.Water;
import javafx.scene.paint.Color;
import logic.Tower;
import main.Main;

public class SuperFire extends FireBase {

	public SuperFire(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.SUPERFIRE;
		if(color == Color.BLACK)this.image = Images.superFire_BG;
		else this.image = Images.superFire_WG;
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
		return canKillDiagonal(x, y);
	}
	
	@Override
	public boolean canMove(int x, int y) {
		return canMoveDiagonal(x, y);
	}

	@Override
	public boolean canMoveDiagonal(int x, int y) {
		Cell consider = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);

		if (consider.getType() != Cell.Type.OUTFIELD) {
			if(consider.getTower() != null)return false;
			if((this.getRow()-x==this.getCol()-y)||(x-this.getRow()==this.getCol()-y))
				if (consider.getHero() == null) return true;
		}
		return false;
	}

	@Override
	public boolean canKillDiagonal(int x, int y) {
		Cell consider = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);

		 if (consider.getType() != Cell.Type.OUTFIELD ) {
			if((this.getRow()-x==this.getCol()-y)||(x-this.getRow()==this.getCol()-y))
				if (consider.getHero()!= null && consider.getHero().getColor() != this.getColor())return true;	
				if(consider.getTower() != null && consider.getTower().getColor() != this.getColor())return true;
		 }
		return false;
	}

}