package com.bizleap.training.assignments;

import java.util.Scanner;

public class EvenNumberChecker {

	private int number = 0;
	private Scanner reader = null;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void acceptInput() {
		reader = getScanner();
		if (reader == null)
			return;
		System.out.print("Enter number: ");
		number = getInputValidity();
	}

	public Scanner getScanner() {
		if (reader == null)
			return new Scanner(System.in);
		return reader;
	}

	public boolean isEven() {
		return number % 2 == 0;
	}

	private int getInputValidity() {		
		if (reader == null)
			return 0;
		while (!reader.hasNextInt()) {
			System.out.print("Please enter range between -2 147 483 648 and 2 147 483 647.Retype again: ");
			reader.next();
		}
		return reader.nextInt();
	}
}