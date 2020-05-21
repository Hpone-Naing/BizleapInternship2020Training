package com.bizleap.marchant.domain.enums;

public enum TemperatureCatagory {

	HIGH("High"), MEDIUM("Medium"), LOW("Low");

	public String temperature;

	private TemperatureCatagory(String temperature) {
		this.temperature = temperature;
	}
}
