package br.pedro.designpatterns.structural.flyweight.impl;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
	
	private static FlyweightFactory instance;
	
	private Map<SpritesEnum, SpriteFlyweight> sprites;
	
	private FlyweightFactory() {
		sprites = new HashMap<SpritesEnum, SpriteFlyweight>();
		
		sprites.put(SpritesEnum.GAMER, new Sprite("gamer.jpg"));
		sprites.put(SpritesEnum.PLAYER, new Sprite("player.jpg"));
		sprites.put(SpritesEnum.CENARIO, new Sprite("cenario.jpg"));
		sprites.put(SpritesEnum.PORTAL, new Sprite("portal.jpg"));
		sprites.put(SpritesEnum.DOOR, new Sprite("door.jpg"));
	}
	
	public SpriteFlyweight getFlyweight(SpritesEnum player) {
		return sprites.get(player);
	}
	
	public static FlyweightFactory getInstance() {
		if (instance == null) {
			instance = new FlyweightFactory();
		}
		return instance;
	}

}
