package br.pedro.designpatterns.structural.flyweight;

import java.awt.Point;

import br.pedro.designpatterns.structural.flyweight.impl.FlyweightFactory;
import br.pedro.designpatterns.structural.flyweight.impl.SpritesEnum;

/**
 * Intent: Use share to support efficiently large numbers of 
 * fine-granned objects efficiently.
 * Example: Load and draw a big number of images on screen without 
 * create new instances of it
 * **/
public class MainFlyweightPattern {

	public static void main(String[] args) {
		startFlyweightTest();
	}

	private static void startFlyweightTest() {
		FlyweightFactory factory = FlyweightFactory.getInstance();
		
		//An iteration of 1000 but we have only one Sprite instance for each
		//enum
		for (int i=0; i < 1000; i++) {
			//This is a violation of Demeter's Law, but is just a example
			factory.getFlyweight(SpritesEnum.PLAYER).draw(new Point(1,2));
			factory.getFlyweight(SpritesEnum.CENARIO).draw(new Point(2,2));
			factory.getFlyweight(SpritesEnum.DOOR).draw(new Point(3,2));
			factory.getFlyweight(SpritesEnum.PORTAL).draw(new Point(4,20));
		}
	}
}
