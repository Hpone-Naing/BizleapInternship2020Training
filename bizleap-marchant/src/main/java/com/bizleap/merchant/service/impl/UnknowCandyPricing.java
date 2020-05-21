package com.bizleap.merchant.service.impl;

import com.bizleap.marchant.domain.enums.SeasonCategory;
import com.bizleap.merchant.domain.entities.Product;

public class UnknowCandyPricing extends CandyBarPricing {

	public UnknowCandyPricing(Product product) {
		super(product);
	}

	@Override
	public void doPricing(SeasonCategory seasonCategory) {
		switch (seasonCategory) {
		case SUMMER:
			getProduct().setPrice(getProduct().getBasePrice() + (getProduct().getBasePrice() * 12));
			break;
		case RAINING:
			getProduct().setPrice(getProduct().getBasePrice() - (getProduct().getBasePrice() * 12));
			break;
		default:
			getProduct().setPrice(getProduct().getBasePrice());
			break;
		}
	}
}