package com.bizleap.merchant.service.impl;

import com.bizleap.marchant.domain.enums.TemperatureCatagory;
import com.bizleap.merchant.domain.entities.Product;

public class MostHydratingPricing extends HydratingFruitPricing{
	
	public MostHydratingPricing(Product product) {
		super(product);
	}

	@Override
	public void doPricing(TemperatureCatagory temperatureCateorty) {
		switch (temperatureCateorty) {
		case HIGH:
			getProduct().setPrice((getProduct().getWeight() * getProduct().getBasePrice()) + (getProduct().getWeight() * getProduct().getBasePrice() * .15));
			break;
		case LOW:
			getProduct().setPrice(getProduct().getBasePrice() - (getProduct().getBasePrice() * .15));
			break;
		default:
			getProduct().setPrice(getProduct().getBasePrice());
			break;
		}
	}

}
