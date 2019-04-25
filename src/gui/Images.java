package gui;

import javafx.scene.image.Image;

public class Images {
	public static Image summoner_BG, summoner_WG, summoner_BF, summoner_WF;
	public static Image fire_BG, fire_WG, fire_BF, fire_WF;
	public static Image water_BG, water_WG, water_BF, water_WF;
	public static Image plant_BG, plant_WG, plant_BF, plant_WF;
	public static Image superFire_BG, superFire_WG, superFire_BF, superFire_WF;
	public static Image superWater_BG, superWater_WG, superWater_BF, superWater_WF;
	public static Image superPlant_BG, superPlant_WG, superPlant_BF, superPlant_WF;
	public static Image firePlant_BG, firePlant_WG, firePlant_BF, firePlant_WF;
	public static Image waterFire_BG, waterFire_WG, waterFire_BF, waterFire_WF;
	public static Image plantWater_BG, plantWater_WG, plantWater_BF, plantWater_WF;
	public static Image love_BG, love_WG, love_BF, love_WF;
	
	public static void loadResource() {
		summoner_BF = loadImage("Summoner_BF.png",100, 100);
		summoner_WF = loadImage("Summoner_WF.png",100, 100);
		summoner_BG = loadImage("Summoner_BG.png",100, 100);
		summoner_WG = loadImage("Summoner_WG.png",100, 100);
		fire_BF = loadImage("Fire_BF.png",100, 100);
		fire_WF = loadImage("Fire_WF.png",100, 100);
		fire_BG = loadImage("Fire_BG.png",100, 100);
		fire_WG = loadImage("Fire_WG.png",100, 100);
		water_BF = loadImage("Water_BF.png",100, 100);
		water_WF = loadImage("Water_WF.png",100, 100);
		water_BG = loadImage("Water_BG.png",100, 100);
		water_WG = loadImage("Water_WG.png",100, 100);
		plant_BF = loadImage("Plant_BF.png",100, 100);
		plant_WF = loadImage("Plant_WF.png",100, 100);
		plant_BG = loadImage("Plant_BG.png",100, 100);
		plant_WG = loadImage("Plant_WG.png",100, 100);
		superFire_BF = loadImage("SuperFire_BF.png",100, 100);
		superFire_WF = loadImage("SuperFire_WF.png",100, 100);
		superFire_BG = loadImage("SuperFire_BG.png",100, 100);
		superFire_WG = loadImage("SuperFire_WG.png",100, 100);
		superWater_BF = loadImage("SuperWater_BF.png",100, 100);
		superWater_WF = loadImage("SuperWater_WF.png",100, 100);
		superWater_BG = loadImage("SuperWater_BG.png",100, 100);
		superWater_WG = loadImage("SuperWater_WG.png",100, 100);
		superPlant_BF = loadImage("SuperPlant_BF.png",100, 100);
		superPlant_WF = loadImage("SuperPlant_WF.png",100, 100);
		superPlant_BG = loadImage("SuperPlant_BG.png",100, 100);
		superPlant_WG = loadImage("SuperPlant_WG.png",100, 100);
		firePlant_BF = loadImage("FirePlant_BF.png",100, 100);
		firePlant_WF = loadImage("FirePlant_WF.png",100, 100);
		firePlant_BG = loadImage("FirePlant_BG.png",100, 100);
		firePlant_WG = loadImage("FirePlant_WG.png",100, 100);
		waterFire_BF = loadImage("WaterFire_BF.png",100, 100);
		waterFire_WF = loadImage("WaterFire_WF.png",100, 100);
		waterFire_BG = loadImage("WaterFire_BG.png",100, 100);
		waterFire_WG = loadImage("WaterFire_WG.png",100, 100);
		plantWater_BF = loadImage("PlantWater_BF.png",100, 100);
		plantWater_WF = loadImage("PlantWater_WF.png",100, 100);
		plantWater_BG = loadImage("PlantWater_BG.png",100, 100);
		plantWater_WG = loadImage("PlantWater_WG.png",100, 100);
		love_BF = loadImage("Love_BF.png",100, 100);
		love_WF = loadImage("Love_WF.png",100, 100);
		love_BG = loadImage("Love_BG.png",100, 100);
		love_WG = loadImage("Love_WG.png",100, 100);
		
	}
	
	public static Image loadImage(String path, double width, double height){
        return new Image(ClassLoader.getSystemResource(path).toString(), width, height, true, true);
    }
}
