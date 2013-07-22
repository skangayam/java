package com.cloudwick.threads;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Long> {

	@Override
	public Long call() throws Exception {
		Long sum = (long) 0;
		for (Long i = (long) 0; i < 100; i++) {
			sum += i;
		}
		return sum;
	}
}
