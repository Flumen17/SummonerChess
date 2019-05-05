package heroBase.property;

import heroBase.HeroType;

public interface Sacrifice {
	
	public boolean canBeSacrifice(HeroType heroType); 
	public boolean canBeSacrifice(HeroType heroType1, HeroType heroType2);
	
}
