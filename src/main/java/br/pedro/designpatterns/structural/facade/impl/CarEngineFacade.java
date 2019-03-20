package br.pedro.designpatterns.structural.facade.impl;

import br.pedro.designpatterns.structural.facade.EngineFacade;

public class CarEngineFacade implements EngineFacade {
	private Weel weels;
	private Acelerator acelerator;
	private March march;
	
	public CarEngineFacade(Weel weels, Acelerator acelerator, March march) {
		super();
		this.weels = weels;
		this.acelerator = acelerator;
		this.march = march;
	}

	public void moveFront() {
		march.chooseMarch(1);
		acelerator.acelerate();
		weels.run();
		
		System.err.println("Finally! Mooving car.");
	}

}
