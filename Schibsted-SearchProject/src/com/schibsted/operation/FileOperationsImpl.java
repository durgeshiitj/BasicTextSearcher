package com.schibsted.operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.schibsted.definition.FileOperations;

import object.CacheFile;

public class FileOperationsImpl implements FileOperations {

	@Override
	public List<CacheFile> readFilesFromDirectory(final File indexableDirectory) throws FileNotFoundException {
		List<CacheFile> listOfFile = new ArrayList<>();
		if (indexableDirectory.isDirectory()) {
			if (indexableDirectory.listFiles().length > 0) {
				for (File file : indexableDirectory.listFiles()) {
					if (file.isFile()) {
						if (getFileExtension(file).equalsIgnoreCase(".txt")) {
							StringBuffer stringBuffer = new StringBuffer();
							BufferedReader bufferedReader = new BufferedReader(
									new InputStreamReader(new FileInputStream(file)));
							try {
								String readLine = "";
								while ((readLine = bufferedReader.readLine()) != null) {
									stringBuffer.append(readLine).append(" \n");
								}
								CacheFile newFile = new CacheFile();
								newFile.setContent(stringBuffer.toString());
								newFile.setFileName(file.getName());
								listOfFile.add(newFile);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {
							System.err
									.println(file.getName() + " is not a text file. Please provide a valid text file");
						}
					} else {
						System.err.println(file.getName() + "Unreadable file format. Please provide a valid text file");
					}
				}
			} else {
				System.out.println("Directory is empty. Please provide files to start search Engine.");
				throw new FileNotFoundException("No files found");
			}
		} else {
			System.out.println(" No directory");
		}
		System.out.println("\n" + listOfFile.size() + " valid text file(s) read in directory " + indexableDirectory);
		return listOfFile;
	}

	public String getFileExtension(File file) {
		String extension = "";

		try {
			if (file != null && file.exists()) {
				String name = file.getName();
				extension = name.substring(name.lastIndexOf("."));
			}
		} catch (Exception e) {
			extension = "";
		}

		return extension;

	}

}
