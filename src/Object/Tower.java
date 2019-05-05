package Object;

import constant.Images;
import constant.Numbers;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Main;
import sharedObject.RenderableHolder;

public class Tower extends GameObject {
	
	private int life;
	
	public Tower(int x, int y, Color color) {
		destroyed = false;
		this.row = x;
		this.col = y;
		this.position = new Point2D(y * Numbers.CELL_SIZE, x * Numbers.CELL_SIZE);
		this.size = new Point2D(Numbers.CELL_SIZE, Numbers.CELL_SIZE);
		this.color = color;
		if(color == Color.BLACK)this.image = Images.bTower;
		else this.image = Images.wTower;
		this.life = Numbers.TOWER_LIFE;
		RenderableHolder.getInstance().add(this);
		Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).setTower(this);
	}
	
	public void attacked() {
		life--;
		if(life == 0)this.destroyed = true;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc);
		gc.setFill(color);
		gc.fillRoundRect(this.position.getX(), this.position.getY(), Numbers.CELL_SIZE, Numbers.BLOODBAR_HEIGHT, Numbers.ARC_SIZE, Numbers.ARC_SIZE);
		gc.setFill(Color.GOLD);
		gc.fillRoundRect(this.position.getX(), this.position.getY(), (double)(Numbers.CELL_SIZE) * 0.2 * life , Numbers.BLOODBAR_HEIGHT, Numbers.ARC_SIZE, Numbers.ARC_SIZE);
	}

	@Override
	public int getZ() {
		return 2;
	}
	
}
