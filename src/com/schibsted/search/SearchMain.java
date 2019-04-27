package com.schibsted.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.schibsted.operation.FileOperationsImpl;
import com.schibsted.operation.SearchOperationImpl;

import object.CacheFile;

public class SearchMain {

	/**
	 * @param args command line input which is a path to directory where files are
	 *             present
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length == 0) {
			throw new IllegalArgumentException("No directory given to index");
		}
		FileOperationsImpl fileOperationsobj = new FileOperationsImpl();
		SearchOperationImpl searchOperationObj = new SearchOperationImpl();

		final File indexableDirectory = new File(args[0]);
		List<CacheFile> listOfFile = fileOperationsobj.readFilesFromDirectory(indexableDirectory);
		if (listOfFile.size() < 1) {
			System.err.println("No valid files found in the directory. Exiting system.");
			System.exit(0);
		}
		System.out.println("Enter search term or :quit to exit the system");
		while (true) {
			System.out.println("search> ");
			Scanner keyboard = new Scanner(System.in);
			String searchText = keyboard.nextLine();
			searchText = searchText.trim();
			if (!(searchText.isEmpty() || searchText == " ")) {
				if (searchText.equalsIgnoreCase(":quit")) {
					System.out.println("Shutting down... Restart the system to search again. Bye!");
					keyboard.close();
					System.exit(0);
				} else {
					searchOperationObj.searchOperation(listOfFile, searchText);
				}
			} else {
				System.out.println("Please provide a word to search");
			}

		}
	}
}
