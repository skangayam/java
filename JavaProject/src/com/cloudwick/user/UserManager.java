package com.cloudwick.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cloudwick.bean.User;
import com.cloudwick.exception.InvalidUserException;

public class UserManager {

	private Map<Integer, User> userMap;
	private List<User> userList;

	public void populateHashMap() throws NumberFormatException, IOException,
			InvalidUserException {

		userMap = new HashMap<Integer, User>();

		BufferedReader br = new BufferedReader(new FileReader("user.txt"), 100);
		String s = null;
		while ((s = br.readLine()) != null) {
			String[] arr = s.split(",");

			if (arr.length < 4) {
				InvalidUserException exObj = new InvalidUserException(
						"Bad data for user");
				exObj.setFirstname(arr[1]);
				exObj.setLastname(arr[2]);
				throw exObj;
			}

			int id = Integer.parseInt(arr[0]);
			String firstname = arr[1];
			String lastname = arr[2];
			int age = Integer.parseInt(arr[3]);

			User obj = new User();
			obj.setId(id);
			obj.setFirstname(firstname);
			obj.setLastname(lastname);
			obj.setAge(age);

			userMap.put(id, obj);
		}
		br.close();
	}

	public void populateArrayList() {

		userList = new ArrayList<User>();

		Set<Integer> nKey = userMap.keySet();
		Iterator<Integer> iterator = nKey.iterator();
		while (iterator.hasNext()) {
			Integer key = (Integer) iterator.next();
			User userObj = (User) userMap.get(key);

			if (userObj.getAge() > 30) {
				userList.add(userObj);
			}
		}
	}

	public void displayList() {
		System.out.println("\nPeople with age > 30");

		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			User userObj = (User) iterator.next();
			System.out.println(userObj.getId() + " " + userObj.getFirstname()
					+ " " + userObj.getLastname() + " " + userObj.getAge());
		}

	}

	public void sortList() {
		
		Collections.sort(userList);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException, InvalidUserException {
		UserManager obj = new UserManager();
		obj.populateHashMap();
		obj.populateArrayList();
		obj.displayList();
		
		obj.sortList();
		obj.displayList();

	}

}
