package com.cloudwick.mapreduce.filter;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;



public class RowFilter extends Configured implements Tool {

	public int run(String[] args) throws Exception {

		if (args.length != 2) {
			System.out.printf(
					"Usage: %s [generic options] <input dir> <output dir>\n",
					getClass().getSimpleName());
			ToolRunner.printGenericCommandUsage(System.out);
			return -1;
		}
		
		Job job = new Job(getConf());
        job.setJarByClass(RowFilter.class);
        job.setJobName(this.getClass().getName());
        
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
        job.setMapperClass(RowMapper.class);
        job.setNumReduceTasks(0);               

		job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(LongWritable.class); 
        job.setOutputValueClass(Text.class); 

        if (job.waitForCompletion(true)) {
            return 0;
        }
        return 1;
	}

	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new RowFilter(), args);
		System.exit(exitCode);
	}

}
