package com.cloudwick.hive;

import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;
//import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.hive.serde2.io.DoubleWritable;

public class Avg extends UDAF {

	public static class Mean implements UDAFEvaluator {

		public class Partial {
			int value;
			int count;
		}

		private Partial partialResult;

		@Override
		public void init() {

			partialResult = null;

		}

		public boolean iterate(IntWritable someValue) {
			if (someValue == null) {
				return true;
			}

			if (partialResult == null) {
				partialResult = new Partial();
			}

			partialResult.value += someValue.get();
			partialResult.count += 1;
			return true;
		}

		public Partial terminatePartial() {
			return partialResult;
		}

		public boolean merge(Partial intermediateResult) {
			if (intermediateResult == null) {
				return true;
			}

			if (partialResult == null) {

				partialResult = new Partial();
			}
			partialResult.value += intermediateResult.value;
			partialResult.count += intermediateResult.count;

			return true;
		}

		public DoubleWritable terminate() {
			if (partialResult == null) {
				return null;
			}

			return new DoubleWritable(partialResult.value / partialResult.count);
		}

	}

}
