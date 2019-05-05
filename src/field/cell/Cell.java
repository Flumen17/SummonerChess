package field.cell;

import Object.Flag;
import Object.Tower;
import constant.Numbers;
import constant.Sounds;
import exception.SelectedCellException;
import gui.AlertBox;
import heroBase.Hero;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import main.Main;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public abstract class Cell extends StackPane implements IRenderable{
	
	protected int row, col;
	protected Point2D position, size;
	protected Type type;
	protected Hero hero;
	protected Flag flag;
	protected Color target;
	protected Tower tower;
	
	public enum Type{
		NORMAL, MOVEABLE, KILLABLE, SELECTED, OVER, CHOOSEABLE, OUTFIELD;
	}
	
	public Cell(int x, int y, Type type) {
		super();
		this.setPrefSize(Numbers.CELL_SIZE, Numbers.CELL_SIZE);
		this.row = x;
		this.col = y;
		this.position = new Point2D(y * Numbers.CELL_SIZE, x * Numbers.CELL_SIZE);
		this.size = new Point2D(Numbers.CELL_SIZE, Numbers.CELL_SIZE);
		this.type = type;
		this.hero = null;
		this.flag = null;
		this.tower = null;
		this.target = null;
		this.setOnMouseEntered(e->{
			if(this.type == Type.NORMAL) {
				this.type = Type.OVER;
			}
		});
		this.setOnMouseExited(e->{
			if(this.type == Type.OVER) {
				this.type = Type.NORMAL;
			}
		});
		this.setOnMouseClicked(e->{
			if(this.type != Type.OUTFIELD) {
				try {
					if(e.getButton() == MouseButton.PRIMARY)Main.gameRunner.clickCell(this);
					else if(e.getButton() == MouseButton.SECONDARY)Main.gameRunner.holdingFlag(this);
					Sounds.select.play();
				} catch (SelectedCellException e1) {
					Sounds.invalidClick.play();
					AlertBox alertBox = new AlertBox(e1.getMessage());
					RenderableHolder.getInstance().add(alertBox);
				} 
			}
		});
	}
	
	@Override
	public int getZ() {
		return 0;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if(this.type == Type.SELECTED) {
			gc.setFill(Color.rgb((int)Color.DARKSLATEGRAY.getRed()*255, (int)Color.DARKSLATEGRAY.getGreen()*255, (int)Color.DARKSLATEGRAY.getBlue()*255, 0.8));
		}
		else if(this.type == Type.MOVEABLE) {
			gc.setFill(Color.rgb((int)(Color.LAWNGREEN.getRed()*255), (int)(Color.LAWNGREEN.getGreen()*255), (int)(Color.LAWNGREEN.getBlue()*255), 0.8));
		}
		else if(this.type == Type.KILLABLE) {
			gc.setFill(Color.rgb((int)(Color.RED.getRed()*255), (int)(Color.RED.getGreen()*255), (int)(Color.RED.getBlue()*255), 0.8));
		}
		else if(this.type == Type.CHOOSEABLE) {
			gc.setFill(Color.rgb((int)(Color.BLUEVIOLET.getRed()*255), (int)(Color.BLUEVIOLET.getGreen()*255), (int)(Color.BLUEVIOLET.getBlue()*255), 0.8));
		}
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
	
	public void setTarget(Color target) {
		this.target = target;
	}
	
	public Color getTarget() {
		return target;
	}
	
	public void setTower(Tower tower) {
		this.tower = tower;
	}
	
	public Tower getTower() {
		return tower;
	}

}
