package com.cloudwick.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializationExample {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */

	private void serializeObject(String filename) throws FileNotFoundException, IOException {
		User obj = new User();
		obj.setName("Shashi");
		obj.setAge(25);
		obj.setCity("Fremont");
		obj.setSsn("111-11-1111");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}
	


	private void deserializeObject(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		Object obj = ois.readObject();
		if (obj instanceof User) {
			User userObj = (User) obj;
			System.out.println("NAME: "+ userObj.getName());	
			System.out.println("AGE: "+ userObj.getAge());
			System.out.println("CITY: "+ userObj.getCity());
			System.out.println("SSN: "+ userObj.getSsn()); // will be null because the ssn variable was transient
		}		
		ois.close();		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectSerializationExample obj2 = new ObjectSerializationExample();
		obj2.serializeObject("ObjectSerializationExample.txt");
		obj2.deserializeObject("ObjectSerializationExample.txt");

	}

}
