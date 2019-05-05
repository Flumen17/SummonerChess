package field;

import java.util.ArrayList;
import java.util.List;

import constant.Numbers;
import field.cell.Cell;
import field.cell.FireCell;
import field.cell.LoveCell;
import field.cell.PlantCell;
import field.cell.WaterCell;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import sharedObject.RenderableHolder;

public class TurbineField extends Field {

	public TurbineField() {
		super();
	}

	@Override
	public void construct() {
		for(int i = 0; i < Numbers.ROWS; i++) {
			List<Cell> currentRow = new ArrayList<Cell>();
			for(int j = 0; j < Numbers.COLUMNS; j++) {
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
				if((j==0 || i>=8 || j>=9)||(i==0&&j>4)||(i==7&&j<5)||(j==1&&i<4)||(j==8&&i>3)) {
					cell.setType(Cell.Type.OUTFIELD);
					continue;
				}
				RenderableHolder.getInstance().add(cell);
			}
			field.add(currentRow);
		}
	}

	@Override
	public void setInitial() {
		for(int i = 0; i < Numbers.ROWS; i++) {
			for(int j = 0; j < Numbers.COLUMNS; j++) {
				if((j==0||i>=8 || j>=9)||(i==0&&j>4)||(i==7&&j<5)||(j==1&&i<4)||(j==8&&i>3)) {
					this.getCellAt(i, j).setType(Cell.Type.OUTFIELD);
				}
				else {
					this.getCellAt(i, j).setType(Cell.Type.NORMAL);
				}
			}
		}
	}
	
}
