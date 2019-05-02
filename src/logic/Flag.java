package logic;

import gui.Images;
import heroBase.Hero;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;

public class Flag extends GameObject {
	private boolean destroyed;
	private Hero hero;
	public Flag(int x, int y, Color color) {
		destroyed = false;
		this.row = x;
		this.col = y;
		this.position = new Point2D(y * 100, x * 100);
		this.size = new Point2D(100, 100);
		this.color = color;
		if(color == Color.BLACK)this.image = Images.bFlag;
		else this.image = Images.wFlag;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	public Hero getHero() {
		return this.hero;
	}
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
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
