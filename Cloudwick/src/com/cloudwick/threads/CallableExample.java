package com.cloudwick.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	private static final int NUMTHREADS = 10;
	
	public static void main(String[] args) {
		
		ExecutorService esObj =  Executors.newFixedThreadPool(NUMTHREADS);
		List<Future<Long>> list = new ArrayList<Future<Long>>();
		
		for (int i = 0; i < 2000; i++) {
			CallableThread obj =  new CallableThread();
			Future<Long> d = esObj.submit(obj);
			list.add(d);
		}
		
		Long sum = (long) 0;
		System.out.println("Threads "+ list.size());
		for (Future<Long> data : list) {
			try {
				sum += data.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("Sum = "+sum);
			
			esObj.shutdown();	
			
		}
		System.out.println("Sum = "+sum);
		
	}
}
