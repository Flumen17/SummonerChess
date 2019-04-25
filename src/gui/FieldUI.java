package gui;

import hero.Fire;
import hero.Love;
import hero.Plant;
import hero.Summoner;
import hero.Water;
import hero.base.FireBase;
import hero.base.Hero;
import hero.base.PlantBase;
import hero.base.WaterBase;
import hero.highlevel.SuperFire;
import hero.highlevel.SuperPlant;
import hero.highlevel.SuperWater;
import hero.hybrid.FirePlant;
import hero.hybrid.PlantWater;
import hero.hybrid.WaterFire;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.Cell;
import logic.Field;

public class FieldUI extends Canvas {
	
	GraphicsContext gc;
	Field field;
	
	public FieldUI(Field field) {	
		gc = this.getGraphicsContext2D();
		this.field = field;
		this.setHeight(900);
		this.setWidth(900);
		render();
	}
	
	public void render() {
		gc.clearRect(0, 0, 900, 900);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i<=3&&Math.abs(j-4)>i)continue;
				else if(i>3&&Math.abs(j-4)>(8-i))continue;
				if(field.getCellAt(i, j).getType() == Cell.Type.NORMAL)gc.setFill(field.getCellAt(i, j).getColor());
				else if(field.getCellAt(i, j).getType() == Cell.Type.MOVEABLE)gc.setFill(Color.LAWNGREEN);
				else if(field.getCellAt(i, j).getType() == Cell.Type.KILLABLE)gc.setFill(Color.RED);
				gc.fillRect(j * 100, i * 100, 100, 100);
				Hero hero = field.getCellAt(i, j).getHero(); 
				if(hero != null) {
					if(hero instanceof Summoner) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.summoner_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.summoner_WG, j*100, i*100);
						}
						
					}
					if(hero instanceof Fire) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.fire_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.fire_WG, j*100, i*100);
						}
					}
					else if(hero instanceof Water) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.water_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.water_WG, j*100, i*100);
						}
					}
					else if(hero instanceof Plant) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.plant_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.plant_WG, j*100, i*100);
						}
					}
					else if(hero instanceof SuperFire) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.superFire_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.superFire_WG, j*100, i*100);
						}
					}
					else if(hero instanceof SuperWater) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.superWater_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.superWater_WG, j*100, i*100);
						}
					}
					else if(hero instanceof SuperPlant) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.superPlant_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.superPlant_WG, j*100, i*100);
						}
					}
					if(hero instanceof FirePlant) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.firePlant_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.firePlant_WG, j*100, i*100);
						}
					}
					else if(hero instanceof WaterFire) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.waterFire_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.waterFire_WG, j*100, i*100);
						}
					}
					else if(hero instanceof PlantWater) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.plantWater_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.plantWater_WG, j*100, i*100);
						}
					}
					
					else if(hero instanceof Love) {
						if(hero.getColor() == Color.BLACK) {
							gc.drawImage(Images.love_BG, j*100, i*100);
						}
						else {
							gc.drawImage(Images.love_WG, j*100, i*100);
						}
					}
				}
			}
		}
	}
	
}
