package heroBase;

import heroBase.property.DiagonalMoveable;
import javafx.scene.paint.Color;

public abstract class FireBase extends Hero implements DiagonalMoveable{

	public FireBase(int x, int y, Color color) {
		super(x, y, color);
	}

}
