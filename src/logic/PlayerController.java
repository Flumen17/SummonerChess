package logic;

import java.util.ArrayList;
import java.util.List;

import Object.Flag;
import Object.Tower;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.hero.Summoner;
import javafx.scene.paint.Color;

public class PlayerController {
	
	private List<Hero> heroes;
	private Color color;
	private Summoner summoner;
	private Hero selectedHeroToMove, selectedSacrifice;
	private HeroType selectedHeroToSummon;
	private Flag flag;
	private Tower tower;
		
	public PlayerController(int x, int y, Color color) {
		heroes = new ArrayList<Hero>();
		this.color = color;
		summoner = new Summoner(x, y, color);
		heroes.add(summoner);
		this.flag = null;
		this.tower = null;
	}
	
	public void setInitial() {
		selectedHeroToMove = null;
		selectedSacrifice = null;
		selectedHeroToSummon = null;
	}
	
	public void summonHero(int x, int y) {
		Hero hero = selectedHeroToSummon.toHero(x, y, color);
		heroes.add(hero);
	}
	
	public Summoner getSummoner() {
		return summoner;
	}
	
	public List<Hero> getHeroes() {
		return heroes;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Hero getSelectedHeroToMove() {
		return selectedHeroToMove;
	}
	
	public HeroType getSelectedHeroToSummon() {
		return selectedHeroToSummon;
	}
	
	public Hero getSelectedSacrifice() {
		return selectedSacrifice;
	}
	
	public void setSelectedHeroToMove(Hero selectedHeroToMove) {
		this.selectedHeroToMove = selectedHeroToMove;
	}
	
	public void setSelectedSacrifice(Hero selectedSacrifice) {
		this.selectedSacrifice = selectedSacrifice;
	}
	
	public void setSelectedHeroToSummon(HeroType heroType) {
		this.selectedHeroToSummon = heroType;
	}
	
	public void setFlag(int x, int y) {
		flag = new Flag(x, y, color);
	}
	
	public void setTower(int x, int y) {
		tower = new Tower(x, y, color);
	}
	
	public Flag getFlag() {
		return flag;
	}
	
	public Tower getTower() {
		return tower;
	}

}
