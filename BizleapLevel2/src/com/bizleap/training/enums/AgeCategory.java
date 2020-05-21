package com.bizleap.training.enums;

public enum AgeCategory {

	CHILD("0-12"), ADOLESCENCE("13-18"), ADULT("19-59"), SENIOR_ADULT("60"), INCORRECT_AGE("-");
	public String ageRange = null;

	AgeCategory(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getAgeRange() {
		if (ageRange == null)
			return null;
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
}