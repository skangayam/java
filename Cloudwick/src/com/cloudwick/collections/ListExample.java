package com.cloudwick.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListExample {
	private List<String> nameList;

	private void populateList() {
		nameList = new ArrayList<String>();
		nameList.add("Fremont");
		nameList.add("Union city");
		nameList.add("Hayward");
		nameList.add("Milpitas");
	}

	private void deleteElement(int counter) {
		System.out.println("Removing element at index "+ counter);
		nameList.remove(counter);
				
	}

	private void displayList() {
		System.out.println("\ntraversing using enhanced for loop.");
		for (String data : nameList) {
			System.out.println(data);			
		}
		
		System.out.println("\ntraversing using iterator");
		Iterator<String> iterator = nameList.iterator();
		while (iterator.hasNext()) {
		//	nameList.add("some string"); //ConcurrentModificationException. We cannot modify a list within an iterator
			String data = (String) iterator.next();
			System.out.println(data);			
		}
		
		System.out.println("\ntraversing using ListIterator");
		ListIterator<String> iterator2 = nameList.listIterator(); //this has an additional method previous. and hasprevious.
		while (iterator2.hasNext()) {
			String data = (String) iterator2.next();
			System.out.println(data);
		}
		
		
	}

	public static void main(String[] args) {
		
		ListExample obj = new ListExample();
		obj.populateList();
		obj.displayList();
		System.out.println("___________");
		obj.deleteElement(0);
		obj.displayList();

	}

}
