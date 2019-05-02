package logic;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;

public abstract class GameObject implements IRenderable {
	protected int row, col;
	protected Point2D position, size;
	protected Image image;
	protected Color color;
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(image, position.getX(), position.getY(), size.getX(), size.getY());
	}
	
	public void setRow(int x) {
		this.row = x;
	}
	public int getRow() {
		return row;
	}
	public void setCol(int y) {
		this.col = y;
	}

	public int getCol() {
		return col;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setPostion(double x, double y) {
		position = new Point2D(x, y);
	}
	
	public Point2D getPosition() {
		return position;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}
}
