package com.hponenaingtun.java.test;

import com.bizleap.training.enums.SexCategory;

public  class Student extends Person {

	public Student(String name, int age, SexCategory gender) {
		super(name, age, gender);
	}

	
	protected int getCharacterCount() {
		return getName().split("\\s+").length;
	}

	protected int getWordCount() {
		int count = 0;
		for(String word : getName().split("\\s+")) {
			count += word.toCharArray().length;
		}
		return count;
	}
}