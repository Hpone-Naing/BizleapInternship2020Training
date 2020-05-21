package com.bizleap.training.assignments.test;

import com.bizleap.training.assignments.Prime;

public class PrimeTest {

	public static void main(String[] args) {
		if (new Prime().isPrime(11))
			System.out.println("11 is a prime number.");
		else
			System.out.println("11 is not a prime number.");
		
		if (new Prime().isPrime(10))
			System.out.println("10 is a prime number.");
		else
			System.out.println("10 is not a prime number.");
		
		if (new Prime().isPrime(-5))
			System.out.println("-5 is a prime number.");
		else
			System.out.println("-5 is not a prime number.");
	}
}