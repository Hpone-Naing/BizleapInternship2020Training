package com.bizleap.training.assignments;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator {
	private static RandomNumberGenerator instance = null;
	private Set<Integer> randomNumbers = null;

	public static synchronized RandomNumberGenerator getInstance() {
		if (instance == null)
			instance = new RandomNumberGenerator();
		return instance;
	}

	public Set<Integer> getRandomNumbers() {
		if (randomNumbers == null)
			randomNumbers = new HashSet<Integer>();
		return randomNumbers;
	}

	public void setRandomNumbers(Set<Integer> randomNumbers) {
		this.randomNumbers = randomNumbers;
	}

	private boolean isUnique(int randomNumber) {
		return getRandomNumbers().add(randomNumber);
	}

	public int getRandomNumber(int size) {
		return (int) (Math.random() * size);
	}

	public int getUniqueRandomNumber(int size) {
		int randomNumber = getRandomNumber(size);
		while (!isUnique(randomNumber))
			randomNumber = getRandomNumber(size);
		return randomNumber;
	}
}