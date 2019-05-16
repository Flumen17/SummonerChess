package heroBase.hero;

import Object.Tower;
import constant.Images;
import field.cell.Cell;
import heroBase.FireBase;
import heroBase.Hero;
import heroBase.HeroType;
import heroBase.PlantBase;
import heroBase.hybridHero.PlantWater;
import heroBase.property.Sacrifice;
import heroBase.property.SpreadMoveable;
import heroBase.superHero.SuperPlant;
import javafx.scene.paint.Color;
import main.Main;

public class Plant extends PlantBase implements SpreadMoveable, Sacrifice {
	
	public Plant(int x, int y, Color color) {
		super(x, y, color);
		this.type = HeroType.PLANT;
		if(color == Color.BLACK)this.image = Images.plant_BG;
		else this.image = Images.plant_WG;
	}

	@Override
	public boolean canMove(int x, int y) {
		Cell cell = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
		if(cell.getType() == Cell.Type.OUTFIELD){
			return false;
		}
		if(cell.getTower() != null || cell.getHero() != null) {
			return false;
		}
		if(cell.getFlag() != null && this.getFlag() != null) {
			return false;
		}
		return canMoveSpread(x, y);
	}

	@Override
	public boolean canKill(int x, int y) {
		Tower tower = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getTower();
		Hero hero = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y).getHero();
		if(hero == null && tower == null) {
			return false;
		}
		if(hero != null && (hero instanceof FireBase || hero instanceof SuperPlant || hero instanceof PlantWater)) {
			return false;
		}
		if(this.getFlag() != null && hero.getFlag() != null) {
			return false;
		}
		return canKillSpread(x, y);
	}

	@Override
	public boolean canMoveSpread(int x, int y) {
		for(int i = -1; i <= 1; i += 2) {
			for(int j = -2; j <= 2 ; j += 4) {
				if(((x == this.getRow() + j) && (y == this.getCol() + i) ) || ((x == this.getRow() + i) && (y == this.getCol() + j))) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean canKillSpread(int x, int y) {
		Cell cell = Main.gameScene.getGamePart().getLogicPane().getCellAt(x, y);
		if (cell.getType() == Cell.Type.OUTFIELD) {
			return false;
		}
		if(cell.getHero() != null) {
			for(int i = -1; i <= 1; i += 2) {
				for(int j = -2; j <= 2 ; j += 4) {
					if(((x == this.getRow() + j) && (y == this.getCol() + i) ) || ((x == this.getRow() + i) && (y == this.getCol() + j) )) {
						if (cell.getHero().getColor() != this.getColor()) {
							return true;
						}
					}
				}
			}
		}
		else if(cell.getTower() != null) {
			for(int i = -1; i <= 1; i += 2) {
				for(int j = -2; j <= 2 ; j += 4) {
					if(((x == this.getRow() + j) && (y == this.getCol() + i) ) || ((x == this.getRow() + i) && (y == this.getCol() + j) )) {
						if (cell.getTower().getColor() != this.getColor()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean canBeSacrifice(HeroType heroType) {
		return heroType == HeroType.SUPERPLANT || heroType == HeroType.PLANTWATER || heroType == HeroType.FIREPLANT;
	}

	@Override
	public boolean canBeSacrifice(HeroType heroType1, HeroType heroType2) {
		if(heroType2 == HeroType.FIRE && heroType1 == HeroType.FIREPLANT) {
			return true;
		}
		else if(heroType2 == HeroType.WATER && heroType1 == HeroType.PLANTWATER) {
			return true;
		}
		else if(heroType2 == HeroType.PLANT && heroType1 == HeroType.SUPERPLANT) {
			return true;
		}
		return false;
	}

}