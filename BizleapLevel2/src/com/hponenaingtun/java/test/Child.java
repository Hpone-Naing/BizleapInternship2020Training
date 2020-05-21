package com.hponenaingtun.java.test;

public class Child extends Parent1 {

	public void show() {
		System.out.println("this is child");
	}

	public static void main(String[] args) {
		Parent p = new Child();
		((Child) p).show();
	}
}
