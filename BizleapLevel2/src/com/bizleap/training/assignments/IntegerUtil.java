package com.bizleap.training.assignments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IntegerUtil {

	private static IntegerUtil instance;
	private static List<Integer> itemList;

	private IntegerUtil() {

	}

	public static IntegerUtil getInstance() {
		if (instance == null)
			synchronized (IntegerUtil.class) {
				if (instance == null)
					instance = new IntegerUtil();
			}
		return instance;
	}

	public static List<Integer> getItemList() {
		if (itemList == null)
			itemList = new ArrayList<Integer>();
		return itemList;
	}

	public static void setItemList(List<Integer> itemList) {
		IntegerUtil.itemList = itemList;
	}

	public static boolean isPrime(int number) {
		if (number <= 1)
			return false;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int getFactorial(int number) {
		if (number < 0)
			return -1;
		if (number == 0)
			return 1;
		return number * getFactorial(number - 1);
	}

	public static boolean isToday(LocalDate date) {
		return date.equals(LocalDate.now());
	}

	public static List<Integer> getMakedIntegerList(int number) {
		if (number == 1)
			getItemList().add(number);
		else {
			getItemList().add(number);
			getMakedIntegerList(--number);
		}
		return itemList;
	}

	public static List<Integer> getEvenNumberList(List<Integer> itemList) {
		List<Integer> evenList = new ArrayList<Integer>();
		for (Integer item : itemList) {
			if (isEven(item))
				evenList.add(item);
		}
		return evenList;
	}

	public static List<Integer> getOddNumberList(List<Integer> itemList) {
		List<Integer> oddList = new ArrayList<Integer>();
		for (Integer item : itemList) {
			if (!isEven(item))
				oddList.add(item);
		}
		return oddList;
	}

	public static int getSumOfItems(List<Integer> itemList) {
		int total = 0;
		for (Integer item : itemList) {
			total = sum(total, item);
		}
		return total;
	}

	public static boolean isEven(int item) {
		return item % 2 == 0;
	}

	public static Double sum(Double number1, Double number2) {
		return number1 + number2;
	}

	public static int sum(int number1, int number2) {
		return number1 + number2;
	}
}