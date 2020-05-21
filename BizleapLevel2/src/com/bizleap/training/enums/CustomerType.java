package com.bizleap.training.enums;

public enum CustomerType {

	REGULAR("regular-customer"), VALUED("value-customer"), VOLUMED("volume-customer");

	private String type;

	private CustomerType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}