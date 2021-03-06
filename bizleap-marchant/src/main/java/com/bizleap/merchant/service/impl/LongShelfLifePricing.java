package com.bizleap.merchant.service.impl;

import com.bizleap.merchant.domain.entities.Flower;
import com.bizleap.merchant.domain.entities.Product;

public class LongShelfLifePricing extends FlowerPricing {

	public LongShelfLifePricing(Product product) {
		super(product);
	}

	@Override
	public void doPricing() {
		if (((Flower) getProduct()).getStorageDate() > ((Flower) getProduct()).getExpireDate())
			getProduct().setPrice(0);
		else
			for (int previorsDate = 1; previorsDate <= ((Flower) getProduct()).getStorageDate(); previorsDate++) {
				getProduct().setPrice(getProduct().getPrice() - getProduct().getPrice() * 0.1);
			}
	}
}
