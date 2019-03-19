package br.pedro.designpatterns.structural.decorator;

import java.util.ArrayList;
import java.util.List;

import br.pedro.designpatterns.structural.decorator.impl.Dictionary;
import br.pedro.designpatterns.structural.decorator.impl.DictionaryDecorator;

/**
 * Intent: attach additional responsibilities to an object
 * dynamically.
 * Applicability: Integer, Double and others wrappers.
 * Examples: 
 * **/
public class MainDecoratorPattern {

	public static void main(String[] args) {
		startDecoratorTest();
	}

	private static void startDecoratorTest() {
		Dictionary dictionary = new Dictionary();
		DictionaryDecorator decorator = new DictionaryDecorator(dictionary);
		
		List<String> lotOfnumbers = createListWithTenNumbersAsString();
		decorator.add(lotOfnumbers);
		
		dictionary.print();
		
	}

	private static List<String> createListWithTenNumbersAsString() {
		List<String> lotOfnumbers = new ArrayList<>();
		for (int index=0; index < 10; index++) {
			lotOfnumbers.add(Integer.toString(index));
		}
		return lotOfnumbers;
	}
}
