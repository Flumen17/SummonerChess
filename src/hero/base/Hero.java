package hero.base;

import javafx.scene.paint.Color;

public abstract class Hero {
	
	protected int xPosition, yPosition;
	
	protected HeroType type; 
	
	protected Color color;
	
	public abstract void showMove();
	
	public abstract boolean canMove(int x,int y);
	
	public Hero(int x, int y, Color color) {
		this.xPosition = x;
		this.yPosition = y;
		this.color = color;
	}
	
	public void move(int x, int y) {
		if(canMove(x, y)) {
			
		}
	};
	
	public abstract boolean canKill(Hero hero);
	
	public void kill(Hero hero) {
		if(canKill(hero)) {
			hero.die();
		}
		
	}
	
	public void die() {
		
	}

	public int getxPosition() {
		return xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}
	
	public Color getColor() {
		return color;
	}
	
	
}
