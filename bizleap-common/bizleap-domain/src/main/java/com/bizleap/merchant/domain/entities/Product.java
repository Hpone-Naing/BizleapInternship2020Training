package com.bizleap.merchant.domain.entities;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.merchant.domain.enums.ProductType;
import com.bizleap.merchant.service.impl.Pricing;

public class Product extends AbstractEntity {

	private double basePrice;
	private double price;
	private double weight;
	private String unit;
	private ProductType productType;
	private Pricing pricing;

	public Product() {

	}

	public Product(String name) {
		super(name);
	}

	public Product(String name, double basePrice, double weight, String unit) {
		super(name);
		this.basePrice = basePrice;
		this.price = basePrice;
		this.weight = weight;
		this.unit = unit;
	}

	public Product(String name, double basePrice, double price, double weight, String unit) {
		super(name);
		this.basePrice = basePrice;
		this.price = price;
		this.weight = weight;
		this.unit = unit;
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

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public boolean isContainFruit(List<Fruit> fruitList) {
		for (Fruit fruit : fruitList) {
			if (fruitList.contains(fruit))
				return true;
		}
		return false;
	}

	public Pricing getPricing() {
		return pricing;
	}

	public void setPricing(Pricing pricing) {
		this.pricing = pricing;
	}

	public void doPricing(Purchase purchase) {
		switch (purchase.getCustomer().getCustomertype()) {
		case VALUED:
			this.price = this.basePrice;
			System.out.println("in fruit method : check price " + price);
			purchase.setTotalPrice(purchase.getTotalPrice());
			purchase.setDiscountTotalPrice(((purchase.getTotalPrice() - purchase.getTotalPrice() * 0.15)));
			break;

		case VOLUMED:
			if (purchase.getTotalWeight() > 100 && purchase.getFruitList().contains(this)) {
				this.price = (this.basePrice - this.basePrice * 0.1);
				System.out.println("in fruit method : check price " + price);
				purchase.setTotalPrice(purchase.getTotalPrice());
				purchase.setDiscountTotalPrice(purchase.getDiscountTotalPrice() + price);
			}
			break;

		default:
			this.price = (this.basePrice);
			System.out.println("in fruit method : check price " + price);
			purchase.setTotalPrice(purchase.getTotalPrice());
			purchase.setDiscountTotalPrice(purchase.getTotalPrice());
			break;
		}
	}

	@Override
	public int hashCode() {
		return 7 * 1 + (Double.valueOf(price).hashCode());
	}

	@Override
	public boolean equals(Object instance) {
		if (this.getClass() != instance.getClass() || instance == null || !(instance instanceof Fruit))
			return false;
		Product product = (Product) instance;
		return this.hashCode() == product.hashCode() && this.price == product.price;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("price: ", price).append("dollors per pond").toString();
	}
}
