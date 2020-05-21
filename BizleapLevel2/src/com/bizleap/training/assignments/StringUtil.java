package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	private static StringUtil instance;

	private StringUtil() {
		
	}
	
	public static synchronized StringUtil getInstance() {
		if (instance == null)
			instance = new StringUtil();
		return instance;
	}
	
	public List<String> getWordList(String sentence) {
		List<String> wordList = new ArrayList<String>();
		if (sentence == null)
			return null;
		for (String word : sentence.trim().split("(;|\\s+)")) {
			wordList.add(word);
		}
		return wordList;
	}
}