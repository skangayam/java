package com.cloudwick.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveClientTest {	 
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";	
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		// replace "hive" here with the name of the user the queries should run as
		Connection con = DriverManager.getConnection("jdbc:hive://shashi003.cloudwick.com:10000/default", "", "");
		if (con.isClosed()) {
			System.out.println("connection is closed");			
		}
		else
		{
			System.out.println("connection is open");
		}
		
		Statement stmt = con.createStatement();
		String query;
		ResultSet rs;
		
/*		query = "describe employees";
		System.out.println("Running: " + query);
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			System.out.println(String.valueOf(rs.getString(1)) + "\t \t" + rs.getString(2));
		}	
		
		System.out.println();*/
		
/*		query = "select id, name from employees";
		System.out.println("Running: " + query);
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			System.out.println(String.valueOf(rs.getInt(1)) + "\t" + rs.getString(2));
		}	*/	
		
		StringBuilder sb = new StringBuilder();
		sb.append("select employees.name, employees.deptid, departments.name ");
		sb.append("from employees join departments on (employees.deptid = departments.id)");
		query = sb.toString();
		System.out.println("Running: " + query);
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			System.out.println(String.valueOf(rs.getString(1)) + "\t" + rs.getInt(2)+ "\t" + rs.getString(3));
		}
		
		
		/*
		 Statement stmt = con.createStatement();
		String tableName = "testHiveDriverTable";
		stmt.execute("drop table if exists " + tableName);
		stmt.execute("create table " + tableName + " (key int, value string)");
		// show tables
		String sql = "show tables '" + tableName + "'";
		System.out.println("Running: " + sql);
		ResultSet res = stmt.executeQuery(sql);
		if (res.next()) {
			System.out.println(res.getString(1));
		}
		// describe table
		sql = "describe " + tableName;
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1) + "\t" + res.getString(2));
		}

		// load data into table
		// NOTE: filepath has to be local to the hive server
		// NOTE: /tmp/a.txt is a ctrl-A separated file with two fields per line
		String filepath = "/tmp/a.txt";
		sql = "load data local inpath '" + filepath + "' into table "
				+ tableName;
		System.out.println("Running: " + sql);
		stmt.execute(sql);

		// select * query
		sql = "select * from employees";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(String.valueOf(res.getInt(1)) + "\t"
					+ res.getString(2));
		}

		// regular hive query
		sql = "select count(1) from " + tableName;
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1));
		}
		 */
		
		
		
	}
}
