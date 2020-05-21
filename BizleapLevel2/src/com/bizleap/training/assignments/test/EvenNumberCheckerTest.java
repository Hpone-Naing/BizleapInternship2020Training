package com.bizleap.training.assignments.test;

import com.bizleap.training.assignments.EvenNumberChecker;

public class EvenNumberCheckerTest {

	public static void main(String[] args) {
		
		EvenNumberChecker evenNumberChecker = new EvenNumberChecker();
		evenNumberChecker.acceptInput();
		if (evenNumberChecker.isEven())
			System.out.println("Your number \'" + evenNumberChecker.getNumber() + "\' is even.");
		else
			System.out.println("Result: Your number \'" + evenNumberChecker.getNumber() + "\' is odd.");
	}
}