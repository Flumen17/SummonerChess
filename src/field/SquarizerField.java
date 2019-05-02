package field;

import java.util.ArrayList;
import java.util.List;

import gui.Images;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import logic.GameHolder.GameTheme;
import sharedObject.RenderableHolder;

public class SquarizerField extends Field{
	
	public SquarizerField() {
		super();
	}

	@Override
	public void setInitial() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<10; j++) {
				if(i<=4&&(int)Math.abs((double)j-4.5)>(double)i)this.getCellAt(i, j).setType(Cell.Type.OUTFIELD);
				else if(i>4&&(int)Math.abs((double)j-4.4)>(8-i))this.getCellAt(i, j).setType(Cell.Type.OUTFIELD);
				else this.getCellAt(i, j).setType(Cell.Type.NORMAL);
			}
		}
	}

	@Override
	public void construct() {
		for(int i=0; i<9; i++) {
			List<Cell> currentRow = new ArrayList<Cell>();
			for(int j=0; j<10; j++) {
				Cell cell;
				switch(gameTheme) {
					case FIRE : cell = new FireCell(i, j, Cell.Type.NORMAL); break;
					case WATER : cell = new WaterCell(i, j, Cell.Type.NORMAL); break;
					case PLANT : cell = new PlantCell(i, j, Cell.Type.NORMAL); break;
					case LOVE : cell = new LoveCell(i, j, Cell.Type.NORMAL); break;
					default : cell = null;
				}
				setConstraints(cell, j, i, 1, 1, HPos.CENTER, VPos.CENTER);
				currentRow.add(cell);
				this.getChildren().add(cell);
				if(i<=4&&(int)Math.abs((double)j-4.5)>(double)i) {
					cell.setType(Cell.Type.OUTFIELD);
					continue;
				}
				else if(i>4&&(int)Math.abs((double)j-4.4)>(8-i)) {
					cell.setType(Cell.Type.OUTFIELD);
					continue;
				}
				
				RenderableHolder.getInstance().add(cell);
			}
			field.add(currentRow);
			
		}
	}
}
