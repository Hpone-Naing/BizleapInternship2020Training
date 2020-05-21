package com.bizleap.merchant.domain.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.marchant.domain.enums.CustomerType;

public class Customer {

	String name;
	CustomerType customertype;

	
	public Customer() {
	}

	public Customer(String name, CustomerType customerType) {
		this(name);
		this.customertype = customerType;
	}

	public Customer(String name) {
		this.name = name;
		this.customertype = CustomerType.REGULAR;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name: ", name).append("customertype: ", customertype).toString();
	}
}
