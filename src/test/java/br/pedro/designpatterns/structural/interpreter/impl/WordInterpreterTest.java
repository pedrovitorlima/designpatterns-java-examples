package br.pedro.designpatterns.structural.interpreter.impl;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class WordInterpreterTest {

	@Test
	void testInterpretShouldTranslateCorrectly() {
		final String word = "one";
		final Integer mean = 1;
		
		LiteralOperationContext context = defineWordAndReturnHisInterpretation(word, mean);
		assertEquals(mean, context.getValue());
	}

	private LiteralOperationContext defineWordAndReturnHisInterpretation(final String word, final Integer mean) {
		WordInterpreter wordInterpreter = new WordInterpreter(word, mean);
		LiteralOperationContext context = new LiteralOperationContext(word);
		wordInterpreter.interpret(context);
		return context;
	}
}
