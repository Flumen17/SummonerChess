package field.cell;

import constant.Images;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FireCell extends Cell{
	
	public FireCell(int x, int y, Type type) {
		super(x, y, type);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc);
		if(this.type == Type.NORMAL) {
			if((this.row + this.col)%2==1)gc.setFill(Color.rgb((int)(Color.INDIANRED.getRed()*255), (int)(Color.INDIANRED.getGreen()*255), (int)(Color.INDIANRED.getBlue()*255), 0.8));
			else gc.setFill(Color.rgb((int)(Color.DARKRED.getRed()*255), (int)(Color.DARKRED.getGreen()*255), (int)(Color.DARKRED.getBlue()*255), 0.8));
		}
		else if(this.type == Type.OVER) {
			if((this.row + this.col)%2==1)gc.setFill(Color.INDIANRED);
			else gc.setFill(Color.DARKRED);
		}
		gc.fillRect(position.getX(), position.getY(), size.getX(), size.getY());
		gc.setFill(Color.BLACK);
		gc.strokeRect(position.getX(), position.getY(), size.getX(), size.getY());
		if(this.target != null) {
			gc.setGlobalAlpha(0.5);
			if(this.target== Color.BLACK) {
				gc.drawImage(Images.bFlag, this.position.getX(), this.position.getY());
			}
			else {
				gc.drawImage(Images.wFlag, this.position.getX(), this.position.getY());
			}
			gc.setGlobalAlpha(1.0);
		}
	}
	
}
