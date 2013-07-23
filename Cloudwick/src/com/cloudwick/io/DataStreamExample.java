package com.cloudwick.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamExample {
	

	public void writePrimitive(String filename) throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
		for (int i = 0; i < 25; i++) {
			out.writeInt(i);
			out.writeChar('\n');
		}
		out.close();
	}

	public void readPrimitive(String filename) throws IOException {
		DataInputStream in = new DataInputStream(new FileInputStream(filename));
		try {
			while (true) {
				int i = in.readInt();
				in.readChar();
				System.out.println(String.valueOf(i));
			}

		} catch (EOFException e) {
			// TODO: handle exception
		}
		in.close();

	}

	public static void main(String[] args) throws IOException {
		DataStreamExample obj = new DataStreamExample();
		obj.writePrimitive("DataStreamExample.txt");
		obj.readPrimitive("DataStreamExample.txt");
	}

}
