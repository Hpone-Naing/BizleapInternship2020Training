package com.bizleap.merchant.domain.entities;

import com.bizleap.merchant.service.LongShelfLifePricing;

public class LongShelfLife extends ShelfLife {

	public LongShelfLife(String name, double basePrice, double price, double weight, String unit, int expireDate,
			int storageDate) {
		super(name, basePrice, price, weight, unit, expireDate, storageDate);
	}

	@Override
	public void doPricing() {
		setPricing(new LongShelfLifePricing(this));
		((LongShelfLifePricing) getPricing()).doPricing();
	}

}
