package constant;

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
	public static Image homeBackground, settingBackground, loadingBackground;
	public static Image logo;
	public static Image bHoldBFlag, bHoldWFlag, wHoldBFlag, wHoldWFlag;
	public static Image unpressedHomeButton, hoverHomeButton, pressedHomeButton;
	public static Image unpressedHowToPlayButton, hoverHowToPlayButton, pressedHowToPlayButton;
	public static Image unpressedMusicButton, hoverMusicButton, pressedMusicButton;
	public static Image unpressedSoundButton, hoverSoundButton, pressedSoundButton;
	public static Image winningFrame;
	private static double progress = 0;
	static{
		loadingBackground = loadImage("LoadingBackground", 1600, 1000);
		logo = loadImage("logo", 300, 150);
	}
	public static void loadResource() {
		summoner_BF = loadImage("Summoner_BF",120, 120);
		summoner_WF = loadImage("Summoner_WF",120, 120);
		summoner_BG = loadImage("Summoner_BG",100, 100);
		summoner_WG = loadImage("Summoner_WG",100, 100);
		fire_BF = loadImage("Fire_BF",120, 120);
		fire_WF = loadImage("Fire_WF",120, 120);
		fire_BG = loadImage("Fire_BG",100, 100);
		fire_WG = loadImage("Fire_WG",100, 100);
		setProgress(0.1);
		water_BF = loadImage("Water_BF",120, 120);
		water_WF = loadImage("Water_WF",120, 120);
		water_BG = loadImage("Water_BG",100, 100);
		water_WG = loadImage("Water_WG",100, 100);
		plant_BF = loadImage("Plant_BF",120, 120);
		plant_WF = loadImage("Plant_WF",120, 120);
		plant_BG = loadImage("Plant_BG",100, 100);
		plant_WG = loadImage("Plant_WG",100, 100);
		setProgress(0.2);
		superFire_BF = loadImage("SuperFire_BF",120, 120);
		superFire_WF = loadImage("SuperFire_WF",120, 120);
		superFire_BG = loadImage("SuperFire_BG",100, 100);
		superFire_WG = loadImage("SuperFire_WG",100, 100);
		superWater_BF = loadImage("SuperWater_BF",120, 120);
		superWater_WF = loadImage("SuperWater_WF",120, 120);
		superWater_BG = loadImage("SuperWater_BG",100, 100);
		superWater_WG = loadImage("SuperWater_WG",100, 100);
		setProgress(0.3);
		superPlant_BF = loadImage("SuperPlant_BF",120, 120);
		superPlant_WF = loadImage("SuperPlant_WF",120, 120);
		superPlant_BG = loadImage("SuperPlant_BG",100, 100);
		superPlant_WG = loadImage("SuperPlant_WG",100, 100);
		firePlant_BF = loadImage("FirePlant_BF",120, 120);
		firePlant_WF = loadImage("FirePlant_WF",120, 120);
		firePlant_BG = loadImage("FirePlant_BG",100, 100);
		firePlant_WG = loadImage("FirePlant_WG",100, 100);
		setProgress(0.4);
		waterFire_BF = loadImage("WaterFire_BF",120, 120);
		waterFire_WF = loadImage("WaterFire_WF",120, 120);
		waterFire_BG = loadImage("WaterFire_BG",100, 100);
		waterFire_WG = loadImage("WaterFire_WG",100, 100);
		plantWater_BF = loadImage("PlantWater_BF",120, 120);
		plantWater_WF = loadImage("PlantWater_WF",120, 120);
		plantWater_BG = loadImage("PlantWater_BG",100, 100);
		plantWater_WG = loadImage("PlantWater_WG",100, 100);
		setProgress(0.5);
		love_BF = loadImage("Love_BF",120, 120);
		love_WF = loadImage("Love_WF",120, 120);
		love_BG = loadImage("Love_BG",100, 100);
		love_WG = loadImage("Love_WG",100, 100);
		setProgress(0.6);
		
		background = loadImage("newBackground", 1300, 1000);
		loveBackground = loadImage("LoveBackground", 1300, 1000);
		fireBackground = loadImage("FireBackground", 1300, 1000);
		setProgress(0.7);
		waterBackground = loadImage("WaterBackground", 1300, 1000);
		plantBackground = loadImage("PlantBackground", 1300, 1000);
		actionBackground = loadImage("newActionBackground", 300, 1000);
		setProgress(0.8);
		loveCell = loadImage("LoveCell", 100, 100);
		loveCell2 = loadImage("LoveCell2", 100, 100);
		waterCell = loadImage("WaterCell", 100, 100);
		setProgress(0.9);
		leftArrow = loadImage("LeftArrow", 30, 30);
		rightArrow = loadImage("RightArrow", 30, 30);
		moveButton = loadImage("MoveButton", 150, 150);
		summonButton = loadImage("SummonButton", 150, 150);
		loveSquarizer = loadImage("LoveSquarizer", 975, 750);
		loveTurbine = loadImage("LoveTurbine", 975, 750);
		loveFlorist = loadImage("LoveFlorist", 975, 750);
		fireSquarizer = loadImage("FireSquarizer", 975, 750);
		fireTurbine = loadImage("FireTurbine", 975, 750);
		fireFlorist = loadImage("FireFlorist", 975, 750);
		waterSquarizer = loadImage("WaterSquarizer", 975, 750);
		waterTurbine = loadImage("WaterTurbine", 975, 750);
		waterFlorist = loadImage("WaterFlorist", 975, 750);
		plantSquarizer = loadImage("PlantSquarizer", 975, 750);
		plantTurbine = loadImage("PlantTurbine", 975, 750);
		plantFlorist = loadImage("PlantFlorist", 975, 750);
		bGod = loadImage("BGod", 300, 450);
		bFlag = loadImage("BFlag", 100, 100);
		bTower = loadImage("BTower", 100, 100);
		wGod = loadImage("WGod", 300, 450);
		wFlag = loadImage("WFlag", 100, 100);
		wTower = loadImage("WTower", 100, 100);
		summonBGodButton = loadImage("SummonBGodButton", 150, 150);
		summonWGodButton = loadImage("SummonWGodButton", 150, 150);
		pressedButton = loadImage("PressedButton", 270, 90);
		unPressedButton = loadImage("UnPressedButton", 270, 90);
		overButton = loadImage("OverButton", 270, 90);
		homeBackground = loadImage("HomeBackground", 1600, 1000 );
		settingBackground = loadImage("SettingBackground", 1600, 1000);
		bHoldBFlag = loadImage("BHoldBFlag", 100, 100);
		bHoldWFlag = loadImage("BHoldWFlag", 100, 100);
		wHoldBFlag = loadImage("WHoldBFlag", 100, 100);
		wHoldWFlag = loadImage("WHoldWFlag", 100, 100);
		unpressedHomeButton = loadImage("UnpressedHomeButton", 60, 60);
		hoverHomeButton = loadImage("HoverHomeButton", 60, 60);
		pressedHomeButton = loadImage("PressedHomeButton", 60, 60);
		unpressedHowToPlayButton = loadImage("UnpressedHowToPlayButton", 60, 60);
		hoverHowToPlayButton = loadImage("HoverHowToPlayButton", 60, 60);
		pressedHowToPlayButton = loadImage("PressedHowToPlayButton", 60, 60);
		unpressedMusicButton = loadImage("UnpressedMusicButton", 60, 60);
		hoverMusicButton = loadImage("HoverMusicButton", 60, 60);
		pressedMusicButton = loadImage("PressedMusicButton", 60, 60);
		unpressedSoundButton = loadImage("UnpressedSoundButton", 60, 60);
		hoverSoundButton = loadImage("HoverSoundButton", 60, 60);
		pressedSoundButton = loadImage("PressedSoundButton", 60, 60);
		winningFrame = loadImage("WinningFrame", 400, 400);
		setProgress(1.0);
	}
	
	public static Image loadImage(String path, double width, double height){
        return new Image(ClassLoader.getSystemResource("image/" + path + ".png").toString(), width, height, true, true);
    }
	
	public static void setProgress(double progress) {
		Images.progress = progress;
	}
	public static double getProgress() {
		return progress;
	}
}
