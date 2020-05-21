package com.bizleap.training.oop.entities.assignments;

import com.bizleap.training.enums.SexCategory;

public class UcsyStudent extends Student {

	public UcsyStudent(String name, int age, SexCategory gender) {
		super(name, age, gender, "UCSY");
	}

	@Override
	protected int getCharacterCount() {
		String str[] = getName().split("\\s+");
		return str[0].toCharArray().length + str[str.length - 1].toCharArray().length;
	}

	@Override
	protected int getWordCount() {
		return 2;
	}
}