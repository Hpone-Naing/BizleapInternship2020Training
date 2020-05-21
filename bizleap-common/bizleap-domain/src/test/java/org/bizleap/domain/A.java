package org.bizleap.domain;

public abstract class A {

	int a;

	public A(int a) {
		this.a = a;
	}

	public void sum(int n1, int n2) {
		System.out.println(n1+n2);
	}
	
	public static void main(String[] args) {
		A a = new B(1,2);
		a.sum(1, ((B) a).getB());
	}
}
