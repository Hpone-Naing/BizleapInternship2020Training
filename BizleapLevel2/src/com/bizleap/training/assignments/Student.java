package com.bizleap.training.assignments;

import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.training.enums.SexCategory;

public class Student {

	private String name;
	private String email;
	private String phoneNumber;
	private int age;
	private SexCategory sexType;

	public Student() {
	}

	public Student(String name, String phoneNumber, SexCategory sexType) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.sexType = sexType;
	}

	public Student(String name, int age, String email, SexCategory sexType, String phoneNumber) {
		this(name, phoneNumber, sexType);
		this.age = age;
		this.email = email;
	}

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SexCategory getSexCategory() {
		return sexType;
	}

	public void setSexCategory(SexCategory sexCategory) {
		this.sexType = sexCategory;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSameSex(SexCategory sexType) {
		return this.sexType.equals(sexType);
	}

	public void arrive(Queue<Student> studentsQueue) {
		studentsQueue.add(this);
	}

	public void award(Queue<Student> studentsQueue) {
		studentsQueue.remove(this);
	}

	public void depart(Queue<Student> studentsQueue) {
		studentsQueue.remove(this);
	}

	public int gettNameCharacterCount() {
		int count = 0;
		for (String str : name.split("\\s+")) {
			count += str.toCharArray().length;
		}
		return count;
	}

	public Integer getNameWordCount() {
		return name.split("\\s+").length;
	}

	public boolean isContainWord(Map<Integer, List<Student>> studentMap) {
		return studentMap.containsKey(this.getNameWordCount());
	}

	public boolean isContainCharacter(Map<Integer, List<Student>> studentMap) {
		return studentMap.containsKey(this.gettNameCharacterCount());
	}

	@Override
	public int hashCode() {
		Integer hash = 1;
		final int prime = 7;
		String str = name + age + email + phoneNumber + sexType;
		if (str.length() < 0 && str == null)
			return 0;
		for (Character ch : str.toCharArray()) {
			hash += prime * hash + (ch % 0xff);
		}
		hash = hash.hashCode() % 0xff;
		return Math.abs((hash % 13) + 1);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(name).append(email).append(phoneNumber).append(age).append(sexType)
				.toString();
	}
}