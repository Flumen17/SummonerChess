package field.cell;

import constant.Images;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PlantCell extends Cell{

	public PlantCell(int x, int y, Type type) {
		super(x, y, type);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc);
		if(this.type == Type.NORMAL) {
			if((this.row + this.col)%2==1)gc.setFill(Color.rgb((int)(Color.DARKSEAGREEN.getRed()*255), (int)(Color.DARKSEAGREEN.getGreen()*255), (int)(Color.DARKSEAGREEN.getBlue()*255), 0.8));
			else gc.setFill(Color.rgb((int)(Color.FORESTGREEN.getRed()*255), (int)(Color.FORESTGREEN.getGreen()*255), (int)(Color.FORESTGREEN.getBlue()*255), 0.8));
		}
		else if(this.type == Type.OVER) {
			if((this.row + this.col)%2==1)gc.setFill(Color.DARKSEAGREEN);
			else gc.setFill(Color.FORESTGREEN);
		}
		gc.fillRect(position.getX(), position.getY(), size.getX(), size.getY());
		gc.setFill(Color.BLACK);
		gc.strokeRect(position.getX(), position.getY(), size.getX(), size.getY());
		if(this.target != null) {
			gc.setGlobalAlpha(0.5);
			if(this.target == Color.BLACK) {
				gc.drawImage(Images.bFlag, this.position.getX(), this.position.getY());
			}
			else {
				gc.drawImage(Images.wFlag, this.position.getX(), this.position.getY());
			}
			gc.setGlobalAlpha(1.0);
		}
	}
	
}
