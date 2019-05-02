package gui;

import field.Field;
import field.FieldUI;
import field.FloristField;
import field.SquarizerField;
import field.TurbineField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import logic.GameHolder;
import main.Main;

public class GamePart extends StackPane {
	
	Field logicPane;
	FieldUI paintPane;
	
	public GamePart() {
		this.setPadding(new Insets(50, 150, 50, 150));
		this.setPrefSize(1300, 1000);
		this.setAlignment(Pos.BOTTOM_RIGHT);
		Button mainMenubtn = new Button("Main Menu");
		mainMenubtn.setOnAction(e->{
			Main.sceneHolder.switchScene(Main.homeScene);
		});
		Image image;
		switch(Main.gameHolder.getGameTheme()) {
			case FIRE : image = Images.fireBackground; break;
			case WATER : image = Images.waterBackground; break;
			case PLANT : image = Images.plantBackground; break;
			case LOVE : image = Images.loveBackground; break;
			default : image = null;
		}
		this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT))); 
		if(Main.gameHolder.getGameField() == GameHolder.GameField.SQUARIZER)logicPane = new SquarizerField();
		else if(Main.gameHolder.getGameField() == GameHolder.GameField.TURBINE)logicPane = new TurbineField();
		else logicPane = new FloristField();
		paintPane = new FieldUI();
		this.getChildren().addAll(paintPane, logicPane, mainMenubtn);
	}
	
	public Field getLogicPane() {
		return logicPane;
	}
	
	public FieldUI getPaintPane() {
		return paintPane;
	}
	
}
