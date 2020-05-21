package com.bizleap.training.assignments;

public class MyBox<T> {
	
	private T item;

	public MyBox() {
		
	}
	
	public MyBox(T item) {
		this.item = item;
	}
	
	public T getObj() {
		return item;
	}

	public void setObj(T item) {
		this.item = item;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(item).toString();
	}
}