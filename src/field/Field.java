package field;


import java.util.ArrayList;
import java.util.List;

import field.cell.Cell;
import javafx.scene.layout.GridPane;
import logic.GameHolder;
import main.Main;

public abstract class Field extends GridPane {
	
	protected List<List<Cell> > field;
	protected GameHolder.GameTheme gameTheme;
	
	public Field() {
		super();
		this.setPrefSize(1000, 900);
		field = new ArrayList<List<Cell> >();
		this.gameTheme = Main.gameHolder.getGameTheme();
		construct();
	}
	
	public abstract void construct();
	
	public abstract void setInitial();
	
	public Cell getCellAt(int x, int y){
		try { 
			return field.get(x).get(y); 
		}
		catch(IndexOutOfBoundsException e) {
			return null;
		}
		
	}
}
