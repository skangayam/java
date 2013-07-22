package com.cloudwick.io;

import java.util.Scanner;

public class ScannerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Please enter your name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Hello "+ name);
		
		System.out.println("Please enter your age: ");
		int age = sc.nextInt();
		System.out.println("AGE: "+age);		
		
		sc.close();

	}

}
