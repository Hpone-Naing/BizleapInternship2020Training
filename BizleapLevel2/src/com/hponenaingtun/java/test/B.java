package com.hponenaingtun.java.test;

import java.util.List;

public class B extends A {

	public B(String name) {
		super(name);
	}

	public void serve(List<B> b) {
		System.out.println(b);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	
}
