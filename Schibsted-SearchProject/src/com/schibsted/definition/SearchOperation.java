package com.schibsted.definition;

import java.util.List;

import object.CacheFile;

public interface SearchOperation {

	/**
	 * @param listOfFile
	 * @param searchText
	 */
	public void searchOperation(List<CacheFile> listOfFile, String searchText);
	
	/**
	 * @param matchingString
	 * @param wholeContent
	 * @return true is a string found in body
	 * False if the string doesnt match in content
	 */
	public boolean stringMatcher ( String wholeContent,String matchingString) ;
}
