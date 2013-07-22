package com.cloudwick.project;

public class JavaProjManager {

	public static void main(String[] args) {
		Calculator obj = new Calculator(3, 5);
		
		int result = obj.calculate();		
		System.out.println("Result: "+ result);
		
		result = obj.calculate(1);
		System.out.println("Result: "+result);
		
		result = obj.calculate("1");
		System.out.println("Result: "+result);
		
		System.out.println(obj);
		
		System.out.println("---------------");
		
		ScientificCalc obj2 = new ScientificCalc(20,30);
		System.out.println(obj2);
		
		result = obj2.calculate();
		System.out.println("Result: "+result);		
		
		System.out.println(obj2.checkMax());
		
		obj2.hello();
		obj2.printData();
		
		Calculator calc1 = new Calculator(1,2);
		calc1.name = "testName";
		
		Calculator calc2 = new Calculator(1,2);
		calc2.name = "testame";
		
		if (calc1.equals(calc2)) {
			System.out.println("Both are equal");
		}
		else
		{
			System.out.println("Both are unequal");
		}
		
		
		
		
	}
}
