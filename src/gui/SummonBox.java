package gui;

import java.util.ArrayList;
import java.util.List;

import heroBase.HeroType;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SummonBox extends VBox {
	
	private List<HeroButton> heroButtonList;
	
	public SummonBox(HeroType first, HeroType second, HeroType third) {
		heroButtonList = new ArrayList<HeroButton>();
		this.setAlignment(Pos.CENTER);
		this.setSpacing(50);
		HeroButton one = new HeroButton(first);
		HeroButton two = new HeroButton(second);
		HeroButton three = new HeroButton(third);
		heroButtonList.add(one);
		heroButtonList.add(two);
		this.setPrefSize(120, 500);
		this.setMinSize(120, 500);
		heroButtonList.add(three);
		this.getChildren().addAll(one, two, three);
	}
	
//	public SummonBox(HeroType first, HeroType second) {
//		heroButtonList = new ArrayList<HeroButton>();;
//		HeroButton one = new HeroButton(first);
//		HeroButton two = new HeroButton(second);
//		this.setPrefSize(120, 500);
//		this.setMinSize(120, 500);
//		this.setSpacing(50);
//		this.setAlignment(Pos.CENTER);
//		this.getChildren().addAll(one, two);
//		heroButtonList.add(one);
//		heroButtonList.add(two);
//	}
	
	public List<HeroButton> getHeroButtonList(){
		return heroButtonList;
	}
}
