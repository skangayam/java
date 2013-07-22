package com.cloudwick.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StringProcessorExample {

	public void ProcessFile(String filename) throws IOException {		

		BufferedReader br = new BufferedReader(new FileReader(filename), 100);
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"FilteredUsers.txt"), 100);

		String s = null;
		while ((s = br.readLine()) != null) {

			String[] arr = s.split(",");
			int i = Integer.parseInt(arr[4]);
			if (i > 29 && i < 40) {

				StringBuilder sb = new StringBuilder();
				sb.append(arr[0] + "," + arr[1] + "," + arr[4] + "\n");
				bw.write(sb.toString());

			}
		}

		br.close();
		bw.close();

		System.out.println("Data successfully filtered.");

		
	}

	public static void main(String[] args) throws IOException {

		StringProcessorExample obj = new StringProcessorExample();
		obj.ProcessFile("Users.txt");

	}

}
