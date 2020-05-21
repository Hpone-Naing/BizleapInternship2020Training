package com.bizleap.merchant.domain.entities;

import com.bizleap.merchant.service.impl.ShorterShelfLifePricing;

public class ShortShelfLife extends ShelfLife {

	public ShortShelfLife(String name, double basePrice, double price, double weight, String unit, int expireDate,
			int storageDate) {
		super(name, basePrice, price, weight, unit, expireDate, storageDate);
	}

	@Override
	public void doPricing() {
		setPricing(new ShorterShelfLifePricing(this));
		((ShorterShelfLifePricing) getPricing()).doPricing();
	}
}
