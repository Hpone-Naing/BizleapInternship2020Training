package com.bizleap.training.assignments;

public class PlayerSelection {

	public boolean isAcceptPlayer(int age, double height) {
		return (age > 16 && age < 30) && height >= 180;
	}
}
