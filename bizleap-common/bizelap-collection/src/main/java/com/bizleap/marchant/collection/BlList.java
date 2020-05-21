package com.bizleap.marchant.collection;

public interface BlList<E> extends BlCollection<E> {

	public E get(int index);

	public int indexOf(Object o);
}
