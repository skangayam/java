package com.cloudwick.threads;

import java.io.File;
import java.util.concurrent.Callable;

public class DataProcessingThread implements Callable<Integer> {
	File fileToProcess;
	File logFile;
	File outputFile;

	public DataProcessingThread(File fileToProcess, File logFile,
			File outputFile) {
		this.fileToProcess = fileToProcess;
		this.logFile = logFile;
		this.outputFile = outputFile;
	}

	@Override
	public Integer call() throws Exception {
		if (fileToProcess.isDirectory()) {
			Assignment.processData(fileToProcess, logFile, outputFile);			
		} else if (fileToProcess.isFile()) {
			
			//retrieve the contents of the file and return the count of persons where age > 30
						return 1;
		}
		return 0;
	}

}
