package com.cloudwick.project;

public class Calculator extends CalAbstract {
	public int num1;
	public int num2;
	public String name;
	
	public Calculator()
	{
		
	}
	
	public boolean equals(Object o)
	{
		if (o == null) {
			return false;			
		}
		
		if (!(o instanceof Calculator)) {
			return false;
		}
		
		Calculator obj = (Calculator)o;
		
		return (this.num1 == obj.num1 && this.name == obj.name);		
	}
	
	public int hashCode()
	{
		int hash  = 3;
		hash = hash+this.name.hashCode();
		hash = hash + this.num1;
		return hash;		
	}
	
	public Calculator(int n1, int n2)
	{
		this.num1 = n1;
		this.num2 = n2;
	}
	
	public int calculate()
	{
		return this.num1 + this.num2;
	}
	
	public int calculate(String id)
	{
		return this.num1 - this.num2;
	}
	
	public int calculate(int id)
	{
		return this.num1 * this.num2;
	}
	
	
	public String toString()
	{
		return this.num1 + " "+ this.num2 ;
	}

	@Override
	public void hello() {
		System.out.println("I am from hello");
		
	}
	
	

}
