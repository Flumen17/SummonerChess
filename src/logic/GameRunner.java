package logic;


import field.Cell;
import field.Field;
import field.FieldUI;
import gui.ActionPart;
import gui.HeroButton;
import gui.Images;
import gui.StatusButton;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.property.Sacrifice;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import logic.GameHolder.GameMode;
import main.Main;
import sharedObject.RenderableHolder;

public class GameRunner {
	private Field field;
	private ActionPart actionPart;
	private int turn;
	private PlayerControl playerOne, playerTwo, currentPlayer, anotherPlayer;
	private AnimationTimer animation;

	public GameRunner() {
		
		switch(Main.gameHolder.getGameField()) {
			case SQUARIZER : 
				playerOne = new PlayerControl(4, 1, Color.BLACK); playerTwo = new PlayerControl(4, 8, Color.WHITE); 
				if(Main.gameHolder.getGameMode() == GameHolder.GameMode.STEALTHEFLAG) {
					playerOne.setFlag(1, 4); playerTwo.setFlag(7, 5); 
				}
				else if(Main.gameHolder.getGameMode() == GameHolder.GameMode.TOWERDESTROY) {
					playerOne.setTower(1, 4); playerTwo.setTower(7, 5); 
				}
				break;
			case TURBINE : 
				playerOne = new PlayerControl(5, 2, Color.BLACK); playerTwo = new PlayerControl(2, 7, Color.WHITE);
				if(Main.gameHolder.getGameMode() == GameHolder.GameMode.STEALTHEFLAG) {
					playerOne.setFlag(6, 6); playerTwo.setFlag(1, 3); 
				}
				else if(Main.gameHolder.getGameMode() == GameHolder.GameMode.TOWERDESTROY) {
					playerOne.setTower(6, 6); playerTwo.setTower(1, 3); 
				}
				break;
			case FLORIST :
				playerOne = new PlayerControl(6, 2, Color.BLACK); playerTwo = new PlayerControl(1, 7, Color.WHITE);
				if(Main.gameHolder.getGameMode() == GameHolder.GameMode.STEALTHEFLAG) {
					playerOne.setFlag(1, 2); playerTwo.setFlag(6, 7); 
				}
				else if(Main.gameHolder.getGameMode() == GameHolder.GameMode.TOWERDESTROY) {
					playerOne.setTower(1, 2); playerTwo.setTower(6, 7); 
				}
				break;
		}
		turn = 1;
		currentPlayer = playerOne;
		anotherPlayer = playerTwo;
		field = Main.gameScene.getGamePart().getLogicPane();
		actionPart = Main.gameScene.getActionPart();
		actionPart.getStatusButton().setOnAction(e->{
			clickStatusButton();
		});
		animation = new AnimationTimer() {
			public void handle(long now) {
				if(Main.gameScene != null)Main.gameScene.getGamePart().getPaintPane().draw();
				RenderableHolder.getInstance().update();
			}
		};
		animation.start();
	}
	
	public Field getField() {
		return field;
	}
	
	public void clickCell(Cell cell) {
		if(actionPart.getStatusButton().getStatus() == StatusButton.Status.MOVE) {
			actionPart.unHilight();
			if(currentPlayer.getSelectedHeroToMove() == null) {
				field.setInitial();
				Hero hero = cell.getHero();
				if(hero == null) {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setHeaderText("Please Select Hero To Move");
					alert.showAndWait();
				}
				else if(hero.getColor() != currentPlayer.getColor()) {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setHeaderText("Please Select Valid Hero");
					alert.showAndWait();
				}
				else {
					currentPlayer.setSelectedHeroToMove(hero);
					cell.setType(Cell.Type.SELECTED);
					hero.showMove();
				}
			}
			else {
				Hero hero = currentPlayer.getSelectedHeroToMove();
				if(hero.equals(cell.getHero())) {
					field.setInitial();
					currentPlayer.setSelectedHeroToMove(null);
				}
				else if(hero.canMove(cell.getRow(), cell.getCol())) {
					hero.move(cell.getRow(), cell.getCol());
					endTurn();
				}
				else if(hero.canKill(cell.getRow(), cell.getCol())) {
					hero.kill(cell.getRow(), cell.getCol());
					endTurn();
				}
				else {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setHeaderText("Hero Cannot Move To This Cell");
					alert.showAndWait();
				}
			}
			
			
		}
		else if(actionPart.getStatusButton().getStatus() == StatusButton.Status.SUMMON){
			if(currentPlayer.getSelectedHeroToSummon() == null) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setHeaderText("Please Select Hero To Summon");
				alert.showAndWait();
			}
			else {
				Hero hero = cell.getHero();
				HeroType heroType = currentPlayer.getSelectedHeroToSummon();
				if(heroType == HeroType.FIRE || heroType == HeroType.WATER || heroType == HeroType.PLANT) {
					//System.out.println(String.format("%d %d", Math.abs(cell.getRow()-currentPlayer.getSummoner().getRow()), Math.abs(cell.getCol() - currentPlayer.getSummoner().getCol())));
					if(hero != null) {
						Alert alert = new Alert(Alert.AlertType.WARNING);
						alert.setHeaderText("Please Select Valid Cell");
						alert.showAndWait();
					}
					else if((Math.abs(cell.getRow() - currentPlayer.getSummoner().getRow()) == 1 && cell.getCol() == currentPlayer.getSummoner().getCol()) || 
					        (Math.abs(cell.getCol() - currentPlayer.getSummoner().getCol()) == 1 && cell.getRow() == currentPlayer.getSummoner().getRow())){
						currentPlayer.summonHero(cell.getRow(), cell.getCol());
						endTurn();
					}
					else {
						Alert alert = new Alert(Alert.AlertType.WARNING);
						alert.setHeaderText("Please Select Valid Cell");
						alert.showAndWait();
					}
				}
				else if(hero == null) {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setHeaderText("Please Select Sacrifice Hero");
					alert.showAndWait();
					
				}
				else if(hero.getColor() != currentPlayer.getColor()) {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setHeaderText("Please Select Valid Hero");
					alert.showAndWait();
				}
				else if(currentPlayer.getSelectedSacrifice() == null) {
					field.setInitial();
					if(hero instanceof Sacrifice) {
						if(heroType == HeroType.LOVE) {
							hero.die();
							currentPlayer.summonHero(cell.getRow(), cell.getCol());
							endTurn();
						}
						else if(((Sacrifice)hero).canBeSacrifice(heroType)) {
							currentPlayer.setSelectedSacrifice(hero);
							cell.setType(Cell.Type.SELECTED);
						}
						else {
							Alert alert = new Alert(Alert.AlertType.WARNING);
							alert.setHeaderText("This Hero Cannot Be Sacrifice");
							alert.showAndWait();
						}
					}
					else {
						Alert alert = new Alert(Alert.AlertType.WARNING);
						alert.setHeaderText("This Hero Cannot Be Sacrifice");
						alert.showAndWait();
					}	
				}
				else if(hero.equals(currentPlayer.getSelectedSacrifice())) {
					field.setInitial();
					currentPlayer.setSelectedSacrifice(null);
				}
				else {
					Hero sacrificeHero = currentPlayer.getSelectedSacrifice();
					if(hero instanceof Sacrifice) {
						if(((Sacrifice)hero).canBeSacrifice(heroType, sacrificeHero.getHeroType())) {
							hero.die();
							sacrificeHero.die();
							currentPlayer.summonHero(cell.getRow(),cell.getCol());
							endTurn();
						}
						else {
							Alert alert = new Alert(Alert.AlertType.WARNING);
							alert.setHeaderText("This Hero Cannot Be Sacrifice");
							alert.showAndWait();
						}
					}
					else {
						Alert alert = new Alert(Alert.AlertType.WARNING);
						alert.setHeaderText("This Hero Cannot Be Sacrifice");
						alert.showAndWait();
					}	
				}
			}
		}
	}
	
	public void clickHeroButton(HeroButton heroButton) {
		if(actionPart.getStatusButton().getStatus() != StatusButton.Status.SUMMONGOD) {
		actionPart.unHilight();
		field.setInitial();
		currentPlayer.setInitial();
		if(!heroButton.isActive()) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText("This Hero Cannot Summon");
			alert.showAndWait();
		}
		else {
			actionPart.getStatusButton().setStatus(StatusButton.Status.SUMMON);
			HeroType heroType = heroButton.getHeroType();
			heroButton.hilight();
			currentPlayer.setSelectedHeroToSummon(heroType);
		}
		}
	}
	
	public void clickStatusButton() {
		actionPart.unHilight();
		field.setInitial();
		currentPlayer.setInitial();
		if(actionPart.getStatusButton().getStatus() == StatusButton.Status.MOVE) {
			actionPart.getStatusButton().setStatus(StatusButton.Status.SUMMON);
		}
		else if(actionPart.getStatusButton().getStatus() == StatusButton.Status.SUMMON){
			actionPart.getStatusButton().setStatus(StatusButton.Status.MOVE);
		}
		else {
			endGame(turn%2);
		}
	}
	
	public void startTurn() {
		actionPart.unHilight();
		field.setInitial();
		currentPlayer.setInitial();
		actionPart.getStatusButton().setStatus(StatusButton.Status.MOVE);
		if(currentPlayer.getColor() == Color.BLACK)actionPart.switchTurn(Color.BLACK);
		else actionPart.switchTurn(Color.WHITE);
		for(int k = 0; k < actionPart.getHeroButtonList().size(); k++) {
			HeroButton heroButton = actionPart.getHeroButtonList().get(k);
			HeroType heroType = heroButton.getHeroType();
			boolean check = false;
			if(heroType == HeroType.FIRE || heroType == HeroType.WATER || heroType == HeroType.PLANT ) {
				for(int i = -1; i <= 1; i++) {
					for(int j = -1; j <= 1; j++) {
						if(i != 0 && j != 0)continue;
						if(i == 0 && j == 0)continue;
						if(field.getCellAt(currentPlayer.getSummoner().getRow() + i, currentPlayer.getSummoner().getCol() + j).getHero() == null) {
							check = true;
						}
					}
				}
			}
			for(int i = 0; i < currentPlayer.getHeroes().size(); i++) {
				if(currentPlayer.getHeroes().get(i).isDestroyed())continue;
				if(check)break;
				for(int j = 0; j < i; j++) {
					if(currentPlayer.getHeroes().get(j).isDestroyed())continue;
					if(currentPlayer.getHeroes().get(i) instanceof Sacrifice) {
						if(heroType == HeroType.LOVE) {
							check = true;
							break;
						}
						if(((Sacrifice)(currentPlayer.getHeroes().get(i))).canBeSacrifice(heroType, currentPlayer.getHeroes().get(j).getHeroType())){
							check = true;
							break;
						}
					}
				}
			}
			heroButton.setActive(check);			
		}
		if(Main.gameHolder.getGameMode() == GameHolder.GameMode.SUMMONTHEGOD) {
		int f = 0, w = 0, p = 0, l =0;
		for(int i = 0; i < currentPlayer.getHeroes().size(); i++) {
			if(currentPlayer.getHeroes().get(i).isDestroyed())continue;
			HeroType heroType =currentPlayer.getHeroes().get(i).getHeroType();
			switch(heroType) {
				case FIRE : f++; break;
				case WATER : w++; break;
				case PLANT : p++; break;
				case SUPERFIRE : f+=2; break;
				case SUPERWATER : w+=2; break;
				case SUPERPLANT : p+=2; break;
				case FIREPLANT : f++; p++; break;
				case WATERFIRE : w++; f++; break;
				case PLANTWATER : p++; w++; break;
				case LOVE : l++; break;
				default :
			}
		}
		if(f>=2&&w>=2&&p>=2&&l>=1) {
			actionPart.getStatusButton().setStatus(StatusButton.Status.SUMMONGOD);
			if(turn%2 ==1)actionPart.getStatusButton().setGraphic(new ImageView(Images.summonBGodButton));
			else actionPart.getStatusButton().setGraphic(new ImageView(Images.summonWGodButton));
		}
		}
	}
	
	public void endTurn() {
		actionPart.unHilight();
		field.setInitial();
		currentPlayer.setInitial();
		actionPart.getStatusButton().setStatus(StatusButton.Status.MOVE);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 10; j++){
				if(field.getCellAt(i, j).getFlag() != null) {
					if(field.getCellAt(i,j).getHero()!=null) {
						field.getCellAt(i, j).getHero().setFlag(field.getCellAt(i, j).getFlag());
						if(i==playerOne.getX() && j==playerOne.getY()) {
							if(field.getCellAt(i, j).getHero().getColor() == Color.BLACK) {
								field.getCellAt(i, j).getHero().setFlag(null);
							}
						}
						else if(i==playerTwo.getX() && j==playerTwo.getY()) {
							if(field.getCellAt(i, j).getHero().getColor() == Color.WHITE) {
								field.getCellAt(i, j).getHero().setFlag(null);
							}
						}
					}
				}
			}
		}
		if(anotherPlayer.getSummoner().isDie()) {
			endGame(turn%2);
		}
		if(Main.gameHolder.getGameMode() == GameMode.STEALTHEFLAG ) {
			if(playerOne.getFlag().getRow() == playerTwo.getX() && playerOne.getFlag().getCol() == playerTwo.getY()) {
				endGame(0);
			}
			else if(playerTwo.getFlag().getRow() == playerOne.getX() && playerTwo.getFlag().getCol() == playerOne.getY()) {
				endGame(1);
			}
		}
		else if(Main.gameHolder.getGameMode() == GameMode.TOWERDESTROY) {
			if(anotherPlayer.getTower().isDestroyed()) {
				endGame(turn%2);
			}
		}
		else {
			if(actionPart.getStatusButton().getStatus() == StatusButton.Status.SUMMONGOD) {
				endGame(turn%2);
			}
		}
		turn++;
		if(turn%2 == 1) {
			currentPlayer = playerOne;
			anotherPlayer = playerTwo;
		}
		else {
			currentPlayer = playerTwo;
			anotherPlayer = playerOne;
		}
		startTurn();
	}
	
	public void endGame(int w) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if(w == 1)alert.setHeaderText("Player one Win");
		else alert.setHeaderText("Player two Win");
		alert.showAndWait();			
		Main.sceneHolder.switchScene(Main.homeScene);
		Main.gameRunner.animation.stop();
		System.out.println("Stop animation");
		Main.gameScene = null;
		System.out.println("gameScene null");
		Main.gameRunner = null;
		RenderableHolder.getInstance().getGameObjects().clear();
	}
	
}
