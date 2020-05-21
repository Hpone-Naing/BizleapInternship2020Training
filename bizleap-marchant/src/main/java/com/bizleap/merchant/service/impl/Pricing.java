package com.bizleap.merchant.service.impl;

import com.bizleap.merchant.domain.entities.Product;

public abstract class Pricing {
	private Product product;

	public Pricing(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
