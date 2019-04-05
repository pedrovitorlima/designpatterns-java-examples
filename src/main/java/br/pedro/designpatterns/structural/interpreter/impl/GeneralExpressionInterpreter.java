package br.pedro.designpatterns.structural.interpreter.impl;

import java.util.List;

public class GeneralExpressionInterpreter implements LiteralOperationInterpreter{
	
	private List<WordInterpreter> wordsInterpretation;

	public GeneralExpressionInterpreter(List<WordInterpreter> wordsInterpretation) {
		this.wordsInterpretation = wordsInterpretation;
	}
	
	@Override
	public void interpret(LiteralOperationContext context) {
		final String SPACE = " ";
		
		String literal = context.getLiteral();
		for (String token : literal.split(SPACE)) {
			context.sumValue(interpretWord(token));
		}
	}

	private Integer interpretWord(String token) {
		for (WordInterpreter interpreter : wordsInterpretation) {
			LiteralOperationContext context = new LiteralOperationContext(token);
			interpreter.interpret(context);
			if (context.getValue() != 0) {
				return context.getValue();
			}
		}
		
		throw new IllegalArgumentException("\"" + token + "\" was not recognized.");
	}
}
