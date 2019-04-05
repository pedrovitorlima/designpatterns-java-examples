package br.pedro.designpatterns.structural.interpreter.impl;

import java.util.List;

import br.pedro.designpatterns.structural.interpreter.impl.builder.WordInterpreterBuilder;

public class EnglishNumberExpressionClient {

	public String interpret(String expression) {
		WordInterpreterBuilder wordsInterpreterBuilder = new WordInterpreterBuilder();
		List<WordInterpreter> listOfInterpreters = wordsInterpreterBuilder.add("one", 1)
			.add("two", 2)
			.add("three", 3)
			.add("four", 4)
			.add("five", 5)
			.add("six", 6)
			.add("seven", 7)
			.add("eight", 8)
			.add("nine", 9)
			.getListOfInterpreters();
		
		GeneralExpressionInterpreter generalInterpreter = new GeneralExpressionInterpreter(listOfInterpreters);
		MathExpressionInterpreter mathInterpreter = new MathExpressionInterpreter(generalInterpreter, 
				generalInterpreter, getSignal(expression));
		LiteralOperationContext context = new LiteralOperationContext(expression);
		mathInterpreter.interpret(context);

		return "Result of [" + expression + "] is " + context.getValue();
	}

	private Signal getSignal(String expression) {
		for (Signal signal : Signal.values()) {
			if (expression.contains(signal.toString())) {
				return signal;
			}
		}
		throw new IllegalArgumentException("Expression should have a operation signal (+, -, / or x).");
	}
}
