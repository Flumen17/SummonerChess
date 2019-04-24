package logic;

import java.util.ArrayList;
import java.util.List;

import hero.Love;
import hero.Summoner;
import hero.base.Hero;
import hero.base.HeroType;
import javafx.scene.paint.Color;
import javafx.util.Pair;

public class PlayerControl {
	private List<Hero> heroes;
	private Color color;
	private Summoner summoner;
	private int numFire, numWater, numPlant, numLove;
	public PlayerControl(int x, int y, Color color) {
		heroes = new ArrayList<Hero>();
		numFire = 0;
		numWater = 0;
		numPlant = 0;
		numLove = 1;
		this.color = color;
		summoner = new Summoner(x, y, color);
		heroes.add(summoner);
		
	}
	public void summonHero(HeroType heroType) {
		
	}
	public Summoner getSummoner() {
		return summoner;
	}
}
