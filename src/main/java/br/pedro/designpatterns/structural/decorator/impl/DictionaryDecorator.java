package br.pedro.designpatterns.structural.decorator.impl;

import java.util.List;

//A decorator needs to have the same superclass of decorated instance
public class DictionaryDecorator extends Dictionary{
	
	//The decorated instance
	private Dictionary dictionary;
	
	//make no sense have a instance of this decorator without a instance 
	//of decored instance
	public DictionaryDecorator(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	
	//this is the new behaviour provided by decorator:
	//instead of add just one value per time, we add
	//a lot of strings
	public void add(List<String> terms) {
		for (String term : terms) {
			this.dictionary.add(term);
		}
	}

}
