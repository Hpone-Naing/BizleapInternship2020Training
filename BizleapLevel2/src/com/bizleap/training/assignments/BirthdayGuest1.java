package com.bizleap.training.assignments;

import java.util.Queue;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BirthdayGuest1 {

	private String name;

	public BirthdayGuest1() {
	}

	public BirthdayGuest1(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void arrive(Queue<BirthdayGuest1> studentsQueue) {
		studentsQueue.add(this);
	}

	public void award(Queue<BirthdayGuest1> studentsQueue) {
		studentsQueue.remove(this);
	}

	public void depart(Queue<BirthdayGuest1> studentsQueue) {
		studentsQueue.remove(this);
	}

	@Override
	public int hashCode() {
		Integer hash = 1;
		final int prime = 7;
		if (name == null && name.length() < 0)
			return 0;
		for (Character ch : name.toCharArray()) {
			hash += prime * hash + (ch % 0xff);
		}
		hash = hash.hashCode() % 0xff;
		return Math.abs((hash % 13) + 1);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name: " + name).toString();
	}

}