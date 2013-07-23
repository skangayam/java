package com.cloudwick.threads;

public class SynchronizedExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Resource obj = new Resource();
		AnotherThreadClass a = new AnotherThreadClass(obj, "one");
		a.start();
		
		AnotherThreadClass b = new AnotherThreadClass(obj, "two");
		b.start();
		
		AnotherThreadClass c = new AnotherThreadClass(obj, "three");
		c.start();

	}

}
