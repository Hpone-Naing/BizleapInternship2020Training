package com.bizleap.merchant.domain.entities;

import com.bizleap.marchant.domain.enums.TemperatureCatagory;
import com.bizleap.merchant.service.impl.MostHydratingPricing;

public class MostHydrating extends HydratingFruit {

	public MostHydrating(String name) {
		super(name);
	}

	public MostHydrating(String name, double price, double weight, String unit) {
		super(name, price, weight, unit);
	}

	@Override
	public double calculatePrice(TemperatureCatagory temperature) {
		setPricing(new MostHydratingPricing(this));
		((MostHydratingPricing) getPricing()).doPricing(temperature);
		return getPrice();
	}
}