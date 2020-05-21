package com.bizleap.training.oop.entities.assignments;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import com.bizleap.training.enums.SexCategory;
import com.bizleap.training.oop.entities.assignments.Student;

public class Person {

	private String name;
	private int age;
	private SexCategory gender;

	public Person() {
	}

	public Person(String name, int age, SexCategory gender) {
		this.name = name;
		if (age < 10)
			this.age = 10;
		else
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

	public int getNameWordCount() {
		return name.split("\\s+").length;
	}

	public int getNameCharacterCount() {
		return Arrays.stream(getName().split("\\s+")).mapToInt(word -> word.length()).sum();
	}

	public boolean isContainWord(Map<Integer, List<Student>> studentMap) {
		return studentMap.containsKey(this.getNameWordCount());
	}

	public boolean isContainCharacter(Map<Integer, List<Student>> studentMap) {
		return studentMap.containsKey(this.getNameCharacterCount());
	}

	@Override
	public int hashCode() {
		return (17 * 1 + (name.hashCode() * gender.hashCode() * Integer.valueOf(age).hashCode()));
	}

	@Override
	public boolean equals(Object entity) {
		if (entity == null || entity.getClass() != this.getClass() || !(entity instanceof Person))
			return false;
		Person person = (Person) entity;
		return this.hashCode() == person.hashCode() && this.name.equals(person.name) && this.age == person.age
				&& this.gender.equals(person.getGender());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("age", age).append("gender", gender).toString();
	}
}