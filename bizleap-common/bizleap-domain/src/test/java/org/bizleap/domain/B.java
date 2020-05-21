package org.bizleap.domain;

import org.apache.log4j.chainsaw.Main;

public class B extends A {

	public B(int a, int b) {
		super(a);
		this.b = b;
	}

	int b;

	public int getB() {
		return b;
	}

	public static void main(String[] args) {
//		System.out.println(new B().b);
	}
}
