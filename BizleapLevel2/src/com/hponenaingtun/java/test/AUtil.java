package com.hponenaingtun.java.test;

public class AUtil {

	public static void main(String[] args) {
		A a = new A();
		B b1= new B("a");
		a.getaList().add(new B("b"));
		System.out.println(a.getaList().get(0));
	}
}
