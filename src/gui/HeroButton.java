package gui;

import constant.Images;
import constant.Numbers;
import constant.Sounds;
import exception.SelectedHeroToSummonException;
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
import sharedObject.RenderableHolder;

public class HeroButton extends Button {
	
	private HeroType type;
	private boolean active, selected;
	
	public HeroButton(HeroType heroType) {
		Rectangle buttonShape = new Rectangle();
		buttonShape.setWidth(Numbers.HEROBUTTON_SIZE);
		buttonShape.setHeight(Numbers.HEROBUTTON_SIZE);
		buttonShape.setArcWidth(Numbers.ARC_SIZE);
		buttonShape.setArcHeight(Numbers.ARC_SIZE);
		this.setPrefSize(Numbers.HEROBUTTON_SIZE, Numbers.HEROBUTTON_SIZE);
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
			try {
				Main.gameRunner.clickHeroButton(this);
				Sounds.heroButtonClick.play();
			} catch (SelectedHeroToSummonException e1) {
				Sounds.invalidClick.play();
				AlertBox alertBox = new AlertBox(e1.getMessage());
				RenderableHolder.getInstance().add(alertBox);
			}
		});
		this.setOnMouseEntered(e->{
			if(!selected && active) {
				this.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		this.setOnMouseExited(e->{
			if(!selected && active) {
				this.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
	}
	
	public void hilight() {
		if(active) {
			this.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			selected = true;
		}	
	}
	
	public void unHilight() {
		if(active) {
			this.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
			selected = false;
		}
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
				default : this.setImage(null);
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
			default : this.setImage(null);
			}
		}
		if(!active) {
			this.setOpacity(0.5);
			this.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		else {
			this.setOpacity(1.0);
			this.unHilight();
		}
	}
	
	public HeroType getHeroType() {
		return type;
	}
	
	public void setImage(Image image) {
		this.setGraphic(new ImageView(image));
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isActive() {
		return active;
	}

}
