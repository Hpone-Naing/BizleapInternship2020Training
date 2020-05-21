package com.bizleap.training.oop.entities.assignments;

import java.util.List;

public abstract class DiscountAbstract {
	
	public abstract double getTotalPrice(List<Fruit> fruiitList);

	public abstract double calculateDiscount(Customer customer, Fruit fruit);
}
