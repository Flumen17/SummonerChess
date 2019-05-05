package logic;

public class GameHolder {
	
	GameMode gameMode;
	GameTheme gameTheme;
	GameField gameField;
	
	public GameHolder() {
		this.gameMode = GameMode.SUMMONTHEGOD;
		this.gameTheme = GameTheme.LOVE;
		this.gameField = GameField.SQUARIZER;
	}
	
	public enum GameMode{
		SUMMONTHEGOD, STEALTHEFLAG, TOWERDESTROY;
	}
	
	public enum GameTheme{
		FIRE, WATER, PLANT, LOVE;
	}
	
	public enum GameField{
		SQUARIZER, TURBINE, FLORIST;
	}
	
	public GameMode getGameMode() {
		return gameMode;
	}
	
	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}
	
	public GameTheme getGameTheme() {
		return gameTheme;
	}
	
	public void setGameTheme(GameTheme gameTheme) {
		this.gameTheme = gameTheme;
	}
	
	public GameField getGameField() {
		return gameField;
	}
	
	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}
	
}
