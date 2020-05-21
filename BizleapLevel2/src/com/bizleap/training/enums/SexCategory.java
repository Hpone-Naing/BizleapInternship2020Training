package com.bizleap.training.enums;

public enum SexCategory {

	MALE("Male"), FEMALE("Female");
	String sexType = null;

	SexCategory(String sexType) {
		this.sexType = sexType;
	}

	public String getSexType() {
		return sexType;
	}

	public void setSexType(String sexType) {
		this.sexType = sexType;
	}
}