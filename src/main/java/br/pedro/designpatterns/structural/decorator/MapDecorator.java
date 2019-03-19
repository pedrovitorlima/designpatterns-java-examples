package br.pedro.designpatterns.structural.decorator;

import java.util.HashMap;
import java.util.Map;

public class MapDecorator<String, J> extends HashMap<String, J>{
	
	private Map<String, J> map;
	
	public MapDecorator(Map<String, J> map) {
		this.map = map;
	}

	@Override
	public J put(String key, J value) {
		if (map.get(key) != null) {
			throw new IllegalArgumentException("The key " + key + " already has a value.");
		}
		return this.map.put(key, value);
	}
}
