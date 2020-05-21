package com.bizleap.assignment32.entities;

import java.util.List;

public abstract class DiscountAbstract {
	
	public abstract double getTotalPrice(List<Fruit> fruiitList);

	public abstract double calculateDiscount(Customer customer, Fruit fruit);
}
