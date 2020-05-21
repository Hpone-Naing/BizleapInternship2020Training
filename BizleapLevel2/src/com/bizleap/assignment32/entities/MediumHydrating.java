package com.bizleap.assignment32.entities;

import com.bizleap.training.enums.TemperatureCatagory;

public class MediumHydrating extends HydratingFruit {

	public MediumHydrating(String name) {
		super(name);
	}

	public MediumHydrating(String name, double price, double weight, String unit) {
		super(name, price, weight, unit);
	} 
	
	public MediumHydrating(String name, double price, double weight, String unit, Customer customer) {
		super(name, price, weight, unit, customer);
	}

	@Override
	public double calculatePrice(TemperatureCatagory temperature) {
		return getBasePrice();
	}
}
