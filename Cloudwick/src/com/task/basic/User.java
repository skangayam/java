package com.task.basic;

public class User {
	
	static final String someStaticFinalString = "some Static Final String";
	static String someStaticString = "some static string"; 	
	String instanceString = "instance string";
	
	public final void instanceMethod()
	{
		System.out.println("This is an instance method. You cannot override it");		
	}
	
	public void instanceMethod2()
	{
		System.out.println("This is an instance method. You can override it.");
	}
	
	public static void staticMethod()
	{
		System.out.println("This is a static method. You can override it");
	}
	
	public static final void staticMethod2()
	{
		System.out.println("This is a static method. You cannot override it.");
	}
	
	
}
