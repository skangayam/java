package com.cloudwick.project;

public class ScientificCalc extends Calculator implements CalI 
{
	public ScientificCalc(int n1, int n2)
	{
		this.num1 = n1;
		this.num2 = n2;		
	}
	
	public int calculate()
	{		
		return this.num1 - this.num2;
	}

	@Override
	public boolean checkMax() {
		if (this.num1 > this.num2) 
		{
			return true;
		} 
		else 
		{
			return false;
		}	
	}

}
