package br.pedro.designpatterns.structural.interpreter.impl;

public class WordInterpreter implements LiteralOperationInterpreter {

	private String word;
	private Integer wordMeans;
	
	public WordInterpreter(String word, Integer wordMeans) {
		this.word = word;
		this.wordMeans = wordMeans;
	}

	@Override
	public void interpret(LiteralOperationContext context) {
		if (word.equals(context.getLiteral())) {
			final Integer actualValue = context.getValue();
			context.setValue(actualValue + this.wordMeans);
		}
	}

}
