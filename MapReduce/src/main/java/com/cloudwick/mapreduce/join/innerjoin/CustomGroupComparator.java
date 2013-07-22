package com.cloudwick.mapreduce.join.innerjoin;

import org.apache.hadoop.io.WritableComparator;

import com.cloudwick.mapreduce.customtype.TextPair;

public class CustomGroupComparator extends WritableComparator {

	protected CustomGroupComparator() {
		super(TextPair.class, true);
	}

	public int compare(TextPair compositeKey1, TextPair compositeKey2) {

		return compositeKey1.compareTo(compositeKey2, 1);

	}

}
