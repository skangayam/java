package com.cloudwick.mapreduce.join.setdifference;

import org.apache.hadoop.contrib.utils.join.DataJoinReducerBase;
import org.apache.hadoop.contrib.utils.join.TaggedMapOutput;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class SDReducer extends DataJoinReducerBase {

	@Override
	protected TaggedMapOutput combine(Object[] tags, Object[] values) {
		
		
		if (tags.length == 1 & tags[0].toString().equals("setDifference1")) {
			
			//return new TaggedRecord((Writable)values[0]);
			TaggedRecord tr = new TaggedRecord((Writable)values[0]);
			tr.setTag(new Text(tags[0].toString()));
			
			return tr;
			
		}
		else {
			return null;
		}
		
		
		
		
		
		
	}

}
