package br.pedro.designpatterns.structural.facade;

import br.pedro.designpatterns.structural.facade.impl.Acelerator;
import br.pedro.designpatterns.structural.facade.impl.CarEngineFacade;
import br.pedro.designpatterns.structural.facade.impl.March;
import br.pedro.designpatterns.structural.facade.impl.Weel;

/**
 * Intent: Decouple a lot of dependencies of a class inside just one, providing a interface
 * to access services of a module or a system.
 * Motivation: A facade is a composition of others instances orchestred by a class (the facade itself)
 * to provide services. We make implicity use this pattern a lot of times in development. Clients that
 * uses a facade have no necessity to access subsystem classes.
 * 
 * **/
public class MainFacadePattern {

	public static void main(String[] args) {
		startFacadeExample();
	}

	private static void startFacadeExample() {
		Weel weel = new Weel();
		Acelerator acelerator = new Acelerator();
		March march = new March();
		
		EngineFacade carEngine = new CarEngineFacade(weel, acelerator, march);
		carEngine.moveFront();
	}
}
