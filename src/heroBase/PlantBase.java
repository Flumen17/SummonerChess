package heroBase;

import heroBase.property.SpreadMoveable;
import javafx.scene.paint.Color;

public abstract class PlantBase extends Hero implements SpreadMoveable {

	public PlantBase(int x, int y, Color color) {
		super(x, y, color);
	}

}
