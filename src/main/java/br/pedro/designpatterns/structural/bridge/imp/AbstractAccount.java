package br.pedro.designpatterns.structural.bridge.imp;

public class AbstractAccount {
	protected Logger logger = new LoggerWarning();
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
}
