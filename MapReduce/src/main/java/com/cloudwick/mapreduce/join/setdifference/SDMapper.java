package com.cloudwick.mapreduce.join.setdifference;

import java.io.IOException;
import org.apache.hadoop.contrib.utils.join.DataJoinMapperBase;
import org.apache.hadoop.contrib.utils.join.TaggedMapOutput;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class SDMapper extends DataJoinMapperBase {

	protected Text generateGroupKey(TaggedMapOutput taggedRecord) {
		Text groupKey = null;
		String[] record = taggedRecord.getData().toString().split(",");

		String tag = taggedRecord.getTag().toString();
		if (tag.equals("setDifference1")) {
			groupKey = new Text(record[1]);
		} else if (tag.equals("setDifference2")) {
			groupKey = new Text(record[2]);
		}
		return groupKey;
	}

	protected Text generateInputTag(String inputFile) {

		return new Text(inputFile);

	}

	protected TaggedMapOutput generateTaggedMapOutput(Object valueIn) {

		TaggedRecord taggedRecord = new TaggedRecord((Text) valueIn);
		taggedRecord.setTag(this.inputTag);
		return taggedRecord;
	}

	@Override
	public void map(Object key, Object value, OutputCollector output,
			Reporter reporter) throws IOException {

		TaggedRecord taggedRecord = (TaggedRecord) generateTaggedMapOutput(value);
		Text groupKey = generateGroupKey(taggedRecord);
		output.collect(groupKey, taggedRecord);

	}

}
