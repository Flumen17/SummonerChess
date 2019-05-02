package gui;

import heroBase.HeroType;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.Main;

public class HeroButton extends Button {
	
	private HeroType type;
	private boolean active;
	
	public HeroButton(HeroType heroType) {
		Rectangle buttonShape = new Rectangle();
		buttonShape.setWidth(120);
		buttonShape.setHeight(120);
		buttonShape.setArcWidth(20);
		buttonShape.setArcHeight(20);
		this.setPrefSize(120, 120);
		this.setShape(buttonShape);
		this.unHilight();
		if(heroType == HeroType.FIRE || heroType == HeroType.WATER || heroType == HeroType.PLANT) {
			this.active = true;
		}
		else {
			this.active = false;
		}
		this.type = heroType;
		switchHero(heroType, Color.BLACK);
		this.setOnAction(e->{
			Main.gameRunner.clickHeroButton(this);
		});
	}
	
	public void hilight() {
		this.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void unHilight() {
		this.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public HeroType getHeroType() {
		return type;
	}
	
	public void setImage(Image image) {
		this.setGraphic(new ImageView(image));
	}
	
	public void switchHero(HeroType heroType, Color color) {
		this.type = heroType;
		if(color == Color.BLACK) {
			switch(heroType) {
				case WATER : this.setImage(Images.water_BF); break;
				case FIRE : this.setImage(Images.fire_BF); break;
				case PLANT : this.setImage(Images.plant_BF); break;
				case SUPERWATER : this.setImage(Images.superWater_BF); break;
				case SUPERFIRE : this.setImage(Images.superFire_BF); break;
				case SUPERPLANT : this.setImage(Images.superPlant_BF); break;
				case WATERFIRE : this.setImage(Images.waterFire_BF); break;
				case FIREPLANT : this.setImage(Images.firePlant_BF); break;
				case PLANTWATER : this.setImage(Images.plantWater_BF); break;
				case LOVE : this.setImage(Images.love_BF); break;
				default :
			}
		}
		else {
			switch(heroType) {
			case WATER : this.setImage(Images.water_WF); break;
			case FIRE : this.setImage(Images.fire_WF); break;
			case PLANT : this.setImage(Images.plant_WF); break;
			case SUPERWATER : this.setImage(Images.superWater_WF); break;
			case SUPERFIRE : this.setImage(Images.superFire_WF); break;
			case SUPERPLANT : this.setImage(Images.superPlant_WF); break;
			case WATERFIRE : this.setImage(Images.waterFire_WF); break;
			case FIREPLANT : this.setImage(Images.firePlant_WF); break;
			case PLANTWATER : this.setImage(Images.plantWater_WF); break;
			case LOVE : this.setImage(Images.love_WF); break;
			default :
			}
		}
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
