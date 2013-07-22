package com.cloudwick.collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	Queue<String> nameQueue;
	Deque<String> nameDeque;
	

	private void populateQueue() {
		/*
		 * Queue is an interface and we cannot create an object.
		 * */
		nameQueue = new LinkedList<String>();
		nameQueue.add("F");
		nameQueue.add("G");
		nameQueue.add("R");
		
		nameDeque = new LinkedList<String>();
		nameDeque.add("F");
		nameDeque.add("G");
		nameDeque.add("R");
	}

	private void displayQueue() {
		System.out.println("Queue Operations");
		System.out.println("Peek: "+nameQueue.peek());
		System.out.println("Size: "+nameQueue.size());
		
		System.out.println("");
		System.out.println("Poll: "+nameQueue.poll());
		System.out.println("Size: "+nameQueue.size());
		
		System.out.println("");
		System.out.println("Peek: "+nameQueue.peek());
		System.out.println("Size: "+nameQueue.size());
		
		System.out.println("\nDeque Operations");
		System.out.println("Peek first: "+nameDeque.peekFirst());
		System.out.println("Size: "+nameDeque.size());
		
		System.out.println("");
		System.out.println("Peek last: "+nameDeque.peekLast());
		System.out.println("Size: "+nameDeque.size());
		
		System.out.println("");
		System.out.println("Poll first: "+nameDeque.pollFirst());
		System.out.println("Size: "+nameDeque.size());
		
		System.out.println("");
		System.out.println("Peek: "+nameDeque.peek());
		System.out.println("Size: "+nameDeque.size());
		
		System.out.println("");
		System.out.println("Poll last: "+nameDeque.pollLast());
		System.out.println("Size: "+nameDeque.size());
	}

	public static void main(String[] args) {
		QueueExample obj =  new QueueExample();
		obj.populateQueue();
		obj.displayQueue();
	}

}
