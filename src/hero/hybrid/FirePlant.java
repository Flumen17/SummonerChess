package hero.hybrid;

import hero.Fire;
import hero.Water;
import hero.base.Hero;
import javafx.scene.paint.Color;
import movement.SpreadMoveable;

public class FirePlant extends Fire implements SpreadMoveable {

	
	public FirePlant(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void showMove() {
		super.showMove();
		showSpreadMove();
	}

	@Override
	public boolean canMove(int x, int y) {
		return super.canMove(x, y) || canMoveSpread(x,y);
	}

	@Override
	public boolean canKill(Hero hero) {
		if(hero instanceof Water) {
			return false;
		}
		return true;
	}

	@Override
	public void showSpreadMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canMoveSpread(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
