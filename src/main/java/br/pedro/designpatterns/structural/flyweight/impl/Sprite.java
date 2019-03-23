package br.pedro.designpatterns.structural.flyweight.impl;

import java.awt.Point;

public class Sprite implements SpriteFlyweight {

	private Image image;
	
	public Sprite(String imageName) {
		this.image = new Image(imageName);
	}

	@Override
	public void draw(Point point) {
		System.err.println("Drawing " + image.imageName + " in posix " + point);
	}

}
