package scene;

import gui.ActionPart;
import gui.GamePart;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import logic.GameHolder;

public class GameScene extends Scene {
	
	private ActionPart actionPart;
	private GamePart gamePart;
	private HBox root;
	
	public GameScene() {
		super(new HBox(), 1600, 1000);
		root = (HBox) getRoot();
		
		actionPart = new ActionPart();
		gamePart = new GamePart();
		root.getChildren().addAll(actionPart, gamePart);
	}
	public ActionPart getActionPart() {
		return actionPart;
	}

	public GamePart getGamePart() {
		return gamePart;
	}
	
	
}
