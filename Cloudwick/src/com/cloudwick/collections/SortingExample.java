package com.cloudwick.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortingExample {

	private List<String> cityList;

	private void sortList() {

		cityList = new ArrayList<String>();
		cityList.add("F");
		cityList.add("M");
		cityList.add("A");
		Collections.sort(cityList);

		Iterator<String> iterator = cityList.iterator();
		while (iterator.hasNext()) {
			String data = (String) iterator.next();
			System.out.println(data);

		}
	}

	private void customSorting() {
		User u = new User();
		u.setName("F");
		u.setAge(24);

		User u2 = new User();
		u.setName("H");
		u2.setAge(36);

		List userList = new ArrayList();
		userList.add(u);
		userList.add(u2);

		System.out.println("\nSorting the User objects");
		Collections.sort(userList);

		Iterator<User> iterator2 = userList.iterator();
		while (iterator2.hasNext()) {
			User user = (User) iterator2.next();
			System.out.println(user.getAge());

		}

	}

	public static void main(String[] args) {
		SortingExample obj = new SortingExample();
		obj.sortList();
		obj.customSorting();

	}

}
