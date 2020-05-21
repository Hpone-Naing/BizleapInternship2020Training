package com.bizleap.training.enums;

public enum StatusCategory {

	SEEN("seen"), DELIVERED("delivered");
	String name;

	StatusCategory(String name) {
		this.name = name;
	}
}
