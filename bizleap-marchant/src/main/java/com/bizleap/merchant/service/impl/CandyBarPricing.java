package com.bizleap.merchant.service.impl;

import com.bizleap.marchant.domain.enums.SeasonCategory;
import com.bizleap.merchant.domain.entities.Product;

public abstract class CandyBarPricing extends Pricing {

	public CandyBarPricing(Product product) {
		super(product);
	}

	public abstract void doPricing(SeasonCategory seasonCategory);

}
