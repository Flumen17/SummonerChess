package field;

import gui.Images;
import heroBase.Hero;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import logic.Flag;
import logic.Tower;
import main.Main;
import sharedObject.IRenderable;

public abstract class Cell extends StackPane implements IRenderable{
	
	protected Hero hero;
	protected int row, col;
	protected Type type;
	protected Point2D position, size;
	protected Flag flag;
	protected Tower tower;
	
	public enum Type{
		NORMAL, MOVEABLE, KILLABLE, SELECTED, OUTFIELD;
	}
	
	public Cell(int x, int y, Type type) {
		super();
		this.setPrefSize(100, 100);
		this.row = x;
		this.col = y;
		this.position = new Point2D(y * 100, x * 100);
		this.size = new Point2D(100, 100);
		this.type = type;
		this.hero = null;
		this.flag = null;
		this.tower = null;
		this.setOnMouseMoved(e->{
			//this.setVisible(false);
			//this.color = Color.DIMGRAY;
			//Main.gameScreen.getGamePart().getPaintPane().render();
		});
		this.setOnMouseExited(e->{
			//this.setVisible(true);
			//this.color = this.realColor;
			//Main.gameScreen.getGamePart().getPaintPane().render();
		});
		this.setOnMouseClicked(e->{
			if(this.type != Type.OUTFIELD) {
				Main.gameRunner.clickCell(this);
			}
		});
		
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	
	public Flag getFlag() {
		return flag;
	}
	public void setTower(Tower tower) {
		this.tower = tower;
	}
	
	public Tower getTower() {
		return tower;
	}
	
	public int  getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public int getZ() {
		return 0;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}
		
	public void setPostion(double x, double y) {
		position = new Point2D(x, y);
	}
	
	public Point2D getPosition() {
		return position;
	}
}
