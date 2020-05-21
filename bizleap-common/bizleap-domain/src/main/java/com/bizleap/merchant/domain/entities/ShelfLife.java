package com.bizleap.merchant.domain.entities;

import com.bizleap.merchant.service.impl.FlowerPricing;

public abstract class ShelfLife extends Flower {

	FlowerPricing flowerPricing;

	public ShelfLife(String name, double basePrice, double price, double weight, String unit, int expireDate,
			int storageDate) {
		super(name, basePrice, price, weight, unit, expireDate, storageDate);
	}

	public abstract void doPricing();
}
