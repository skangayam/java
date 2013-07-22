package com.cloudwick.mapreduce.uniquevisitors;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UVMapper extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	protected void map(LongWritable offset, Text record, Context context)
			throws IOException, InterruptedException {

		String[] row = record.toString().split("\t");
		context.write(new Text(row[1]), new Text(row[0]));

	}

}
