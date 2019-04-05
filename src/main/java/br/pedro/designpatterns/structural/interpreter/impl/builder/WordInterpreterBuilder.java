package br.pedro.designpatterns.structural.interpreter.impl.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.pedro.designpatterns.structural.interpreter.impl.WordInterpreter;

public class WordInterpreterBuilder {

	private List<WordInterpreter> listOfInterpreters;
	
	public WordInterpreterBuilder() {
		this.listOfInterpreters = new ArrayList<>();
	}
	
	public WordInterpreterBuilder add(final String word, final Integer howMuchValue) {
		this.listOfInterpreters.add(new WordInterpreter(word, howMuchValue));
		return this;
	}
	
	public List<WordInterpreter> getListOfInterpreters() {
		List<WordInterpreter> listToReturn = this.listOfInterpreters;
		this.listOfInterpreters = new ArrayList<>();
		return listToReturn;
	}
	
	public static List<WordInterpreter> getWordsToEnglishNumbers() {
		return Arrays.asList(new WordInterpreter("one", 1),
				new WordInterpreter("two", 2),
				new WordInterpreter("three", 3),
				new WordInterpreter("four", 4),
				new WordInterpreter("five", 5),
				new WordInterpreter("six", 6),
				new WordInterpreter("seven", 7),
				new WordInterpreter("eight", 8),
				new WordInterpreter("nine", 9));
	}
}
