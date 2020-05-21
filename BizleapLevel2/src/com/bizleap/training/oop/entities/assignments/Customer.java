package com.bizleap.training.oop.entities.assignments;

import java.util.List;

import com.bizleap.training.enums.CustomerType;

public class Customer {

	String name;
	CustomerType customertype;
	List<Fruit> fruitList;

	public Customer(String name) {
		this.name = name;
		this.customertype = CustomerType.REGULAR;
	}

	public Customer(String name, CustomerType customertype, List<Fruit> fruitList) {
		this(name);
		this.customertype = customertype;
		this.fruitList = fruitList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getCustomertype() {
		return customertype;
	}

	public void setCustomertype(CustomerType customertype) {
		this.customertype = customertype;
	}

	public List<Fruit> getFruitList() {
		return fruitList;
	}

	public void setFruitList(List<Fruit> fruitList) {
		this.fruitList = fruitList;
	}

	@Override
	public String toString() {
		return new StringBuffer()
				.append("name: " + name + ", customer type: " + customertype + ", fruit list: " + fruitList).toString();
	}
}
