package com.cloudwick.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsClass {
	
	private static final int NUMTHREADS= 10;


	public static void main(String[] args) throws InterruptedException {
		ExecutorService esObj = Executors.newFixedThreadPool(NUMTHREADS);
		for (int i = 0; i < 500; i++) {
			MyThreadClass obj = new MyThreadClass(1712 + i);
			obj.setName("User "+i);
			esObj.execute(obj);			
		}
		esObj.shutdown();
		while (!esObj.isTerminated()) {
						
		}
		Thread.sleep(5000);		
		System.out.println("All threads have completed.");
	}
}
