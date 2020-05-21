package com.bizleap.training.assignments.test;

import java.time.LocalDate;
import java.util.List;

import com.bizleap.training.assignments.IntegerUtil;

public class IntegerUtilTest {

	public static void main(String[] args) {
		System.out.println("Is number 5 prime?: " + IntegerUtil.isPrime(5));
		System.out.println("Is number -100prime?: " + IntegerUtil.isPrime(-100));
		System.out.println("5!: " + IntegerUtil.getFactorial(5));
		System.out.println("-100!: " + IntegerUtil.getFactorial(-100));
		System.out.println("Is 4/1/2020 today: " + IntegerUtil.isToday(LocalDate.of(2020, 04, 01)));
		List<Integer> makedIntegerList = IntegerUtil.getMakedIntegerList(15);
		System.out.println("maked integer from 1 to 15: " + makedIntegerList);
		System.out.println("Get even numbers from integer list: " + IntegerUtil.getEvenNumberList(makedIntegerList));
		System.out.println("Get odd numbers from integer list: " + IntegerUtil.getOddNumberList(makedIntegerList));
		System.out.println("sum of all integers from 1 to 15: " + IntegerUtil.getSumOfItems(makedIntegerList));
	}
}
