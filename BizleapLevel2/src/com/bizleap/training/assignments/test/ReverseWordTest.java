package com.bizleap.training.assignments.test;

import com.bizleap.training.assignments.ReverseWord;

public class ReverseWordTest {

	public static void main(String[] args) {
		ReverseWord reverseWord = new ReverseWord();
		System.out.println("Original Word: Hpone Naing Tun.");
		System.out.println(
				"Reversed Word: " + reverseWord.getReversedWord(reverseWord.getWordList("Hpone Naing Tun")));
	}
}