package br.pedro.designpatterns.structural.interpreter.impl;

import java.util.HashMap;
import java.util.Map;

public class FakeWordsMeansMap {
	public static Map<String, Integer> createGenericWordsMeans() {
		Map<String, Integer> genericWordsMeans = new HashMap<>();
		genericWordsMeans.put("one", 1);
		genericWordsMeans.put("two", 2);
		genericWordsMeans.put("three", 3);
		genericWordsMeans.put("four", 4);
		genericWordsMeans.put("five", 5);
		genericWordsMeans.put("six", 6);
		genericWordsMeans.put("seven", 7);
		genericWordsMeans.put("eight", 8);
		genericWordsMeans.put("nine",9);
		
		return genericWordsMeans;
	}
}