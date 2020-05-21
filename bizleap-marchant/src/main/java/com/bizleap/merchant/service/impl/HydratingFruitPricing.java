package com.bizleap.merchant.service.impl;

import com.bizleap.marchant.domain.enums.TemperatureCatagory;
import com.bizleap.merchant.domain.entities.Product;

public abstract class HydratingFruitPricing extends Pricing {

	public HydratingFruitPricing(Product product) {
		super(product);
	}

	public abstract void doPricing(TemperatureCatagory temperatureCateorty);
}
