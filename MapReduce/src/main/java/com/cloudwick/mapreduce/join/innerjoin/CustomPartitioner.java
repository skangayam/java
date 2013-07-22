package com.cloudwick.mapreduce.join.innerjoin;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import com.cloudwick.mapreduce.customtype.TextPair;

public class CustomPartitioner extends Partitioner<TextPair, Text> {

	
	public int getPartition(TextPair compositeKey, Text record, int numberOfPartitions) {
		
		return (compositeKey.getFirst().hashCode()%numberOfPartitions);
	}

	
	

	
	

}
