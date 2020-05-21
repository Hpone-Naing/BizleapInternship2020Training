package com.bizleap.merchant.domain.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Flower extends Product {

	private int storageDate;
	private int expireDate;

	public Flower(String name, double basePrice, double price, double weight, String unit) {
		super(name, basePrice, price, weight, unit);
	}

	public Flower(String name, double basePrice, double price, double weight, String unit, int expireDate,
			int storageDate) {
		super(name, basePrice, price, weight, unit);
		this.expireDate = expireDate;
		this.storageDate = storageDate;
	}

	public int getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(int storageDate) {
		this.storageDate = storageDate;
	}

	public int getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(int expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(storageDate).append(expireDate).toString();
	}
}
