package com.bizleap.training.assignments.test;

import com.bizleap.training.assignments.Factorial;

public class FactorialTest {

	public static void main(String[] args) {
		System.out.println("1!: " + new Factorial().factorial(5));
		System.out.println("-10!: " + new Factorial().factorial(-10));
		System.out.println("1000!: " + new Factorial().factorial(1000));
	}
}
