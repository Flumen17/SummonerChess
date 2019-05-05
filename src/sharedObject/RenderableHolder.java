package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> gameObjects;
	private Comparator<IRenderable> comparator;
	
	public RenderableHolder() {
		gameObjects = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2)->{
			if(o1.getZ() < o2.getZ()) {
				return -1;
			}
			return 1;
		};
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}
	
	public void add(IRenderable gameObject) {
		gameObjects.add(gameObject);
		Collections.sort(gameObjects, comparator);
	}

	public List<IRenderable> getGameObjects(){
		return gameObjects;
	}
	
}
