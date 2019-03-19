package br.pedro.designpatterns.structural.bridge.imp;

public class SimpleAccount extends AbstractAccount{

	private double balance;
	
	public void witdraw(double value) {
		this.balance -= value;
		this.logger.log("witdraw " + value);
	}
	
	public void deposit(double value) {
		this.balance += value;
		this.logger.log("deposit " + value);
	}
	
	public boolean isBalanceLow() {
		return this.balance < 50;
	}
}
