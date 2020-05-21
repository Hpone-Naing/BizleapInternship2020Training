package com.bizleap.assignment32.entities;

import com.bizleap.training.enums.TemperatureCatagory;

public abstract class HydratingFruit extends Fruit {

	public HydratingFruit(String name) {
		super(name);
	}

	public HydratingFruit(String name, double price, double weight, String unit) {
		super(name, price, weight, unit);
	}

	public HydratingFruit(String name, double price, double weight, String unit, Customer customer) {
		super(name, price, weight, unit, customer);
	}

	public abstract double calculatePrice(TemperatureCatagory temperature);
}
