package br.pedro.designpatterns.structural.interpreter;

import br.pedro.designpatterns.structural.interpreter.impl.EnglishNumberExpressionClient;

/**
 * A interpreter is composed by a tree with terminal (leaf) and non-terminal nodes. Each
 * grammar has a different class and the instances are handled in way to proccess something
 * and give a correct output. In this example we are interpreting expressions like
 * [expression] [signal] [expression]
 * where [expression] is the result of sum of all words. For example, one one one (1 + 1 + 1) is 3.
 * So, [one one one x one one one] gives 9 (3x3) as output.
 * 
 * A interpreter is composed by a client class, a context class and grammar classes and are indicated by 
 * cases of simple grammars. Joshua Kerievsky suggests a number equals or less then 12 grammars in his book
 * Refactoring for Patterns.
 * **/
public class MainInterpreterPattern {

	public static void main(String[] args) {
		startInterpreterExample();
	}

	private static void startInterpreterExample() {
		final String expression1 = "one two three / one two three"; //should return 1
		final String expression2 = "four x two"; //should return 8
		final String expression3 = "two + two"; //should return 4
		final String expression4 = "two - two"; //should return -
		
		EnglishNumberExpressionClient interpreter = new EnglishNumberExpressionClient();
		System.err.println(interpreter.interpret(expression1));
		System.err.println(interpreter.interpret(expression2));
		System.err.println(interpreter.interpret(expression3));
		System.err.println(interpreter.interpret(expression4));
		
	}
}
