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
	public static Image cell, cell1, cell2, loveCell, loveCell2, waterCell;
	public static Image background, actionBackground, loveBackground, fireBackground, waterBackground, plantBackground;
	public static Image leftArrow, rightArrow;
	public static Image moveButton, summonButton;
	public static Image loveSquarizer, loveTurbine, loveFlorist;
	public static Image fireSquarizer, fireTurbine, fireFlorist;
	public static Image waterSquarizer, waterTurbine, waterFlorist;
	public static Image plantSquarizer, plantTurbine, plantFlorist;
	public static Image bGod, bFlag, bTower;
	public static Image wGod, wFlag, wTower;
	public static Image summonBGodButton, summonWGodButton;
	public static Image pressedButton, unPressedButton, overButton;
	public static Image homeBackground, settingBackground;
	private static double progress = 0;
	public static void loadResource() {
		summoner_BF = loadImage("Summoner_BF.png",120, 120);
		summoner_WF = loadImage("Summoner_WF.png",120, 120);
		summoner_BG = loadImage("Summoner_BG.png",100, 100);
		summoner_WG = loadImage("Summoner_WG.png",100, 100);
		fire_BF = loadImage("Fire_BF.png",120, 120);
		fire_WF = loadImage("Fire_WF.png",120, 120);
		fire_BG = loadImage("Fire_BG.png",100, 100);
		fire_WG = loadImage("Fire_WG.png",100, 100);
		setProgress(0.1);
		water_BF = loadImage("Water_BF.png",120, 120);
		water_WF = loadImage("Water_WF.png",120, 120);
		water_BG = loadImage("Water_BG.png",100, 100);
		water_WG = loadImage("Water_WG.png",100, 100);
		plant_BF = loadImage("Plant_BF.png",120, 120);
		plant_WF = loadImage("Plant_WF.png",120, 120);
		plant_BG = loadImage("Plant_BG.png",100, 100);
		plant_WG = loadImage("Plant_WG.png",100, 100);
		setProgress(0.2);
		superFire_BF = loadImage("SuperFire_BF.png",120, 120);
		superFire_WF = loadImage("SuperFire_WF.png",120, 120);
		superFire_BG = loadImage("SuperFire_BG.png",100, 100);
		superFire_WG = loadImage("SuperFire_WG.png",100, 100);
		superWater_BF = loadImage("SuperWater_BF.png",120, 120);
		superWater_WF = loadImage("SuperWater_WF.png",120, 120);
		superWater_BG = loadImage("SuperWater_BG.png",100, 100);
		superWater_WG = loadImage("SuperWater_WG.png",100, 100);
		setProgress(0.3);
		superPlant_BF = loadImage("SuperPlant_BF.png",120, 120);
		superPlant_WF = loadImage("SuperPlant_WF.png",120, 120);
		superPlant_BG = loadImage("SuperPlant_BG.png",100, 100);
		superPlant_WG = loadImage("SuperPlant_WG.png",100, 100);
		firePlant_BF = loadImage("FirePlant_BF.png",120, 120);
		firePlant_WF = loadImage("FirePlant_WF.png",120, 120);
		firePlant_BG = loadImage("FirePlant_BG.png",100, 100);
		firePlant_WG = loadImage("FirePlant_WG.png",100, 100);
		setProgress(0.4);
		waterFire_BF = loadImage("WaterFire_BF.png",120, 120);
		waterFire_WF = loadImage("WaterFire_WF.png",120, 120);
		waterFire_BG = loadImage("WaterFire_BG.png",100, 100);
		waterFire_WG = loadImage("WaterFire_WG.png",100, 100);
		plantWater_BF = loadImage("PlantWater_BF.png",120, 120);
		plantWater_WF = loadImage("PlantWater_WF.png",120, 120);
		plantWater_BG = loadImage("PlantWater_BG.png",100, 100);
		plantWater_WG = loadImage("PlantWater_WG.png",100, 100);
		setProgress(0.5);
		love_BF = loadImage("Love_BF.png",120, 120);
		love_WF = loadImage("Love_WF.png",120, 120);
		love_BG = loadImage("Love_BG.png",100, 100);
		love_WG = loadImage("Love_WG.png",100, 100);
		setProgress(0.6);
		cell = loadImage("Cell6.jpg", 100, 100);
		cell1 = loadImage("Cell1.png", 100, 100);
		cell2 = loadImage("Cell2.png", 100, 100);
		
		background = loadImage("newBackground.png", 1300, 1000);
		loveBackground = loadImage("LoveBackground.png", 1300, 1000);
		fireBackground = loadImage("FireBackground.png", 1300, 1000);
		setProgress(0.7);
		waterBackground = loadImage("WaterBackground.png", 1300, 1000);
		plantBackground = loadImage("PlantBackground.png", 1300, 1000);
		actionBackground = loadImage("newActionBackground.png", 300, 1000);
		setProgress(0.8);
		loveCell = loadImage("LoveCell.png", 100, 100);
		loveCell2 = loadImage("LoveCell2.png", 100, 100);
		waterCell = loadImage("WaterCell.png", 100, 100);
		setProgress(0.9);
		leftArrow = loadImage("LeftArrow.png", 30, 30);
		rightArrow = loadImage("RightArrow.png", 30, 30);
		moveButton = loadImage("MoveButton.png", 150, 150);
		summonButton = loadImage("SummonButton.png", 150, 150);
		loveSquarizer = loadImage("LoveSquarizer.png", 975, 750);
		loveTurbine = loadImage("LoveTurbine.png", 975, 750);
		loveFlorist = loadImage("LoveFlorist.png", 975, 750);
		fireSquarizer = loadImage("FireSquarizer.png", 975, 750);
		fireTurbine = loadImage("FireTurbine.png", 975, 750);
		fireFlorist = loadImage("FireFlorist.png", 975, 750);
		waterSquarizer = loadImage("WaterSquarizer.png", 975, 750);
		waterTurbine = loadImage("WaterTurbine.png", 975, 750);
		waterFlorist = loadImage("WaterFlorist.png", 975, 750);
		plantSquarizer = loadImage("PlantSquarizer.png", 975, 750);
		plantTurbine = loadImage("PlantTurbine.png", 975, 750);
		plantFlorist = loadImage("PlantFlorist.png", 975, 750);
		bGod = loadImage("BGod.png", 100, 100);
		bFlag = loadImage("BFlag.png", 100, 100);
		bTower = loadImage("BTower.png", 100, 100);
		wGod = loadImage("WGod.png", 100, 100);
		wFlag = loadImage("WFlag.png", 100, 100);
		wTower = loadImage("WTower.png", 100, 100);
		summonBGodButton = loadImage("SummonBGodButton.png", 150, 150);
		summonWGodButton = loadImage("SummonWGodButton.png", 150, 150);
		pressedButton = loadImage("PressedButton.png", 270, 90);
		unPressedButton = loadImage("UnPressedButton.png", 270, 90);
		overButton = loadImage("OverButton.png", 270, 90);
		homeBackground = loadImage("HomeBackground.png", 1600, 1000 );
		settingBackground = loadImage("SettingBackground.png", 1600, 1000);
		setProgress(1.0);
	}
	
	public static Image loadImage(String path, double width, double height){
        return new Image(ClassLoader.getSystemResource(path).toString(), width, height, true, true);
    }
	
	public static void setProgress(double progress) {
		Images.progress = progress;
	}
	public static double getProgress() {
		return progress;
	}
}
