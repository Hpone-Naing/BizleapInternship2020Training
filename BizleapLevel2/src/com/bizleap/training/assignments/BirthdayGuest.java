package com.bizleap.training.assignments;

public class BirthdayGuest extends Student {

	public BirthdayGuest() {
	}

	public BirthdayGuest(String name) {
		super(name);
	}

	public String serve() {
		return new StringBuilder().append(super.getName() + " serve special homemade ice-cream").toString();
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
