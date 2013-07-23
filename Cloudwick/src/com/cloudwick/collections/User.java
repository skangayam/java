package com.cloudwick.collections;

public class User implements Comparable<User> {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(User u) {
		int age2 = u.getAge();
		//ascending order
		return this.age - age2;
		
		//descending order
		//return age2 - this.age;
	}



}
