package com.bizleap.training.oop.entities.assignments;

import java.util.List;

public class Fruit {

	private double basePrice;
	private String name;
	private double price;
	private double weight;
	private String unit;

	public Fruit(String name) {
		this.name = name;
		this.price = 1;
	}

	public Fruit(String name, double price, double weight, String unit) {
		this(name);
		this.basePrice = price;
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

	public String toString() {
		return new StringBuilder().append("name: " + name).append(", based price: " + price).append(", price: " + price)
				.append(", weight: " + weight).toString();
	}
	// @Override
	// public String toString() {
	// return new ToStringBuilder(this).append("name: ", name).append("price: ",
	// price).append("dollors per pond")
	// .toString();
	// }
}