package logic;

import gui.Images;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Tower extends GameObject {
	private boolean destroyed;
	private int life;
	public Tower(int x, int y, Color color) {
		destroyed = false;
		this.row = x;
		this.col = y;
		this.position = new Point2D(y * 100, x * 100);
		this.size = new Point2D(100, 100);
		this.color = color;
		if(color == Color.BLACK)this.image = Images.bTower;
		else this.image = Images.wTower;
		this.life = 5;
	}
	public void attacked() {
		life--;
		if(life == 0)this.destroyed = true;
	}
	@Override
	public int getZ() {
		return 1;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

}
