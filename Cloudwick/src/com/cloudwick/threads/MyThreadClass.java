package com.cloudwick.threads;

public class MyThreadClass extends Thread {

	private int counter;

	public MyThreadClass(int num) {
		counter = num;
	}

	public void run() {
		int sum = 0;
		for (int i = 0; i < counter; i++) {
			sum = sum + i;			
		}
		
		String name = Thread.currentThread().getName();
		System.out.println(name +" : "+sum);
	}

}
