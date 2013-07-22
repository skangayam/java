package com.cloudwick.mapreduce.filter;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.google.common.base.Splitter;

public class RowMapper extends Mapper<LongWritable, Text, LongWritable, Text> {

	public void map(LongWritable offset, Text line, Context context)
			throws IOException, InterruptedException {

		Iterable<String> row = Splitter.on(',').split(line.toString());
		int column = 1;
		for (String value : row) {

			if (column == 7 && !value.isEmpty()) {
				context.write(null, line);
			}

			column++;
		}

	}

}
