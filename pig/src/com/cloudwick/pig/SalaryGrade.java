package com.cloudwick.pig;

import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class SalaryGrade extends EvalFunc<Integer> {

	@Override
	public Integer exec(Tuple tuple) throws IOException {

		int salary = (int) tuple.get(0);

		if (700 <= salary & salary <= 1200) {
			return 1;
		} else if (1201 <= salary & salary <= 1400) {
			return 2;
		} else if (1401 <= salary & salary <= 2000) {
			return 3;
		} else if (2001 <= salary & salary <= 3000) {
			return 4;
		} else if (3001 <= salary & salary <= 9999) {
			return 5;
		}

		return 0;
	}
}
