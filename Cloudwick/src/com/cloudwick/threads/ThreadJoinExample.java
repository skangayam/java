package com.cloudwick.threads;

public class ThreadJoinExample {


	public static void main(String[] args) {
		System.out.println("Thread started: "+Thread.currentThread().getName());
		
		Thread t = new Thread(){
			public void run()
			{
				System.out.println("Thread started: "+Thread.currentThread().getName());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Thread completed: "+Thread.currentThread().getName());
			}
		};
		
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread completed: "+Thread.currentThread().getName());

	}
}
