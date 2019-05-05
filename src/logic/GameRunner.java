package logic;


import java.util.ArrayList;
import java.util.List;

import Object.GodHero;
import constant.Images;
import constant.Sounds;
import exception.SelectedCellException;
import exception.SelectedHeroToSummonException;
import field.Field;
import field.cell.Cell;
import gui.ActionPart;
import gui.HeroButton;
import gui.StatusButton;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.property.Sacrifice;
import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import logic.GameHolder.GameMode;
import main.Main;
import sharedObject.RenderableHolder;

public class GameRunner {
	private Field field;
	private ActionPart actionPart;
	private int turn;
	private PlayerController playerOne, playerTwo, currentPlayer, anotherPlayer;
	private AnimationTimer animation;
	private boolean end;

	public GameRunner() {
		field = Main.gameScene.getGamePart().getLogicPane();
		end = false;
		switch(Main.gameHolder.getGameField()) {
			case SQUARIZER : 
				playerOne = new PlayerController(4, 1, Color.BLACK); playerTwo = new PlayerController(4, 8, Color.WHITE); 
				if(Main.gameHolder.getGameMode() == GameHolder.GameMode.STEALTHEFLAG) {
					playerOne.setFlag(1, 4); playerTwo.setFlag(7, 5); 
					field.getCellAt(4, 0).setTarget(Color.BLACK);
					field.getCellAt(4, 9).setTarget(Color.WHITE);
				}
				else if(Main.gameHolder.getGameMode() == GameHolder.GameMode.TOWERDESTROY) {
					playerOne.setTower(1, 4); playerTwo.setTower(7, 5); 
				}
				break;
			case TURBINE : 
				playerOne = new PlayerController(5, 2, Color.BLACK); playerTwo = new PlayerController(2, 7, Color.WHITE);
				if(Main.gameHolder.getGameMode() == GameHolder.GameMode.STEALTHEFLAG) {
					playerOne.setFlag(6, 6); playerTwo.setFlag(1, 3);
					field.getCellAt(6, 1).setTarget(Color.BLACK);
					field.getCellAt(1, 8).setTarget(Color.WHITE);
				}
				else if(Main.gameHolder.getGameMode() == GameHolder.GameMode.TOWERDESTROY) {
					playerOne.setTower(6, 6); playerTwo.setTower(1, 3); 
				}
				break;
			case FLORIST :
				playerOne = new PlayerController(6, 2, Color.BLACK); playerTwo = new PlayerController(1, 7, Color.WHITE);
				if(Main.gameHolder.getGameMode() == GameHolder.GameMode.STEALTHEFLAG) {
					playerOne.setFlag(1, 2); playerTwo.setFlag(6, 7); 
					field.getCellAt(6, 1).setTarget(Color.BLACK);
					field.getCellAt(1, 8).setTarget(Color.WHITE);
				}
				else if(Main.gameHolder.getGameMode() == GameHolder.GameMode.TOWERDESTROY) {
					playerOne.setTower(1, 2); playerTwo.setTower(6, 7); 
				}
				break;
		}
		turn = 1;
		currentPlayer = playerOne;
		anotherPlayer = playerTwo;
		
		actionPart = Main.gameScene.getActionPart();
		actionPart.getStatusButton().setOnAction(e->{
			Sounds.heroButtonClick.play();
			clickStatusButton();
		});
		animation = new AnimationTimer() {
			public void handle(long now) {
				if(Main.gameScene != null)Main.gameScene.getGamePart().getPaintPane().draw();
			}
		};
		animation.start();
	}
	
	
	
	public void clickCell(Cell cell) throws SelectedCellException {
		if(actionPart.getStatusButton().getStatus() == StatusButton.Status.MOVE) {
			actionPart.unHilight();
			if(currentPlayer.getSelectedHeroToMove() == null) {
				field.setInitial();
				Hero hero = cell.getHero();
				if(hero == null) {
					throw new SelectedCellException("PLEASE SELECT HERO TO MOVE");
				}
				else if(hero.getColor() != currentPlayer.getColor()) {
					throw new SelectedCellException("PLEASE SELECT VALID HERO");
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
				else if(cell.getHero() != null && cell.getHero().getColor() == currentPlayer.getColor()) {
					field.setInitial();
					currentPlayer.setSelectedHeroToMove(cell.getHero());
					cell.setType(Cell.Type.SELECTED);
					cell.getHero().showMove();
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
					if(cell.getFlag() != null && cell.getHero() == null && cell.getTower() == null) {
						throw new SelectedCellException("HERO CANNOT MOVE TO CELL THAT HAVE ANOTHER FLAG");
					}
					throw new SelectedCellException("HERO CANNOT MOVE TO THIS CELL");
				}
			}
			
			
		}
		else if(actionPart.getStatusButton().getStatus() == StatusButton.Status.SUMMON){
			if(currentPlayer.getSelectedHeroToSummon() == null) {
				throw new SelectedCellException("PLEASE SELECT HERO TO SUMMON");
			}
			else {
				Hero hero = cell.getHero();
				HeroType heroType = currentPlayer.getSelectedHeroToSummon();
				if(heroType == HeroType.FIRE || heroType == HeroType.WATER || heroType == HeroType.PLANT) {
					if(hero != null) {
						throw new SelectedCellException("PLEASE SELECT VALID CELL");
					}
					else if((Math.abs(cell.getRow() - currentPlayer.getSummoner().getRow()) == 1 && cell.getCol() == currentPlayer.getSummoner().getCol()) || 
					        (Math.abs(cell.getCol() - currentPlayer.getSummoner().getCol()) == 1 && cell.getRow() == currentPlayer.getSummoner().getRow())){
						currentPlayer.summonHero(cell.getRow(), cell.getCol());
						endTurn();
					}
					else {
						throw new SelectedCellException("PLEASE SELECT VALID CELL");
					}
				}
				else if(hero == null) {
					throw new SelectedCellException("PLEASE SELECT SACRIFICE HERO");
				}
				else if(hero.getColor() != currentPlayer.getColor()) {
					throw new SelectedCellException("PLEASE SELECT VALID HERO");
				}
				else if(currentPlayer.getSelectedSacrifice() == null) {
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
							throw new SelectedCellException("THIS HERO CANNOT BE SACRIFICE");
						}
					}
					else {
						throw new SelectedCellException("THIS HERO CANNOT BE SACRIFICE");
					}	
				}
				else if(hero.equals(currentPlayer.getSelectedSacrifice())) {
					cell.setType(Cell.Type.CHOOSEABLE);
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
							throw new SelectedCellException("THIS HERO CANNOT BE SACRIFICE");
						}
					}
					else {
						throw new SelectedCellException("THIS HERO CANNOT BE SACRIFICE");
					}	
				}
			}
		}
	}
	
	public void clickHeroButton(HeroButton heroButton) throws SelectedHeroToSummonException {
		if(actionPart.getStatusButton().getStatus() != StatusButton.Status.SUMMONGOD) {
			actionPart.unHilight();
			field.setInitial();
			currentPlayer.setInitial();
			if(!heroButton.isActive()) {
				throw new SelectedHeroToSummonException("THIS HERO CANNOT SUMMON");
			}
			actionPart.getStatusButton().setStatus(StatusButton.Status.SUMMON);
			HeroType heroType = heroButton.getHeroType();
			heroButton.hilight();
			currentPlayer.setSelectedHeroToSummon(heroType);
			if(heroType == HeroType.FIRE || heroType == HeroType.WATER || heroType == HeroType.PLANT) {
				for(int i = -1; i <= 1; i++) {
					for(int j = -1; j <= 1; j++) {
						if(i!=0 && j!=0)continue;
						Cell cell = field.getCellAt(currentPlayer.getSummoner().getRow() + i, currentPlayer.getSummoner().getCol() + j);
						if(cell != null && cell.getType() != Cell.Type.OUTFIELD && cell.getHero()==null) {
							cell.setType(Cell.Type.CHOOSEABLE);
						}
					}	
				}
			}
			for(int i = 0; i < currentPlayer.getHeroes().size(); i++) {
				Hero hero = currentPlayer.getHeroes().get(i);
				if(hero instanceof Sacrifice) {
					if(heroType == HeroType.LOVE || ((Sacrifice) hero).canBeSacrifice(heroType)) {
						field.getCellAt(hero.getRow(), hero.getCol()).setType(Cell.Type.CHOOSEABLE);
					}
				}
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
			if(!end) {
				end = true;
				endTurn();
			}
		}
	}
	
	public void holdingFlag(Cell cell) throws SelectedCellException {
		if(cell.getHero() != null) {
			Hero hero = cell.getHero();
			if(currentPlayer.getColor() == hero.getColor()) {
				if(hero.getFlag() != null) {
					hero.getFlag().unhold();
					hero.setFlag(null);
				}
				else if(cell.getFlag() != null) {
					hero.setFlag(cell.getFlag());
					cell.getFlag().hold(currentPlayer.getColor()); 
				}
			}
		}
	}
	
	public void startTurn() {
		actionPart.unHilight();
		field.setInitial();
		currentPlayer.setInitial();
		actionPart.getStatusButton().setStatus(StatusButton.Status.MOVE);
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
		for(int k = 0; k < actionPart.getHeroButtonList().size(); k++) {
			HeroButton heroButton = actionPart.getHeroButtonList().get(k);
			HeroType heroType = heroButton.getHeroType();
			if(actionPart.getStatusButton().getStatus() == StatusButton.Status.SUMMONGOD) {
				heroButton.setActive(false);
				continue;
			}
			boolean check = false;
			if(heroType == HeroType.FIRE || heroType == HeroType.WATER || heroType == HeroType.PLANT ) {
				for(int i = -1; i <= 1; i++) {
					for(int j = -1; j <= 1; j++) {
						if(i != 0 && j != 0)continue;
						if(i == 0 && j == 0)continue;
						if(field.getCellAt(currentPlayer.getSummoner().getRow() + i, currentPlayer.getSummoner().getCol() + j) == null)continue;
						if(field.getCellAt(currentPlayer.getSummoner().getRow() + i, currentPlayer.getSummoner().getCol() + j).getHero() == null) {
							check = true;
						}
					}
				}
			}
			for(int i = 0; i < currentPlayer.getHeroes().size(); i++) {
				if(check)break;
				for(int j = 0; j < i; j++) {
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
		if(currentPlayer.getColor() == Color.BLACK) {
			actionPart.switchTurn(Color.BLACK);
		}
		else {
			actionPart.switchTurn(Color.WHITE);
		}
		
	}
	
	public void endTurn() {
		actionPart.unHilight();
		field.setInitial();
		currentPlayer.setInitial();
		if(anotherPlayer.getSummoner().isDestroyed()) {
			endGame(turn%2);
		}
		if(Main.gameHolder.getGameMode() == GameMode.STEALTHEFLAG ) {
			int x1 = playerOne.getFlag().getRow(), y1 = playerOne.getFlag().getCol();
			int x2 = playerTwo.getFlag().getRow(), y2 = playerTwo.getFlag().getCol();
			if(field.getCellAt(x1, y1).getTarget() != null && field.getCellAt(x1, y1).getTarget() == Color.WHITE) {
				endGame(0);
			}
			else if(field.getCellAt(x2, y2).getTarget() != null && field.getCellAt(x2, y2).getTarget() == Color.BLACK) {
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
				GodHero god;
				if(turn % 2 == 1) {
					god = new GodHero(Color.BLACK, anotherPlayer.getHeroes());
				}
				else {
					god = new GodHero(Color.WHITE, anotherPlayer.getHeroes());	
				}
				int t = turn%2;
				RenderableHolder.getInstance().add(god);
				god.getTimeline().setOnFinished(e->{
					this.endGame(t);
				});
			}
		}
		actionPart.getStatusButton().setStatus(StatusButton.Status.MOVE);
		List<Hero> destroyedHeroes = new ArrayList<Hero>();
		for(int i = 0; i < playerOne.getHeroes().size(); i++) {
			Hero hero = playerOne.getHeroes().get(i);
			if(hero.isDestroyed()) {
				destroyedHeroes.add(hero);
			}
		}
		for(int i = 0; i < destroyedHeroes.size(); i++) {
			playerOne.getHeroes().remove(destroyedHeroes.get(i));
		}
		destroyedHeroes.clear();
		for(int i = 0; i < playerTwo.getHeroes().size(); i++) {
			Hero hero = playerTwo.getHeroes().get(i);
			if(hero.isDestroyed()) {
				destroyedHeroes.add(hero);
			}
		}
		for(int i = 0; i < destroyedHeroes.size(); i++) {
			playerTwo.getHeroes().remove(destroyedHeroes.get(i));
		}
		destroyedHeroes.clear();
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
		end = true;
		Main.gameScene.setWinner(w);
		Main.gameScene.getWinningScene().play();
		Main.gameScene.getWinningScene().setOnFinished(e->{
			Main.sceneHolder.switchScene(Main.homeScene);
			Main.gameRunner.animation.stop();
			Main.gameScene = null;
			Main.gameRunner = null;
			RenderableHolder.getInstance().getGameObjects().clear();
		});
		
	}
	
}
