package br.pedro.designpatterns.structural.interpreter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import br.pedro.designpatterns.structural.interpreter.impl.builder.WordInterpreterBuilder;

@RunWith(JUnitPlatform.class)
class GeneralExpressionInterpreterTest {

	private GeneralExpressionInterpreter interpreter;

	@BeforeEach
	public void setup() {
		this.interpreter = new GeneralExpressionInterpreter(WordInterpreterBuilder.getWordsToEnglishNumbers());
	}
	
	@Test
	void testInterpretShouldReturnCorrectValue() {
		final String expression = "one seven six nine";
		final Integer value = 23;
		
		LiteralOperationContext context = new LiteralOperationContext(expression);
		context.setLiteral(expression);
		interpreter.interpret(context);
		
		assertEquals(value, context.getValue());
	}
	
	@Test
	void testInterpretShouldThrowExceptionIfNotUnderstandValue() {
		final String expression = "eleven";
		LiteralOperationContext context = new LiteralOperationContext(expression);
		
		Exception throwed = assertThrows(IllegalArgumentException.class, () -> this.interpreter.interpret(context));
		assertEquals("\""+expression+"\" was not recognized.", throwed.getMessage());
	}

}
