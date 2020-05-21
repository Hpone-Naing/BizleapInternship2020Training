package com.bizleap.training.oop.entities.assignments;

import com.bizleap.training.enums.TemperatureCatagory;

public class MediumHydrating extends HydratingFruit {

	public MediumHydrating(String name) {
		super(name);
	}

	public MediumHydrating(String name, double price, double weight, String unit) {
		super(name, price, weight, unit);
	}

	@Override
	public double calculatePrice(TemperatureCatagory temperature) {
		return getBasePrice();
	}
}
