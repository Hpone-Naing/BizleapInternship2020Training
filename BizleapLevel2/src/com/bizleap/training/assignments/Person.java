package com.bizleap.training.assignments;

import com.bizleap.training.enums.AgeCategory;

public class Person {

	private int age;

	public Person(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public AgeCategory getPersonCategory() {
		if (isAgeChild())
			return AgeCategory.CHILD;

		if (isAgeAdlescence())
			return AgeCategory.ADOLESCENCE;

		if (isAgeAdult())
			return AgeCategory.ADULT;

		if (isAgeSeniorAdult())
			return AgeCategory.SENIOR_ADULT;

		return AgeCategory.INCORRECT_AGE;
	}

	private boolean isAgeChild() {
		return getAge() >= Integer.parseInt(AgeCategory.CHILD.getAgeRange().split("-")[0])
				&& getAge() <= Integer.parseInt(AgeCategory.CHILD.getAgeRange().split("-")[1]);
	}

	private boolean isAgeAdlescence() {
		return getAge() >= Integer.parseInt(AgeCategory.ADOLESCENCE.getAgeRange().split("-")[0])
				&& getAge() <= Integer.parseInt(AgeCategory.ADOLESCENCE.getAgeRange().split("-")[1]);
	}

	private boolean isAgeAdult() {
		return getAge() >= Integer.parseInt(AgeCategory.ADULT.getAgeRange().split("-")[0])
				&& getAge() <= Integer.parseInt(AgeCategory.ADULT.getAgeRange().split("-")[1]);
	}

	private boolean isAgeSeniorAdult() {
		return getAge() >= Integer.parseInt(AgeCategory.SENIOR_ADULT.getAgeRange().split("-")[0]);
	}
}