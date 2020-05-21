package com.bizleap.merchant.domain.entities;

import java.time.LocalDate;
import java.util.Arrays;

import com.bizleap.marchant.domain.enums.CustomerType;
import com.bizleap.merchant.domain.enums.ProductType;

public class PurchaseRecord {

	Customer customer;
	Product product;
	LocalDate date;
	double quantity;
	double price;

	public PurchaseRecord() {

	}

	public PurchaseRecord(Customer customer, Product product, LocalDate date, double quantity, double price) {
		this.customer = customer;
		this.product = product;
		this.date = date;
		this.quantity = quantity;
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static PurchaseRecord parsePurchaseRecord(String dataLine) {
		PurchaseRecord purchaseRecord = new PurchaseRecord();
		Customer customer = new Customer();
		Product product = new Product();
		
		String[] tokens = dataLine.split(";");
		customer.setName((tokens[0].trim()));
		customer.setCustomertype(CustomerType.valueOf(tokens[1].trim()));
		purchaseRecord.setCustomer(customer);
		purchaseRecord.setDate(LocalDate.parse(tokens[2].trim()));
		product.setName(tokens[3].trim());
		product.setProductType(ProductType.valueOf(tokens[4].trim()));
		purchaseRecord.setProduct(product);
		purchaseRecord.setQuantity(Double.parseDouble(tokens[5]));
		purchaseRecord.setPrice(Double.parseDouble(tokens[6]));
		return purchaseRecord;
	}

	@Override
	public String toString() {
		return "PurchaseRecord [customer=" + customer + ", product=" + product + ", date=" + date + ", quantity="
				+ quantity + ", price=" + price + "]";
	}

}
