package com.cloudwick.threads;

import java.util.ArrayList;

public class ThreadExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Thread> al = new ArrayList<Thread>();
		for (int i = 0; i < 500; i++) {
			MyThreadClass obj = new MyThreadClass(5505 + i);
			obj.setName("User " + i);
			obj.start();
			al.add(obj);
		}

		int noOfRunningThreads = 0;
		do {
			noOfRunningThreads = 0;
			for (Thread myThread : al) {
				if (myThread.isAlive()) {
					noOfRunningThreads++;
				}
			}
		} while (noOfRunningThreads > 0);
		
		System.out.println("All the threads have completed.");

		

	}

}
