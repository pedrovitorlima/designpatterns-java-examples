package br.pedro.designpatterns.structural.decorator.impl;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

	private List<String> terms;
	
	public Dictionary() {
		this.terms = new ArrayList<String>();
	}
	
	public void add(String term) {
		terms.add(term);
	}
	
	public void print() {
		System.out.println("Printing added terms:");
		for (String term : terms) {
			System.out.println(term);
		}
	}
}
