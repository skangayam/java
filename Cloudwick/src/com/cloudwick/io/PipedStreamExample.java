package com.cloudwick.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamExample {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PipedOutputStream pout = new PipedOutputStream();
		PipedInputStream pin = new PipedInputStream();
		
		pin.connect(pout);
		pout.write(1);
		pout.write(2);
		pout.write(3);
		for (int i = 0; i < 3; i++) {
			System.out.println((int)pin.read());			
		}
		pin.close();

	}

}
