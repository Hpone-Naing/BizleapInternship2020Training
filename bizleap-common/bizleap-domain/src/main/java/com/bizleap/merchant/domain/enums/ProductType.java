package com.bizleap.merchant.domain.enums;

public enum ProductType {

	FRUIT("Fruit"), FLOWER("flower"), CANDY("Candy");
	
	String type;

	private ProductType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
