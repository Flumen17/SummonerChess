package field;

import field.Cell.Type;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class WaterCell extends Cell {
	public WaterCell(int x, int y, Type type) {
		super(x, y, type);
	}

	@Override
	public void draw(GraphicsContext gc) {
		if(this.type == Type.NORMAL) {
			if((this.row + this.col)%2==1)gc.setFill(Color.rgb((int)(Color.LIGHTSKYBLUE.getRed()*255), (int)(Color.LIGHTSKYBLUE.getGreen()*255), (int)(Color.LIGHTSKYBLUE.getBlue()*255), 0.8));
			else gc.setFill(Color.rgb((int)(Color.DODGERBLUE.getRed()*255), (int)(Color.DODGERBLUE.getGreen()*255), (int)(Color.DODGERBLUE.getBlue()*255), 0.8));
			gc.fillRect(position.getX(), position.getY(), size.getX(), size.getY());
		}
		else if(this.type == Type.SELECTED) {
			gc.setFill(Color.rgb((int)Color.DARKSLATEGRAY.getRed(), (int)Color.DARKSLATEGRAY.getGreen(), (int)Color.DARKSLATEGRAY.getBlue(), 0.5));
			gc.fillRect(position.getX(), position.getY(), size.getX(), size.getY());
		}
		else if(this.type == Type.MOVEABLE) {
			gc.setFill(Color.rgb((int)(Color.LAWNGREEN.getRed()*255), (int)(Color.LAWNGREEN.getGreen()*255), (int)(Color.LAWNGREEN.getBlue()*255), 0.8));
			//gc.setGlobalAlpha(0.5);
			//gc.drawImage(image, position.getX(), position.getY(), size.getX(), size.getY());
			//gc.setGlobalAlpha(1.0);
			//gc.setFill(Color.LAWNGREEN);
			gc.fillRect(position.getX(), position.getY(), size.getX(), size.getY());
		}
		else if(this.type == Type.KILLABLE) {
			gc.setFill(Color.RED);
			gc.fillRect(position.getX(), position.getY(), size.getX(), size.getY());
		}
		gc.setFill(Color.BLACK);
		gc.strokeRect(position.getX(), position.getY(), size.getX(), size.getY());
	}
}
