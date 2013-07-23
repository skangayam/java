package com.cloudwick.pig;

import java.io.IOException;

import org.apache.pig.FilterFunc;
import org.apache.pig.data.Tuple;

public class IsPayOptimal extends FilterFunc {

	@Override
	public Boolean exec(Tuple tuple) throws IOException {

		int employeeSalary = (int) tuple.get(0);
		double avgSalary = (double) tuple.get(1);

		if (employeeSalary > avgSalary) {
			return true;

		} else {
			return false;
		}

	}

}
