package Object;

import animation.MoveAnimation;
import constant.Images;
import constant.Numbers;
import heroBase.Hero;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import main.Main;
import sharedObject.RenderableHolder;

public class Flag extends GameObject {
	
	private Hero hero;
	private MoveAnimation moveAnimation;
	public Flag(int x, int y, Color color) {
		destroyed = false;
		this.row = x;
		this.col = y;
		this.position = new Point2D(y * Numbers.CELL_SIZE, x * Numbers.CELL_SIZE);
		this.size = new Point2D(Numbers.CELL_SIZE, Numbers.CELL_SIZE);
		this.color = color;
		if(color == Color.BLACK)this.image = Images.bFlag;
		else this.image = Images.wFlag;
		Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).setFlag(this);
		RenderableHolder.getInstance().add(this);
	}
	
	public void move(int x, int y) {
		moveAnimation = new MoveAnimation(position.getX() + Numbers.CELL_SIZE / 2, position.getY() + Numbers.CELL_SIZE / 2, Numbers.CELL_SIZE * ((double)y + 0.5), Numbers.CELL_SIZE * ((double)x + 0.5), this);
	}
	
	public void hold(Color color) {
		if(this.color == Color.BLACK) {
			if(color == Color.BLACK) {
				this.setImage(Images.bHoldBFlag);
			}
			else {
				this.setImage(Images.wHoldBFlag);
			}
		}
		else {
			if(color == Color.BLACK) {
				this.setImage(Images.bHoldWFlag);
			}
			else {
				this.setImage(Images.wHoldWFlag);
			}
		}
	}
	
	public void unhold() {
		if(color == Color.BLACK) {
			this.setImage(Images.bFlag);
		}
		else {
			this.setImage(Images.wFlag);
		}
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public Hero getHero() {
		return this.hero;
	}
	
	@Override
	public int getZ() {
		return 2;
	}

}
