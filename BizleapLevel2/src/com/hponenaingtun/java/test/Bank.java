package com.hponenaingtun.java.test;

public class Bank {
	
	Customer c = new Customer("mg mg");
	public void display() {
		System.out.println(c.name);
	}

	public static void main(String[] args) {
		Bank b = new Bank();
		b.display();
	}
}
