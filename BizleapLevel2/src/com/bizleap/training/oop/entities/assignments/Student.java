package com.bizleap.training.oop.entities.assignments;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.training.enums.SexCategory;

public abstract class Student extends Person {

	private String institution;

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Student(String name, int age, SexCategory gender) {
		super(name, age, gender);
	}

	public Student(String name, int age, SexCategory gender, String institution) {
		this(name, age, gender);
		this.institution = institution;
	}

	protected abstract int getCharacterCount();

	protected abstract int getWordCount();

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append(super.toString())
				.append("institution", institution)
				.toString();
	}
}