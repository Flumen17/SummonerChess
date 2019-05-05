package gui;

import java.util.ArrayList;
import java.util.List;

import constant.Numbers;
import heroBase.HeroType;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class SummonBox extends VBox {
	
	private List<HeroButton> heroButtonList;
	
	public SummonBox(HeroType first, HeroType second, HeroType third) {
		
		heroButtonList = new ArrayList<HeroButton>();
		HeroButton one = new HeroButton(first);
		HeroButton two = new HeroButton(second);
		HeroButton three = new HeroButton(third);
		heroButtonList.add(one);
		heroButtonList.add(two);
		heroButtonList.add(three);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(50);
		this.setPrefSize(Numbers.HEROBUTTON_SIZE, Numbers.SUMMONBOX_HEIGHT);
		this.setMinSize(Numbers.HEROBUTTON_SIZE, Numbers.SUMMONBOX_HEIGHT);
		this.getChildren().addAll(one, two, three);
	}

	public List<HeroButton> getHeroButtonList(){
		return heroButtonList;
	}
	
}
