package com.cloudwick.hive;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class Swap extends UDF {

	private Text result = new Text();

	public Text evaluate(Text source, String x, String y) {
		if (source == null) {
			return null;
		}
		
		char a = x.charAt(0);
		char b = y.charAt(0);

		String s = source.toString().replace(a, b);
		result.set(s);

		return result;
	}

}
