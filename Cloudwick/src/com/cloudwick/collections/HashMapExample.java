package com.cloudwick.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	private Map<Integer, String> nameMap;

	private void populateMap() {
		nameMap = new HashMap<Integer, String>();
		nameMap.put(1, "Fremont");
		nameMap.put(2, "Milpitas");
		nameMap.put(3, "Hayward");
		nameMap.put(4, "Hayward");
		nameMap.put(4, "Newark");

		/*
		 * Values can be duplicate. Keys cannot be duplicate. So, the Value of
		 * Hayward is overwritten with Newark for key 4
		 */
	}

	private void displayMapbyValue() {
		System.out.println("\nDisplaying Values");
		Collection<String> nVal = nameMap.values();
		Iterator<String> iterator = nVal.iterator();
		while (iterator.hasNext()) {
			String data = (String) iterator.next();
			System.out.println(data);
		}

	}

	private void displayMapByKey() {
		System.out.println("\nDisplaying Values using Keys");
		Set<Integer> nKey = nameMap.keySet();
		Iterator<Integer> iterator = nKey.iterator();
		while (iterator.hasNext()) {
			Integer key = (Integer) iterator.next();
			System.out.println(key + " " + nameMap.get(key));

		}
	}

	private void displayMapByEntry() {
		System.out.println("\nDisplaying Entries");
		Set<Entry<Integer, String>> set = nameMap.entrySet();
		Iterator<Entry<Integer, String>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator
					.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

	public static void main(String[] args) {
		HashMapExample obj = new HashMapExample();
		obj.populateMap();
		obj.displayMapbyValue();
		obj.displayMapByKey();
		obj.displayMapByEntry();

	}

}
