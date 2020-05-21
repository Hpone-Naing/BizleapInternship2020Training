package com.bizleap.training.assignments;

public class InitialCharacterGenerator {

	public String generateInitialCharacter(String sentence) {
		String initialCharacter = "";
		for (String splitedWord : StringUtil.getInstance().getWordList(sentence)) {
			initialCharacter += splitedWord.charAt(0) + " ";
		}
		return initialCharacter;
	}
}