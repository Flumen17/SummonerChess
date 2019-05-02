package heroBase;

import field.Cell;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import logic.Flag;
import logic.GameObject;
import main.Main;
import sharedObject.IRenderable;

public abstract class Hero extends GameObject {
	
	protected HeroType type; 
	
	private boolean alive;
	
	private Flag flag;
	
	
	public Hero(int x, int y, Color color) {
		alive = true;
		this.row = x;
		this.col = y;
		this.position = new Point2D(y * 100, x * 100);
		this.size = new Point2D(100, 100);
		this.color = color;
	}
	
	public void showMove(){
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 10; j++) {
				if(canMove(i, j))Main.gameScene.getGamePart().getLogicPane().getCellAt(i, j).setType(Cell.Type.MOVEABLE);
				if(canKill(i, j))Main.gameScene.getGamePart().getLogicPane().getCellAt(i, j).setType(Cell.Type.KILLABLE);
			}
		}
	}
	
	public abstract boolean canMove(int x,int y);
	
	public void move(int x, int y) {
		Main.gameScene.getGamePart().getLogicPane().getCellAt(row, col).setHero(null);
		Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).setHero(this);
		this.row = x;
		this.col = y;
		this.setPostion(y * 100, x * 100);
		if(flag != null) {
			Main.gameScene.getGamePart().getLogicPane().getCellAt(row, col).setFlag(null);
			Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).setFlag(this.flag);
			flag.setRow(x);
			flag.setCol(y);
			flag.setPostion(y * 100, x * 100);
		}
	};
	
	public abstract boolean canKill(int x, int y);
	
	public void kill(int x, int y) {
		if(Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower() != null) {
			Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower().attacked();
		}
		else {
			Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getHero().die();
			move(x, y);
		}
		
	}
	
	public void die() {
		Main.gameScene.getGamePart().getLogicPane().getCellAt(this.row, this.col).setHero(null);
		this.alive = false;
	}
	
	public HeroType getHeroType() {
		return type;
	}
	
	public boolean isDie() {
		return !alive;
	}
	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	public Flag getFlag() {
		return flag;
	}

	@Override
	public int getZ() {
		return 2;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public boolean isDestroyed() {
		return !alive;
	}
	
	
}
