package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import constant.Fonts;
import constant.Images;
import constant.Numbers;
import constant.Sounds;
import heroBase.HeroType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ActionPart extends VBox {
	
	private int currentBox;
	private Button leftButton, rightButton;
	private List<HeroButton> heroButtonList;
	private SummonBox heroBox, superHeroBox, hybridHeroBox;
	private StatusButton statusButton;
	private Label heroLabel, superHeroLabel, hybridHeroLabel, turnLabel;
	private HBox summonBox;
	private VBox box;
	
	public ActionPart() {
		heroButtonList = new ArrayList<HeroButton>();
		Random rand = new Random();
		int r = rand.nextInt(3);
		HeroType type1, type2;
		if(r == 0) {
			type1 = HeroType.WATER;
			type2 = HeroType.PLANT;
		}
		else if(r == 1) {
			type1 = HeroType.FIRE;
			type2 = HeroType.PLANT;
		}
		else {
			type1 = HeroType.FIRE;
			type2 = HeroType.WATER;
		}
		heroBox = new SummonBox(type1, type2, HeroType.LOVE);
		superHeroBox = new SummonBox(HeroType.SUPERFIRE, HeroType.SUPERWATER, HeroType.SUPERPLANT);
		hybridHeroBox = new SummonBox(HeroType.FIREPLANT, HeroType.WATERFIRE, HeroType.PLANTWATER);
		for(int i = 0; i < heroBox.getHeroButtonList().size(); i++) {
			heroButtonList.add(heroBox.getHeroButtonList().get(i));
		}
		for(int i = 0; i < superHeroBox.getHeroButtonList().size(); i++) {
			heroButtonList.add(superHeroBox.getHeroButtonList().get(i));
		}
		for(int i = 0; i < hybridHeroBox.getHeroButtonList().size(); i++) {
			heroButtonList.add(hybridHeroBox.getHeroButtonList().get(i));
		}
		turnLabel = new Label("player one");
		turnLabel.setFont(Fonts.gameFont2);
		heroLabel = new Label("Hero");
		heroLabel.setFont(Fonts.gameFont);
		superHeroLabel = new Label("Super Hero");
		superHeroLabel.setFont(Fonts.gameFont);
		hybridHeroLabel = new Label("Hybrid Hero");
		hybridHeroLabel.setFont(Fonts.gameFont);
		leftButton = new Button();
		leftButton.setPrefSize(Numbers.ARROW_SIZE, Numbers.ARROW_SIZE);
		leftButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		leftButton.setGraphic(new ImageView(Images.leftArrow));
		leftButton.setOnAction(e->{
			Sounds.click2.play();
			this.currentBox--;
			if(this.currentBox < 0) {
				this.currentBox+=3;
			}
			this.switchBox();
		});
		rightButton = new Button();
		rightButton.setPrefSize(Numbers.ARROW_SIZE, Numbers.ARROW_SIZE);
		rightButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		rightButton.setGraphic(new ImageView(Images.rightArrow));
		rightButton.setOnAction(e->{
			Sounds.click2.play();
			this.currentBox++;
			this.currentBox%=3;
			this.switchBox();
		});
		summonBox = new HBox(30);
		summonBox.setAlignment(Pos.CENTER);
		summonBox.setMinSize(Numbers.ACTIONPART_WIDTH, Numbers.SUMMONBOX_HEIGHT);
		summonBox.getChildren().addAll(leftButton, heroBox, rightButton);
		box = new VBox(30);
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(turnLabel, heroLabel, summonBox);
		statusButton = new StatusButton(StatusButton.Status.MOVE);
		statusButton.setPrefSize(Numbers.STATUSBUTTON_SIZE, Numbers.STATUSBUTTON_SIZE);
		this.setFocused(false);
		this.currentBox = 0;
		this.setSpacing(100);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(box, statusButton);
		this.setPrefSize(Numbers.ACTIONPART_WIDTH, Numbers.WIN_HEIGHT);
		this.setBackground(new Background(new BackgroundImage(Images.actionBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
	}
	
	public void switchBox() {
		this.box.getChildren().clear();
		this.summonBox.getChildren().clear();
		if(this.currentBox == 0) {
			this.summonBox.getChildren().addAll(leftButton, heroBox, rightButton);
			this.box.getChildren().addAll(this.turnLabel, this.heroLabel, this.summonBox);
		}
		else if(this.currentBox == 1) {
			this.summonBox.getChildren().addAll(leftButton, superHeroBox, rightButton);
			this.box.getChildren().addAll(this.turnLabel, this.superHeroLabel, this.summonBox);
		}
		else if(this.currentBox == 2) {
			this.summonBox.getChildren().addAll(leftButton, hybridHeroBox, rightButton);
			this.box.getChildren().addAll(this.turnLabel, this.hybridHeroLabel, this.summonBox);
		}
	}
	
	public void unHilight() {
		for(int i = 0; i < heroButtonList.size(); i++) {
			heroButtonList.get(i).unHilight();
		}
	}
	
	public void switchTurn(Color color) {
		if(color == Color.BLACK) {
			turnLabel.setText("player one");
		}
		else {
			turnLabel.setText("player two");
		}
		Random rand = new Random();
		int r = rand.nextInt(3);
		if(r == 0) {
			heroButtonList.get(0).switchHero(HeroType.WATER, color);
			heroButtonList.get(1).switchHero(HeroType.PLANT, color);
		}
		else if(r == 1) {
			heroButtonList.get(0).switchHero(HeroType.FIRE, color);
			heroButtonList.get(1).switchHero(HeroType.PLANT, color);
		}
		else {
			heroButtonList.get(0).switchHero(HeroType.FIRE, color);
			heroButtonList.get(1).switchHero(HeroType.WATER, color);
		}
		for(int i = 2; i < heroButtonList.size(); i++) {
			heroButtonList.get(i).switchHero(heroButtonList.get(i).getHeroType(), color);
		}
		this.currentBox = 0;
		switchBox();
	}
	
	public StatusButton getStatusButton() {
		return statusButton;
	}
	
	public List<HeroButton> getHeroButtonList(){
		return this.heroButtonList;
	}
	
}
