package com.schibsted.definition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface FileOperations {
	/**
	 * @param indexableDirectory
	 * @return List of Files
	 * @throws FileNotFoundException
	 */
	List<?> readFilesFromDirectory(final File indexableDirectory)
			throws FileNotFoundException;
	
	/**
	 * @param file
	 * @return extention of the file
	 */
	public String getFileExtension(File file);
}
