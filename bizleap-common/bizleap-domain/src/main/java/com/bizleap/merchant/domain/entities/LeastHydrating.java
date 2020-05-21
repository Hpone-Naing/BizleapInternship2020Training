package com.bizleap.merchant.domain.entities;

import com.bizleap.marchant.domain.enums.TemperatureCatagory;
import com.bizleap.merchant.service.MediumHydratingPricing;

public class LeastHydrating extends HydratingFruit {

	public LeastHydrating(String name) {
		super(name);
	}

	public LeastHydrating(String name, double price, double weight, String unit) {
		super(name, price, weight, unit);
	}

	@Override
	public double calculatePrice(TemperatureCatagory temperature) {
		setPricing(new MediumHydratingPricing(this));
		((MediumHydratingPricing) getPricing()).doPricing(temperature);
		return getPrice();
	}

}
