package heroBase;

import java.util.List;

import Object.Flag;
import Object.GameObject;
import animation.HeroAnimation;
import animation.MoveAnimation;
import constant.Numbers;
import constant.Sounds;
import field.cell.Cell;
import heroBase.hero.Summoner;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import main.Main;
import sharedObject.RenderableHolder;

public abstract class Hero extends GameObject {
	
	protected HeroType type; 
	private Flag flag;
	protected Image[] animationList;
	protected HeroAnimation heroAnimation;
	protected MoveAnimation moveAnimation;
	
	public Hero(int x, int y, Color color) {
		if(!(this instanceof Summoner))Sounds.summon.play();
		this.row = x;
		this.col = y;
		this.position = new Point2D(y * Numbers.CELL_SIZE, x * Numbers.CELL_SIZE);
		this.size = new Point2D(Numbers.CELL_SIZE, Numbers.CELL_SIZE);
		this.color = color;
		this.destroyed = false;
		Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).setHero(this);;
		RenderableHolder.getInstance().add(this);
	}
	
	public void showMove(){
		for(int i = 0; i < Numbers.ROWS; i++) {
			for(int j = 0; j < Numbers.COLUMNS; j++) {
				if(canMove(i, j))Main.gameScene.getGamePart().getLogicPane().getCellAt(i, j).setType(Cell.Type.MOVEABLE);
				if(canKill(i, j))Main.gameScene.getGamePart().getLogicPane().getCellAt(i, j).setType(Cell.Type.KILLABLE);
			}
		}
	}
	
	public abstract boolean canMove(int x,int y);
	
	public void move(int x, int y) {
		Sounds.move.play();
		Main.gameScene.getGamePart().getLogicPane().getCellAt(row, col).setHero(null);
		Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).setHero(this);
		moveAnimation = new MoveAnimation(position.getX() + Numbers.CELL_SIZE / 2, position.getY() + Numbers.CELL_SIZE / 2, Numbers.CELL_SIZE * ((double)y + 0.5), Numbers.CELL_SIZE * ((double)x + 0.5), this);
		if(this.flag != null) {
			Main.gameScene.getGamePart().getLogicPane().getCellAt(this.flag.getRow(), this.flag.getCol()).setFlag(null);
			Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).setFlag(this.flag);
			this.flag.move(x, y);
			this.flag.setRow(x);
			this.flag.setCol(y);
			this.flag.setPostion(y * Numbers.CELL_SIZE, x * Numbers.CELL_SIZE);
		}
		this.row = x;
		this.col = y;
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
		if(this.flag != null) {
			flag.unhold();
		}
		if(heroAnimation != null)this.heroAnimation.stop();
		this.destroyed = true;
	}
	
	public HeroType getHeroType() {
		return type;
	}
	
	public void setFlag(Flag flag) {
		if(flag != null) {
			this.opacity = 0.8;
		}
		else {
			this.opacity = 1.0;
		}
		this.flag = flag;
	}
	public Flag getFlag() {
		return flag;
	}

	public HeroAnimation getHeroAnimation() {
		return heroAnimation;
	}

	public MoveAnimation getMoveAnimation() {
		return moveAnimation;
	}
	@Override
	public int getZ() {
		return 1;
	}
	
}
