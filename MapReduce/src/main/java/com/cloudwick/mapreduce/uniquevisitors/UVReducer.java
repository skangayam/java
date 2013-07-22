package com.cloudwick.mapreduce.uniquevisitors;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UVReducer extends Reducer<Text, Text, Text, IntWritable> {

	@Override
	protected void reduce(Text url, Iterable<Text> iplist, Context context)
			throws IOException, InterruptedException {
		Set<String> ipset = new HashSet<String>();
		for (Text ipaddr : iplist) {
			ipset.add(ipaddr.toString());
		}
		context.write(url, new IntWritable(ipset.size()));
	}
}
