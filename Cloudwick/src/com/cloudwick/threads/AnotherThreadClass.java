package com.cloudwick.threads;

public class AnotherThreadClass extends Thread {
	private Resource obj;

	public AnotherThreadClass(Resource a, String name) {
		super(name);
		this.obj = a;
	}
	
	public void run(){
		obj.lock();		
	}

}
