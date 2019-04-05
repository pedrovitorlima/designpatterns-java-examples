package br.pedro.designpatterns.structural.interpreter.impl;

public enum Signal {
	SUM("\\+"), SUBTRACTION("-"), MULTIPLICATION("x"), DIVISION("\\/");
	
	private String literal;
	
	private Signal(String literal) {
		this.literal = literal;
	}
	
	public String getLiteral() {
		return this.literal;
	}
	
	@Override
	public String toString() {
		return getLiteral().replace("\\", "");
	}
}
