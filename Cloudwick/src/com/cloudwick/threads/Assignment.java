package com.cloudwick.threads;

import java.io.File;

public class Assignment {
	
	public static void processData(File fileToProcess, File logFile, File outputFile)
	{		
		
		File[] fileList = fileToProcess.listFiles();		
		
		for (int i = 0; i < fileList.length; i++) {			
			//Thread dataProcessingThread = new DataProcessingThread(fileToProcess, logFile, outputFile);
			//dataProcessingThread.run();			
		}	
			
	}	

	
	public static void main(String[] args) {
		
		File fileToProcess = new File("C:\\Users\\Shashi\\A");
		File logFile = new File("C:\\Users\\Shashi\\Dropbox\\regular\\TechStudy\\Java\\EclipseWorkSpace\\Cloudwick\\taskLogFile.txt");
		File outputFile = new File("C:\\Users\\Shashi\\Dropbox\\regular\\TechStudy\\Java\\EclipseWorkSpace\\Cloudwick\\outputFile.txt");
		
		processData(fileToProcess, logFile, outputFile);
		
	}

}


