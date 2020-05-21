package com.bizleap.merchant.service.impl;

import com.bizleap.merchant.domain.entities.Product;

public abstract class FlowerPricing extends Pricing{

	public FlowerPricing(Product product) {
		super(product);
	}

	public abstract void doPricing();

}
