package com.hponenaingtun.java.test;

import java.util.Arrays;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.training.enums.SexCategory;

public class Person {

	private String name;
	private int age;
	private SexCategory gender;

	public Person() {
	}

	public Person(String name, int age, SexCategory gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public SexCategory getGender() {
		return gender;
	}

	public void setGender(SexCategory gender) {
		this.gender = gender;
	}

	public boolean isElder(Person person) {
		return this.age > person.age;
	}

	public boolean isYounger(Person person) {
		return this.age < person.age;
	}

	public boolean isSameAge(Person person) {
		return !isElder(person) && !isYounger(person);
	}

	public boolean isMale() {
		return this.gender.equals(SexCategory.MALE);
	}

	public boolean isFemale() {
		return !isMale();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("name", name).append("age", age)
				.append("gender", gender).toString();
	}
}