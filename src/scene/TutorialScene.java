package scene;

import java.util.ArrayList;
import java.util.List;

import button.BackButton;
import button.ButtonBase;
import constant.Fonts;
import constant.Images;
import constant.Numbers;
import constant.Sounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.Main;

public class TutorialScene extends Scene {
	
	public static TutorialScene instance = new TutorialScene(); 
	private Button rightButton, leftButton;
	private BackButton backButton;
	private VBox rightButtonBox, leftButtonBox;
	private HBox backButtonBox;
	private BorderPane root;
	private int currentPage = 0;
	private Image[] pages;
	
	public TutorialScene() {
		super(new BorderPane(), Numbers.WIN_WIDTH, Numbers.WIN_HEIGHT);
		root = (BorderPane) getRoot();
		root.setPrefSize(1600, 1000);
		root.setBackground(new Background(new BackgroundImage(Images.tutorial[0], BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		this.setLeftRightButton();
		root.setLeft(leftButtonBox);
		root.setRight(rightButtonBox);
		this.setBackButton();
		root.setBottom(backButtonBox);
		pages = Images.tutorial;
	}
	
	private void setLeftRightButton() {
		leftButton = new Button();
		leftButton.setPrefSize(Numbers.ARROW_SIZE, Numbers.ARROW_SIZE);
		leftButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		leftButton.setGraphic(new ImageView(Images.leftArrow));
		leftButton.setOnAction(e->{
			Sounds.click2.play();
			if(currentPage != 0)currentPage--;
			this.switchPage();
		});
		leftButtonBox = new VBox();
		leftButtonBox.setAlignment(Pos.CENTER);
		leftButtonBox.setPrefHeight(1000);
		leftButtonBox.getChildren().add(leftButton);
		rightButton = new Button();
		rightButton.setPrefSize(Numbers.ARROW_SIZE, Numbers.ARROW_SIZE);
		rightButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		rightButton.setGraphic(new ImageView(Images.rightArrow));
		rightButton.setOnAction(e->{
			Sounds.click2.play();
			if(currentPage != pages.length - 1)currentPage++;
			this.switchPage();
			
		});
		rightButtonBox = new VBox();
		rightButtonBox.setAlignment(Pos.CENTER);
		rightButtonBox.setPrefHeight(1000);
		rightButtonBox.getChildren().add(rightButton);
	}
	
	public void setBackButton() {
		backButton = new BackButton(60, 60, Images.unpressedBackButton, Images.hoverBackButton, Images.pressedBackButton);
		backButtonBox = new HBox();
		backButtonBox.setAlignment(Pos.CENTER_RIGHT);
		backButtonBox.setPrefSize(1600, 100);
		backButtonBox.getChildren().add(backButton);
	}
	
	public void switchPage() {
		root.setBackground(new Background(new BackgroundImage(pages[currentPage], BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
	}
	
}
