package br.pedro.designpatterns.structural.interpreter.impl;

import java.util.regex.Pattern;

public class MathExpressionInterpreter implements LiteralOperationInterpreter{

	private GeneralExpressionInterpreter left;
	private GeneralExpressionInterpreter right;
	private Signal signal;

	public MathExpressionInterpreter(GeneralExpressionInterpreter left, GeneralExpressionInterpreter right, Signal signal) {
		this.left = left;
		this.right = right;
		this.signal = signal;
	}
	
	@Override
	public void interpret(LiteralOperationContext context) {
		throwExceptionIfExpressionInInvalidFormat(context.getLiteral());
		String literal = context.getLiteral();
		String[] split = literal.split(signal.getLiteral());
		
		LiteralOperationContext leftContext = interpretSideAndReturnContext(split[0].trim(), left);
		LiteralOperationContext rightContext = interpretSideAndReturnContext(split[1].trim(), right);
		
		Integer calculatedValue = calculate(leftContext.getValue(), rightContext.getValue());
		context.setValue(calculatedValue);
	}

	private LiteralOperationContext interpretSideAndReturnContext(String generalExpression, 
			GeneralExpressionInterpreter generalInterpreter) {
		LiteralOperationContext leftContext = new LiteralOperationContext(generalExpression.trim());
		generalInterpreter.interpret(leftContext);
		return leftContext;
	}
	
	private Integer calculate(Integer left, Integer right) {
		Integer result = 0;
		
		if (signal.equals(Signal.SUM)) {
			result = left + right;
		} else if (signal.equals(Signal.SUBTRACTION)) {
			result = left - right;
		} else if (signal.equals(Signal.MULTIPLICATION)) {
			result = left * right;
		} else if (signal.equals(Signal.DIVISION)) {
			result = left / right;
		}
		
		return result;
	}

	private void throwExceptionIfExpressionInInvalidFormat(String literal) {
		String regex = "([a-z]+)\\s" + signal.getLiteral() + "\\s([a-z]+)";
		Pattern pattern = Pattern.compile(regex);
		
		if (!pattern.matcher(literal).find()) {
			throw new IllegalArgumentException("Expression should contains something like [<left> " 
					+ signal + " <right>].");
		}
	}
}
