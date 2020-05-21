package com.bizleap.merchant.domain.entities;

import java.util.List;

public class Purchase {

	private Customer customer;
	private List<Fruit> fruitList;
	private double totalPrice;
	private double discountTotalPrice;

	public Purchase(Customer customer, List<Fruit> fruitList, double totalPrice) {
		this.customer = customer;
		this.fruitList = fruitList;
		this.totalPrice = totalPrice;
	}

	public Purchase(Customer customer, List<Fruit> fruitList, double totalPrice, double discountTotalPrice) {
		this.customer = customer;
		this.fruitList = fruitList;
		this.totalPrice = totalPrice;
		this.discountTotalPrice = discountTotalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Fruit> getFruitList() {
		return fruitList;
	}

	public void setFruitList(List<Fruit> fruitList) {
		this.fruitList = fruitList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public double getDiscountTotalPrice() {
		return discountTotalPrice;
	}

	public void setDiscountTotalPrice(double discountTotalPrice) {
		this.discountTotalPrice = discountTotalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalWeight() {
		double totalWeight = 0.0;
		for (Fruit fruit : fruitList) {
			totalWeight += fruit.getWeight();
		}
		return totalWeight;
	}
}