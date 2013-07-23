package com.cloudwick.hive;


public class work {

	public static void main(String[] args) {
		//String path = "/user/hive/warehouse/testdb.db/avgtest/AvgTestData";
		char fileType = "-rwxr-xr-x".charAt(0);
		String path = "/user/hive/warehouse/avgtest/data";
		
		String[] nodes = path.split("/");
		boolean isdb = false;
		String db = "", tbl = "";

		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].endsWith(".db")) {
				isdb = true;
				db = nodes[i];
				tbl = nodes[i + 1];
			}
			if (!isdb && ((i+1) == nodes.length)) {

				db = "default";
				if (fileType == 'd') {
					tbl = nodes[i];
				}
				else {
					tbl = nodes[i - 1];
				}
				
			}
		}

		System.out.println("db = " + db + " tbl =" + tbl);
	}

}
