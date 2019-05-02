package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	private int selectedAction, currentBox;
	private HeroType selectedHero;
	private Button leftButton, rightButton;
	private StatusButton statusButton;
	private List<HeroButton> heroButtonList;
	private HBox box;
	private VBox vbox;
	private SummonBox heroBox, superHeroBox, hybridHeroBox;
	private Label heroLabel, superHeroLabel, hybridHeroLabel;
	
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
		heroLabel = new Label("Hero");
		heroLabel.setFont(Fonts.gameFont);
		superHeroLabel = new Label("Super Hero");
		superHeroLabel.setFont(Fonts.gameFont);
		hybridHeroLabel = new Label("Hybrid Hero");
		hybridHeroLabel.setFont(Fonts.gameFont);
		leftButton = new Button();
		leftButton.setPrefSize(30, 30);
		leftButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		leftButton.setGraphic(new ImageView(Images.leftArrow));
		leftButton.setOnAction(e->{
			this.currentBox--;
			if(this.currentBox < 0)this.currentBox+=3;
			this.switchBox();
		});
		
		rightButton = new Button();
		rightButton.setPrefSize(30, 30);
		rightButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		rightButton.setGraphic(new ImageView(Images.rightArrow));
		rightButton.setOnAction(e->{
			this.currentBox++;
			this.currentBox%=3;
			this.switchBox();
		});
		box = new HBox(30);
		box.setAlignment(Pos.CENTER);
		box.setMinSize(300, 500);
		box.getChildren().addAll(leftButton, heroBox, rightButton);
		vbox = new VBox(30);
		vbox.setAlignment(Pos.CENTER);
		vbox.setMinSize(300,  100);
		vbox.getChildren().addAll(heroLabel, box);
		currentBox = 0;
		statusButton = new StatusButton(StatusButton.Status.MOVE);
		statusButton.setPrefSize(150, 150);
		this.setSpacing(100);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(vbox, statusButton);
		this.setPrefSize(300, 1000);
		this.setBackground(new Background(new BackgroundImage(Images.actionBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, new BackgroundPosition(null, 0, false, null, 0, false), new BackgroundSize(1300, 1000, false, false, true, false))));
	}
	
	public void switchBox() {
		this.vbox.getChildren().clear();
		this.box.getChildren().clear();
		if(this.currentBox == 0) {
			this.box.getChildren().addAll(leftButton, heroBox, rightButton);
			this.vbox.getChildren().addAll(this.heroLabel, this.box);
		}
		else if(this.currentBox == 1) {
			this.box.getChildren().addAll(leftButton, superHeroBox, rightButton);
			this.vbox.getChildren().addAll(this.superHeroLabel, this.box);
		}
		else if(this.currentBox == 2) {
			this.box.getChildren().addAll(leftButton, hybridHeroBox, rightButton);
			this.vbox.getChildren().addAll(this.hybridHeroLabel, this.box);
		}
	}

	public int getSelectedAction() {
		return selectedAction;
	}

	public HeroType getSelectedHero() {
		return selectedHero;
	}

	public StatusButton getStatusButton() {
		return statusButton;
	}
	
	public List<HeroButton> getHeroButtonList(){
		return this.heroButtonList;
	}
	
	public void unHilight() {
		for(int i = 0; i < heroButtonList.size(); i++) {
			heroButtonList.get(i).unHilight();
		}
	}
	
	public void switchTurn(Color color) {
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
}
