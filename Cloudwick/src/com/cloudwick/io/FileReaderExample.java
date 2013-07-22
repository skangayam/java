package com.cloudwick.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderExample {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public void readFileContent(String filename) throws IOException
	{ 
		BufferedReader br = new BufferedReader(new FileReader(filename), 100);
		String s = null;
		while ((s=br.readLine()) != null) {
			System.out.println(s);			
		}
		br.close();		
	}
	
	public void writeFileContent(String filename) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename), 100);
		String city = "Fremont \n";
		String state = "CA \n";
		String zip = "94538 \n";
		
		bw.write(city);		
		bw.write(state);
		bw.write(zip);
		bw.flush();
		bw.close();	
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReaderExample obj = new FileReaderExample();
		obj.writeFileContent("FileReaderExample.txt");
		obj.readFileContent("FileReaderExample.txt");
	}

}
