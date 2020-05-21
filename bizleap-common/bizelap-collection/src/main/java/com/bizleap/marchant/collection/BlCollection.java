package com.bizleap.marchant.collection;

public interface BlCollection<E> extends Iterable<E> {

	public boolean add(Object obj);

	public boolean remove(Object obj);

	public boolean isEmpty();

	public boolean contains(Object obj);

	public int size();

	public void clear();
	
	public boolean equals(Object o);
	
	public int hashCode();
	
}
