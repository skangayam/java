package com.cloudwick.mapreduce.join.innerjoin;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

import com.cloudwick.mapreduce.customtype.TextPair;

public class CustomSortComparator extends WritableComparator {

	public CustomSortComparator() {
		super(TextPair.class, true);
	}

	public int compare(WritableComparable a, WritableComparable b) {

		TextPair compositeKey1 = (TextPair) a;
		TextPair compositeKey2 = (TextPair) b;

		int result = compositeKey1.compareTo(compositeKey2, 1);
		if (result != 0) {
			return result;
		}
		return compositeKey1.compareTo(compositeKey2, 2);

	}

}
