package com.bizleap.training.assignments;

public class WordCount {

	public int getWordCount(String sentence) {
		return StringUtil.getInstance().getWordList(sentence).size();
	}
}