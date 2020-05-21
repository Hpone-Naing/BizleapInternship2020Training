package com.bizleap.merchant.domain.entities;

import com.bizleap.merchant.service.impl.MediumShelfLifePricing;

public class MediumShelfLife extends ShelfLife {



	public MediumShelfLife(String name, double basePrice, double price, double weight, String unit, int expireDate,
			int storageDate) {
		super(name, basePrice, price, weight, unit, expireDate, storageDate);
	}

	@Override
	public void doPricing() {
		setPricing(new MediumShelfLifePricing(this));
		((MediumShelfLifePricing) getPricing()).doPricing();
	}
}
