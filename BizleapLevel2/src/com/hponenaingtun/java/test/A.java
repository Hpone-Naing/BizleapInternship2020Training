package com.hponenaingtun.java.test;

import java.util.ArrayList;
import java.util.List;

public class A {

	private String name;
	private List<? super A> aList = null;
	
	
	public A() {
		super();
	}

	public A(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public List<? super A> getaList() {
		if(aList == null)
			aList = new ArrayList<>();
		return aList;
	}

	public void setaList(List<? super A> aList) {
		this.aList = aList;
	}

	public void arrive(List<A> a) {
		System.out.println(a);
	}
	
	@Override
	public String toString() {
		return "A [name=" + name + "]";
	}
	
	
}
