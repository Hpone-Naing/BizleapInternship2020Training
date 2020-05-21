package com.bizleap.training.oop.entities.assignments;

import com.bizleap.training.enums.TemperatureCatagory;

public class LeastHydrating extends HydratingFruit {

	public LeastHydrating(String name) {
		super(name);
	}

	public LeastHydrating(String name, double price, double weight, String unit) {
		super(name, price, weight, unit);
	}

	@Override
	public double calculatePrice(TemperatureCatagory temperature) {
		switch (temperature) {
		case HIGH:
			setPrice(getBasePrice() - (getBasePrice() * .15));
			break;
		case LOW:
			setPrice(getBasePrice() + (getBasePrice() * .15));
			break;
		default:
			setPrice(getBasePrice());
			break;
		}
		return getPrice();
	}

}
