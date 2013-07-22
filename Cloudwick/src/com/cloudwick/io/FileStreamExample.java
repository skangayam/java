package com.cloudwick.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamExample {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public void readFile(String filename) throws IOException
	{
		File f =  new File(filename);
		if (f.exists() && f.length() > 0) {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f), 100);
			try {
				int b;
				while ((b = bis.read()) != -1) {
					System.out.println((char)b);
				}
				
			} catch (EOFException e) {
				// TODO: handle exception
			}
			
			
		}
		
	}
	
	public void writeFile(String filename) throws IOException
	{
		File f = new File(filename);
		if (f.exists()) {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f),100);
			String s = "Some random text. Some random text. Some random text. Some random text. Some random text. ";
			byte b[] = s.getBytes();
			bos.write(b);
			bos.flush();
			bos.close();
		}
	}
	
	public void createFile(String filename) throws IOException
	{
		File f = new File(filename);
		if (f.exists()) {
			System.out.println("Sorry file "+filename+" already exists");
			
		} else {
			System.out.println("Creating new file");
			f.createNewFile();
		}
		
	}
	
	public static void main(String[] args) throws IOException, InvalidFundException {
		FileStreamExample obj = new FileStreamExample();
		obj.createFile("FileStreamExample.txt");
		obj.writeFile("FileStreamExample.txt");
		obj.readFile("FileStreamExample.txt");
				
		int num = Integer.parseInt(args[0]);
		if (num  < 500) {
			InvalidFundException exObj = new InvalidFundException("Sorry, Not enough funds.");
			exObj.setUserName("Shashi");
			throw exObj;	
		}
	}

}
