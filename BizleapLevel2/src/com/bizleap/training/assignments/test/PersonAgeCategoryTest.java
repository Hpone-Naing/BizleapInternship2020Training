package com.bizleap.training.assignments.test;

import com.bizleap.training.assignments.Person;

public class PersonAgeCategoryTest {

	public static void main(String[] args) {
		System.out.println("Person age 1 year old is: " + new Person(1).getPersonCategory() + ".");
		System.out.println("Person age 15 year old is: " + new Person(15).getPersonCategory() + ".");
		System.out.println("Person age 25 year old is: " + new Person(25).getPersonCategory() + ".");
		System.out.println("Person age 65 year old is: " + new Person(65).getPersonCategory() + ".");
		System.out.println("Person age -1 year old is: " + new Person(-1).getPersonCategory() + ".");
	}
}
