package com.bizleap.training.oop.entities.assignments;

import com.bizleap.training.enums.SexCategory;

public class OtherStudent extends Student {

	public OtherStudent(String name, int age, SexCategory gender, String institution) {
		super(name, age, gender, institution);
	}

	@Override
	protected int getCharacterCount() {
		return getNameCharacterCount();
	}

	@Override
	protected int getWordCount() {
		return getNameWordCount();
	}
}