package com.bizleap.training.oop.entities.assignments;

import java.util.List;

import com.bizleap.training.enums.CustomerType;

public class DiscountCalculation extends DiscountAbstract {

	@Override
	public double calculateDiscount(Customer customer, Fruit fruit) {
		double totalPrice = getTotalPrice(customer.getFruitList());
		if (customer.getCustomertype().equals(CustomerType.VALUED))
			return (totalPrice - (totalPrice * 0.1));
		if (customer.getCustomertype().equals(CustomerType.VOLUMED) && totalWeight(customer.getFruitList()) > 100) {
			return (fruit.getBasePrice() - (fruit.getBasePrice() * 0.15));
		}
		return fruit.getBasePrice();
	}

	@Override
	public double getTotalPrice(List<Fruit> fruiitList) {
		double totalPrice = 0.0;
		for (Fruit fruit : fruiitList) {
			totalPrice += fruit.getPrice();
		}
		return totalPrice;
	}

	private double totalWeight(List<Fruit> fruitList) {
		double totalWeight = 0.0;
		for (Fruit fruit : fruitList) {
			totalWeight += fruit.getWeight();
		}
		return totalWeight;
	}
}