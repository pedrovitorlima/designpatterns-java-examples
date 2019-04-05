package br.pedro.designpatterns.structural.interpreter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import br.pedro.designpatterns.structural.interpreter.impl.builder.WordInterpreterBuilder;

@RunWith(JUnitPlatform.class)
class MathExpressionInterpreterTest {

	@Test
	void testInterpreterShouldThrowExceptionIfExpressionNotHaveLeftAndRightSubExpressions() {
		final String expressionWithoutLeftAndRight = "one three for";
		MathExpressionInterpreter interpreter = createDefaultInterpreter(Signal.SUM);
		LiteralOperationContext context = new LiteralOperationContext(expressionWithoutLeftAndRight);
		
		Exception throwed = assertThrows(IllegalArgumentException.class, () -> interpreter.interpret(context));
		assertEquals("Expression should contains something like [<left> + <right>].", throwed.getMessage());
	}
	
	@TestFactory
	Stream<DynamicTest> testInterpretShouldInterpretCorrectly() {
		List<LiteralOperationContext> contexts = Arrays.asList(
				new LiteralOperationContext("one two three + two three four"),
				new LiteralOperationContext("one two three / one two three"),
				new LiteralOperationContext("two x two"));
		
		List<Signal> signals = Arrays.asList(
				Signal.SUM, 
				Signal.DIVISION, 
				Signal.MULTIPLICATION);
		
		List<Integer> expectedValues = Arrays.asList(
				15, 
				1, 
				4);
		
		return contexts.stream().map(context -> DynamicTest.dynamicTest("Resolving " + context.getLiteral(), () -> {
			int index = contexts.indexOf(context);
			
			MathExpressionInterpreter interpreter = createDefaultInterpreter(signals.get(index));
			interpreter.interpret(context);
			
			
			assertEquals(expectedValues.get(index), context.getValue());
		}));
	}
	
	public MathExpressionInterpreter createDefaultInterpreter(Signal signal) {
		List<WordInterpreter> wordsInterpretation = WordInterpreterBuilder.getWordsToEnglishNumbers();
		
		GeneralExpressionInterpreter left = new GeneralExpressionInterpreter(wordsInterpretation);
		GeneralExpressionInterpreter right = new GeneralExpressionInterpreter(wordsInterpretation);
		
		return new MathExpressionInterpreter(left, right, signal);
	}

}
