package field;

import java.util.ArrayList;
import java.util.List;

import constant.Numbers;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class FieldUI extends Canvas {
	
	private GraphicsContext gc;
	private List<IRenderable> destroyedObjects;
	public FieldUI() {	
		this.gc = this.getGraphicsContext2D();
		this.destroyedObjects = new ArrayList<IRenderable>();
		this.setHeight(Numbers.FIELD_HEIGHT);
		this.setWidth(Numbers.FIELD_WIDTH);
	}
	
	public void draw() {
		gc.clearRect(0, 0, Numbers.FIELD_WIDTH, Numbers.FIELD_HEIGHT);
		for(IRenderable instance : RenderableHolder.getInstance().getGameObjects()){
			if(!instance.isDestroyed()) {
				instance.draw(gc);
			}
			else {
				destroyedObjects.add(instance);
			}
		}
		for(int i = 0; i < destroyedObjects.size(); i++) {
			RenderableHolder.getInstance().getGameObjects().remove(destroyedObjects.get(i));
		}
		destroyedObjects.clear();
	}
	
}
