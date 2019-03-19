package br.pedro.designpatterns.structural.composite;

import br.pedro.designpatterns.structural.composite.impl.CompositeHTML;
import br.pedro.designpatterns.structural.composite.impl.Div;
import br.pedro.designpatterns.structural.composite.impl.H1;
import br.pedro.designpatterns.structural.composite.impl.Span;

/**
 * Intent: composite objects into a tree to represents a part-whole hierarchies.
 * Applicability: clients to ignore differences between compositions of objects and 
 * individual objects
 * Examples: Graphic applications, a validation with many rules with any rule inside 
 * a different class.
 * **/
public class MainCompositePattern {

	public static void main(String[] args) {
		startCompositeTest();
	}

	private static void startCompositeTest() {
		CompositeHTML htmlDocument = new CompositeHTML();
		htmlDocument.add(new Div());
		htmlDocument.add(new Span());
		htmlDocument.add(new H1());
		
		htmlDocument.print();
	}
}
