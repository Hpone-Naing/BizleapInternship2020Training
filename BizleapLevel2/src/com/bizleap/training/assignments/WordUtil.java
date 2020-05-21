package com.bizleap.training.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordUtil {

	private static WordUtil instance;
	private List<String> itemList;

	private WordUtil() {

	}

	public static WordUtil getInstance() {
		if (instance == null)
			synchronized (WordUtil.class) {
				if (instance == null)
					instance = new WordUtil();
			}
		return instance;
	}

	public List<String> getItemList() {
		if (itemList == null)
			itemList = new ArrayList<String>();
		return itemList;
	}

	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}

	public List<String> getStudentNameList(String studentNames[]) {
		List<String> nameList = new ArrayList<String>();
		return nameList.addAll(Arrays.asList(studentNames)) ? nameList : null;
	}

	public List<Integer> getCountedWordList(List<String> nameList) {
		List<Integer> countedWordList = new ArrayList<Integer>();
		if (nameList != null) {
			for (String name : nameList) {
				getCountedWord(name);
			}
		}
		return countedWordList;
	}

	public int getCountedWord(String word) {
		return StringUtil.getInstance().getWordList(word).size();
	}

	public int getCountedCharacter(String sentence) {
		int count = 0;
		for (String str : StringUtil.getInstance().getWordList(sentence)) {
			count += str.toCharArray().length;
		}
		return count;
	}

	public Set<String> getUniqueWords(List<String> wordList) {
		Set<String> uniqueWords = new HashSet<String>();
		if (wordList != null) {
			for (String word : wordList) {
				uniqueWords.addAll(Arrays.asList(word.split("\\s+")));
			}
		}
		return uniqueWords;
	}

	public List<String> getMakedWordList(List<Integer> numberList) {
		for (Integer number : numberList) {
			if (isDivisibleByDivisior(number, 3, 5))
				getItemList().add("BizLeap");

			else if (isDivisibleByDivisior(number, 3))
				getItemList().add("Biz");

			else if (isDivisibleByDivisior(number, 5))
				getItemList().add("Leap");
		}
		return getItemList();
	}

	public Set<String> getMultipleOccurance() {
		Set<String> multipleOccuranceWords = new HashSet<String>();
		for (String word : itemList) {
			if (getOccuranceCount(word) > 1)
				multipleOccuranceWords.add(word);
		}
		return multipleOccuranceWords;
	}

	// use Set
	public Set<String> getMultipleOccuranceTest1() {
		Set<String> words = new HashSet<String>();
		Set<String> multipleWord = new HashSet<String>();
		for (String item : itemList) {
			if (!words.add(item))
				multipleWord.add(item);
		}
		return multipleWord;
	}

	// use Set
	public Set<String> getMultipleOccuranceTest2() {
		Set<String> multipleOccuranceWords = new HashSet<String>();
		multipleOccuranceWords.addAll(itemList);
		multipleOccuranceWords.removeAll(getOnceOccuranceTest());
		return multipleOccuranceWords;
	}

	public Set<String> getOddOccurance() {
		Set<String> oddTimeOccuranceWords = new HashSet<String>();
		for (String word : itemList) {
			if (getOccuranceCount(word) % 2 != 0)
				oddTimeOccuranceWords.add(word);
		}
		return oddTimeOccuranceWords;
	}

	// use Set
	public Set<String> getOddOccuranceTest() {
		Set<String> oddTimeOccurance = new HashSet<String>();
		for (String word : itemList) {
			if (!oddTimeOccurance.add(word)) {
				oddTimeOccurance.remove(word);
			}
		}
		return oddTimeOccurance;
	}

	// use Set
	public Set<String> getOnceOccuranceTest() {
		List<String> multipleList = new ArrayList<String>();
		Set<String> multiples = new HashSet<String>();
		for (String item : itemList) {
			if (!multiples.add(item))
				multipleList.add(item);
		}
		multiples.removeAll(multipleList);
		return multiples;
	}

	public Set<String> getEvenOccurance() {
		Set<String> evenTimeOccuranceWords = new HashSet<String>();
		for (String word : itemList) {
			if (getOccuranceCount(word) % 2 == 0)
				evenTimeOccuranceWords.add(word);
		}
		return evenTimeOccuranceWords;
	}

	public Set<String> getEvenOccuranceTest() {
		Set<String> evenTimeOccuranceWords = new HashSet<String>();
		evenTimeOccuranceWords.addAll(itemList);
		evenTimeOccuranceWords.removeAll(getOddOccuranceTest());
		return evenTimeOccuranceWords;
	}

	/*
	 * itemList = [Biz, Leap, Biz, Biz, Leap, Biz, Biz, Biz, Leap, Bizleap,
	 * Bizleap, Leap]
	 * 
	 * items = []
	 * 
	 * evenWords = [Biz, Leap, Bizleap]
	 */
	public Set<String> getEvenOccuranceTest2() {
		Set<String> items = new HashSet<String>();
		Set<String> evenWords = new HashSet<String>();
		for (String item : itemList) {
			if (!items.add(item))
				evenWords.add(item);
			items.remove(item);
		}
		return evenWords;
	}

	private int getOccuranceCount(String item) {
		int count = 0;
		if (itemList != null) {
			for (String word : getItemList()) {
				if (item.equals(word))
					count++;
			}
		}
		return count;
	}

	private boolean isDivisibleByDivisior(int number, int divisior) {
		return number % divisior == 0;
	}

	private boolean isDivisibleByDivisior(int number, int divisior1, int divisior2) {
		return isDivisibleByDivisior(number, divisior1) && isDivisibleByDivisior(number, divisior2);
	}

	public static void main(String[] args) {
		System.out.println(WordUtil.getInstance().getCountedCharacter("Ei Khaing Poe"));
	}
}