package com.cloudwick.mapreduce.join.innerjoin;

import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import com.cloudwick.mapreduce.customtype.TextPair;

public class InnerJoinReducer extends Reducer<Text, Text, NullWritable, Text> {

	protected void reduce(TextPair compositeKey, Iterable<Text> rows,
			Context context) throws IOException, InterruptedException {

		String deptName = null;
		boolean set = false;

		for (Text row : rows) {
			if (!set) {
				deptName = row.toString().split(",")[1];
				set = true;
			} else {
				String[] record = row.toString().split(",");
				context.write(null, new Text(record[0] + "," + record[1] + ","
						+ deptName));
			}

		}
	}

}
