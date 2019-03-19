package br.pedro.designpatterns.structural.decorator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.pedro.designpatterns.structural.decorator.impl.Dictionary;
import br.pedro.designpatterns.structural.decorator.impl.DictionaryDecorator;

/**
 * Intent: attach additional responsibilities to an object
 * dynamically.
 * Applicability: Integer, Double and others wrappers.
 * Examples: Stream of data (like OutputStream and FileOutputStream). Also,
 * we can implement a decorator to abstract the use of a Map. Use 
 * decorator.addPerson(name, person) is better than pessoaMap.put(name, person)
 * because the first approach is more readable and we can validate the addition.
 * **/
public class MainDecoratorPattern {

	public static void main(String[] args) {
		startDefaultDecoratorTest();
		startMapDecoratorTest();
	}

	//This example shows how to create a decorator to a map and 
	//override the #put method to verify if the key already has a value
	//before add the tuple. If true, throws a exception.
	private static void startMapDecoratorTest() {
		HashMap<String, Point> map = new HashMap<String, Point>();
		MapDecorator<String, Point> mapDecorator = new MapDecorator<String, Point>(map);
		
		final String name = "Pedro";
		mapDecorator.put(name, new Point());
		
		try {
			mapDecorator.put(name, new Point());
		} catch (IllegalArgumentException exception) {
			System.err.println("Error adding " + name + ": " + exception.getMessage());
		}
	}

	//This is a basic test. Just create a simple class with a list of
	//Strings and use a decorator to change the add behaviour.
	private static void startDefaultDecoratorTest() {
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
