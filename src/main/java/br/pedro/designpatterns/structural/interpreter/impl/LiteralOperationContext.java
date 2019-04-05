package br.pedro.designpatterns.structural.interpreter.impl;

public class LiteralOperationContext {
	
	private String literal;
	
	private Integer value;
	
	public LiteralOperationContext(String literal) {
		this.literal = literal;
		this.value = 0;
	}

	public String getLiteral() {
		return literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	public void sumValue(Integer value) {
		this.value += value;
	}
}
