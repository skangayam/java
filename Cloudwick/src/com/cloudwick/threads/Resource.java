package com.cloudwick.threads;

public class Resource {
	public synchronized void lock(){
		System.out.println(Thread.currentThread().getName()+" has the lock");
		
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" released the lock");
	}

}
