package com.cloudwick.pig;

import java.io.IOException;

import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.pig.LoadFunc;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.PigSplit;
import org.apache.pig.data.DataByteArray;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;

public class CustomDelimiter extends LoadFunc {
	
	private String delimiter;
	private RecordReader reader;
	private final TupleFactory tupleFactory = TupleFactory.getInstance();
	
	public CustomDelimiter(String delimiter)
	{		
		this.delimiter = delimiter;
	}
	
	@Override
	public InputFormat getInputFormat() throws IOException {
		return new TextInputFormat();		
	}

	@Override
	public Tuple getNext() throws IOException {
		try {
			if (!reader.nextKeyValue()) {
				return null;
			}
			
			String row = reader.getCurrentValue().toString();
			String[] values = row.split(delimiter);
			Tuple tuple = tupleFactory.newTuple(values.length);
			for (int i = 0; i < values.length; i++) {
				tuple.set(i, new DataByteArray(values[i]));
			}
			
			return tuple;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void prepareToRead(RecordReader reader, PigSplit split)
			throws IOException {
		this.reader = reader;
	}

	@Override
	public void setLocation(String fileLocation, Job job) throws IOException {
		FileInputFormat.setInputPaths(job, fileLocation);
	}

}
