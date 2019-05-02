package field;

import gui.Images;
import heroBase.FireBase;
import heroBase.Hero;
import heroBase.PlantBase;
import heroBase.WaterBase;
import heroBase.hero.Fire;
import heroBase.hero.Love;
import heroBase.hero.Plant;
import heroBase.hero.Summoner;
import heroBase.hero.Water;
import heroBase.hybridHero.FirePlant;
import heroBase.hybridHero.PlantWater;
import heroBase.hybridHero.WaterFire;
import heroBase.superHero.SuperFire;
import heroBase.superHero.SuperPlant;
import heroBase.superHero.SuperWater;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class FieldUI extends Canvas {
	
	GraphicsContext gc;
	
	public FieldUI() {	
		gc = this.getGraphicsContext2D();
		this.setHeight(900);
		this.setWidth(1000);
	}
	
	public void draw() {
		gc.clearRect(0, 0, 1000, 900);
		for(int i = 0; i < RenderableHolder.getInstance().getGameObjects().size(); i++) {
			if(RenderableHolder.getInstance().getGameObjects().get(i).isVisible() && !RenderableHolder.getInstance().getGameObjects().get(i).isDestroyed()) {
				RenderableHolder.getInstance().getGameObjects().get(i).draw(gc);
			};
		}
	}
	
}
