package com.schibsted.operation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.schibsted.definition.SearchOperation;

import object.CacheFile;

public class SearchOperationImpl implements SearchOperation {

	@Override
	public void searchOperation(List<CacheFile> listOfFile, String searchText) {
		boolean matchFound = false;
		// to make text search case insensitive
		String[] arrayOfWords = searchText.toLowerCase().split(" ");
		/*
		 * Remove Duplicate words in a sentence
		 *
		 */
		arrayOfWords = new HashSet<String>(Arrays.asList(arrayOfWords)).toArray(new String[0]);
		for (CacheFile cacheFile : listOfFile) {
			String content = cacheFile.getContent();
			double match = 0;
			for (String word : arrayOfWords) {
				// matcher
				//to search with case insensitive
				if (stringMatcher(content.toLowerCase(),word.toLowerCase())) {
					match++;
					matchFound = true;
				}
			}
			if (matchFound)
				System.out.println(cacheFile.getFileName() + " : " +String.format("%.02f", (match / arrayOfWords.length * 100.00)) + "%");
		}
		if (!matchFound) {
			System.out.println("No matches found");
		}
	}
	
	@Override
	public boolean stringMatcher ( String wholeContent,String matchingString) {
		Pattern p = Pattern.compile("\\b"+matchingString+"\\b");
	    Matcher m = p.matcher(wholeContent);
	    return m.find();
	}
}
