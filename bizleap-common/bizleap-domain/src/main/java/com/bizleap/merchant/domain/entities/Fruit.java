package com.bizleap.merchant.domain.entities;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Fruit extends Product{

	private double basePrice;
	private String name;
	private double price;
	private double weight;
	private String unit;

	public Fruit() {
	}

	public Fruit(String name) {
		this.name = name;
		this.price = 1;
	}

	public Fruit(String name, double basePrice, double weight, String unit) {
		this(name);
		this.basePrice = basePrice;
		this.price = basePrice;
		this.weight = weight;
		this.unit = unit;
	}

	public Fruit(String name, double basePrice, double price, double weight, String unit) {
		this(name);
		this.basePrice = basePrice;
		this.price = price;
		this.weight = weight;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getFruitType() {
		return this.getClass().toString().substring(6);
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public boolean isContainFruit(List<Fruit> fruitList) {
		for (Fruit fruit : fruitList) {
			if (fruitList.contains(fruit))
				return true;
		}
		return false;
	}

	public void doPricing(Purchase purchase) {
		switch (purchase.getCustomer().getCustomertype()) {
		case VALUED:
			this.price = this.basePrice;
			purchase.setTotalPrice(purchase.getTotalPrice());
			purchase.setDiscountTotalPrice(((purchase.getTotalPrice() - purchase.getTotalPrice() * 0.15)));
			break;

		case VOLUMED:
			if (purchase.getTotalWeight() > 100 && purchase.getFruitList().contains(this)) {
				this.price = (this.basePrice - this.basePrice * 0.1);
				purchase.setTotalPrice(purchase.getTotalPrice());
				purchase.setDiscountTotalPrice(purchase.getDiscountTotalPrice() + price);
			}
			break;

		default:
			this.price = (this.basePrice);
			purchase.setTotalPrice(purchase.getTotalPrice());
			purchase.setDiscountTotalPrice(purchase.getTotalPrice());
			break;
		}
	}

	@Override
	public int hashCode() {
		return 7 * 1 + (name.hashCode() * Double.valueOf(price).hashCode());
	}

	@Override
	public boolean equals(Object instance) {
		if (this.getClass() != instance.getClass() || instance == null || !(instance instanceof Fruit))
			return false;
		Fruit fruit = (Fruit) instance;
		return this.hashCode() == fruit.hashCode() && this.name.equals(fruit.name) && this.price == fruit.price;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name: ", name).append("price: ", price).append("dollors per pond")
				.toString();
	}
	
	public static void main(String[] args) {
		Fruit f1 = new Fruit("mgmg");
		Fruit f2 = new Fruit("mgmg");
		System.out.println(f1.equals(f2));
	}
}