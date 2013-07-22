package com.cloudwick.mapreduce.join.leftouterjoin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LOJMapper extends Mapper<LongWritable, Text, NullWritable, Text> {
	
	HashMap<String,String> hm = new  HashMap<String,String>();
	
	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
				
		hm = new DeptParser("dept").getDeptInfo();
	}
	
	@Override
	protected void map(LongWritable offset, Text record, Context context)
			throws IOException, InterruptedException {
		String[] row = record.toString().split(",");
		context.write(null, new Text(row[0]+","+row[1]+","+hm.get(row[7])));
	}

}
