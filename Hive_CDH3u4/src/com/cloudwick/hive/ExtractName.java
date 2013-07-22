package com.cloudwick.hive;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class ExtractName extends UDF {	

	public Text evaluate(Text permissions, Text path, String element) {
		if (path == null) {
			return null;
		}		

		String[] nodes = path.toString().split("/");
		boolean isdb = false;
		char fileType = permissions.toString().charAt(0);
		String db = "", tbl = "";

		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].endsWith(".db")) {
				isdb = true;
				db = nodes[i];
				tbl = nodes[i + 1];
			}
			if (!isdb && ((i + 1) == nodes.length)) {

				db = "default";
				if (fileType == 'd') {
					tbl = nodes[i];
				}
				else {
					tbl = nodes[i - 1];
				}
			}
		}

		if (element.equalsIgnoreCase("table")) {
			return new Text(tbl);

		} else {
			return new Text(db);
		}
	}

}
