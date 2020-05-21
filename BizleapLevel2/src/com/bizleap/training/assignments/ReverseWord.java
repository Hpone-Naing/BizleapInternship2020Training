package com.bizleap.training.assignments;

import java.util.Stack;

public class ReverseWord {

	private Stack<String> wordList;

	public Stack<String> getStack() {
		if (wordList == null)
			wordList = new Stack<String>();
		return wordList;
	}

	public void setStack(Stack<String> wordList) {
		this.wordList = wordList;
	}

	public Stack<String> getWordList(String sentence) {
		getStack().addAll(StringUtil.getInstance().getWordList(sentence));
		return wordList;
	}

	public String getReversedWord(Stack<String> wordList) {
		StringBuilder builder = new StringBuilder();
		while (!wordList.isEmpty()) {
			builder.append(wordList.pop() + " ");
		}
		return builder.toString();
	}
}