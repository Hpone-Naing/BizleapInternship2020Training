package com.bizleap.assignment32.entities;

import com.bizleap.training.enums.TemperatureCatagory;

public class MostHydrating extends HydratingFruit {

	public MostHydrating(String name) {
		super(name);
	}

	public MostHydrating(String name, double price, double weight, String unit) {
		super(name, price, weight, unit);
	}
	
	public MostHydrating(String name, double price, double weight, String unit, Customer customer) {
		super(name, price, weight, unit, customer);
	}

	@Override
	public double calculatePrice(TemperatureCatagory temperature) {
		switch (temperature) {
		case HIGH:
			setPrice(getBasePrice() + (getBasePrice() * .15));
			break;
		case LOW:
			setPrice(getBasePrice() - (getBasePrice() * .15));
			break;
		default:
			setPrice(getBasePrice());
			break;
		}
		return getPrice();
	}
}