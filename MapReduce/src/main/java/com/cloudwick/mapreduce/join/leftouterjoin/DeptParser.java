package com.cloudwick.mapreduce.join.leftouterjoin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DeptParser {
	
	private BufferedReader br;
		
	public DeptParser(String filename) throws IOException
	{
		br = new BufferedReader(new FileReader(filename), 100);	
	}
	
	public HashMap<String, String> getDeptInfo() throws IOException
	{
		HashMap<String, String> hm = new HashMap<String,String>();
		String record = null;
		while ((record = br.readLine()) != null) {
			String[] row = record.split(",");
			hm.put(row[0], row[1]);
		}
		br.close();
		return hm;
	}
	
/*	public String getDeptName(String deptid) throws IOException
	{		
		String record = null;
		while ((record = br.readLine()) != null) {
			String[] row = record.split(","); 
			if (deptid.equals(row[0])) {
				return row[1];
			}  			
		}
		br.close();
		return null;
	}*/
}
