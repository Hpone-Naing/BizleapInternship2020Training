package com.bizleap.merchant.domain.entities;

import com.bizleap.marchant.domain.enums.TemperatureCatagory;

public abstract class HydratingFruit extends Fruit {
	
	public HydratingFruit() {
		super();
	}

	public HydratingFruit(String name) {
		super(name);
	}

	public HydratingFruit(String name, double price, double weight, String unit) {
		super(name, price, weight, unit);
	}

	public abstract double calculatePrice(TemperatureCatagory temperature);
}
