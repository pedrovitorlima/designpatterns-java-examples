package br.pedro.designpatterns.structural.composite.impl;

import java.util.ArrayList;
import java.util.List;

public class CompositeHTML implements IHTMLElement{

	private List<IHTMLElement> chieldElements;
	
	public CompositeHTML() {
		this.chieldElements = new ArrayList<IHTMLElement>();
	}
	
	public void print() {
		for (IHTMLElement element : this.chieldElements) {
			element.print();
		}
	}
	
	public void add(IHTMLElement newElement) {
		this.chieldElements.add(newElement);
	}
	
	public void remove(IHTMLElement elementToRemove) {
		this.chieldElements.remove(elementToRemove);
	}

}
