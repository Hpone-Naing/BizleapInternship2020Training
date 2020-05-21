package com.bizleap.merchant.service.impl;

import com.bizleap.marchant.domain.enums.TemperatureCatagory;
import com.bizleap.merchant.domain.entities.Product;

public class MediumHydratingPricing extends HydratingFruitPricing {
	
	public MediumHydratingPricing(Product product) {
		super(product);
	}

	@Override
	public void doPricing(TemperatureCatagory temperatureCateorty) {
		getProduct().setBasePrice(((getProduct().getWeight() * getProduct().getBasePrice())));
	}

}
