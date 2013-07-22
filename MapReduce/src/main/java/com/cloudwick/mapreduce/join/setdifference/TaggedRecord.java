package com.cloudwick.mapreduce.join.setdifference;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.contrib.utils.join.TaggedMapOutput;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class TaggedRecord extends TaggedMapOutput {

	private Writable record;
	
	public void readFields(DataInput in) throws IOException {
		this.tag.readFields(in);
		this.record.readFields(in);

	}

	public void write(DataOutput out) throws IOException {
		this.tag.write(out);
		this.record.write(out);

	}
	
	public Writable getData() {
		return record;
	}
	
	public TaggedRecord(Writable line) {
		
		this.record = line;
		this.tag = new Text("");
	}

}
