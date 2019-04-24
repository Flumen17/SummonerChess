package logic;


import gui.ActionPart;
import gui.GamePart;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.Main;

public class GameRunner {
	private Field field;
	private GamePart gamePart;
	private ActionPart actionPart;
	private Cell selectedCell;
	private int currentRow, currentCol, turn;
	public GameRunner() {
		PlayerControl playerOne = new PlayerControl(4, 1, Color.BLACK);
		PlayerControl playerTwo = new PlayerControl(4, 7, Color.WHITE);
		field = Main.gameScreen.getGamePart().getLogicPane();
		field.getCellAt(4, 1).setHero(playerOne.getSummoner());
		field.getCellAt(4, 7).setHero(playerTwo.getSummoner());
		for(int i = 0; i < 9; i++) {
			currentRow = i;
			for(int j = 0; j < 9; j++) {
				currentCol = j;
				if(i<=3&&Math.abs(j-4)>i)continue;
				else if(i>3&&Math.abs(j-4)>(8-i))continue;
				field.getCellAt(i, j).setOnMouseClicked(e->{
					this.Click(this.field.getCellAt(this.currentRow, this.currentCol));
				});
			}
		}
		Main.gameScreen.getGamePart().getPaintPane().render();
	}
	
	public void start(){
		turn = 1;
	}
	
	public void setSelectedCell(Cell cell) {
		this.selectedCell = cell;
	}

	public Field getField() {
		return field;
	}

	public Cell getSelectedCell() {
		return selectedCell;
	}

	public int getCurrentRow() {
		return currentRow;
	}
	
	public int getCurrentCol() {
		return currentCol;
	}
	
	public void Click(Cell cell) {
		
	}
	
}
