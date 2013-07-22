package com.task.basic;

public abstract class Logic {
	
	public int gradeStudent(int obtainedScore, int totalScore)
	{
		if (obtainedScore >= 35) {
			return 1;
			
		} else {
			
			return 0;
		}		
	}
	
	public final void promoteStudent(int rollNo)
	{
		System.out.println("The student bearing rollNo " + rollNo + "has been promoted.");
	}

}
