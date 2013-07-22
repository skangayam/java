package com.cloudwick.io;

import java.io.Console;
import java.util.Scanner;

public class ConsoleExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Console c = System.console();
		if (c != null) {
			System.out.println("Please enter your name: ");
			Scanner s = new Scanner(c.reader());
			while (s.hasNext()) {
				String name = (String) s.next();
				System.out.println("NAME: " + name);
			}
			s.close();
		}
	}

}
