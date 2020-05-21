package com.bizleap.training.assignments;

public class EvenNumbersCalculation {

	public int getSumOfEvenNumbers(int number) {
		return IntegerUtil.getSumOfItems(IntegerUtil.getEvenNumberList(IntegerUtil.getMakedIntegerList(number)));
	}
}