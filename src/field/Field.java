package field;


import java.util.ArrayList;
import java.util.List;

import field.Cell.Type;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import logic.GameHolder;
import main.Main;
import sharedObject.RenderableHolder;

public abstract class Field extends GridPane {
	
	protected List<List<Cell> > field;
	protected GameHolder.GameTheme gameTheme;
	
	public Field() {
		super();
		this.setPrefSize(1000, 900);
		field = new ArrayList<List<Cell> >();
		this.gameTheme = Main.gameHolder.getGameTheme();
		construct();
		//this.setStyle("-fx-border-width: 1px;");
		//this.setStyle("-fx-border-color: blue;");
		//this.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		//this.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public abstract void construct();
	
	public abstract void setInitial();
	
	public Cell getCellAt(int x, int y) {
		return field.get(x).get(y); 
	}
}
