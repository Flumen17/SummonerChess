package heroBase;

import heroBase.hero.Fire;
import heroBase.hero.Love;
import heroBase.hero.Plant;
import heroBase.hero.Water;
import heroBase.hybridHero.FirePlant;
import heroBase.hybridHero.PlantWater;
import heroBase.hybridHero.WaterFire;
import heroBase.superHero.SuperFire;
import heroBase.superHero.SuperPlant;
import heroBase.superHero.SuperWater;
import javafx.scene.paint.Color;

public enum HeroType {
	FIRE,
	WATER,
	PLANT,
	SUPERFIRE,
	SUPERWATER,
	SUPERPLANT,
	FIREPLANT,
	WATERFIRE,
	PLANTWATER,
	LOVE,
	SUMMONER;
	
	public Hero toHero(int x, int y, Color color) {
		switch(this) {
			case FIRE : return new Fire(x, y, color);
			case WATER : return new Water(x, y, color);
			case PLANT : return new Plant(x, y, color);
			case SUPERFIRE : return new SuperFire(x, y, color);
			case SUPERWATER : return new SuperWater(x, y, color);
			case SUPERPLANT : return new SuperPlant(x, y, color);
			case FIREPLANT : return new FirePlant(x, y, color);
			case WATERFIRE : return new WaterFire(x, y, color);
			case PLANTWATER : return new PlantWater(x, y, color);
			default : return new Love(x, y, color); 
		}
	}

}
