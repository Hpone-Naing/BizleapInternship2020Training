package com.bizleap.training.assignments.test;

import com.bizleap.training.assignments.HeightCalculation;

public class HeightCalculationTest {

	public static void main(String[] args) {
		System.out.println("Total Height of 5.32;5.11;5.74 is: "
				+ new HeightCalculation().getCalculatedTotalHeight("5.32;5.11;5.74"));
	}
}
