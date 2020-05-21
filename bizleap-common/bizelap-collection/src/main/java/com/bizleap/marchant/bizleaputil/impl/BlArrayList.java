package com.bizleap.marchant.bizleaputil.impl;

import java.util.Arrays;
import java.util.Iterator;

import com.bizleap.marchant.collection.BlList;

public class BlArrayList<E> implements BlList<E> {

	private Object items[];
	private int index = 0;
	private int size = 1;

	private class BLIterator implements Iterator<E> {

		int counter = 0;
		int max = size();

		@Override
		public boolean hasNext() {
			return counter < max;
		}

		@Override
		public E next() {
			if (items[counter] == null)
				return null;
			return (E) items[counter++];
		}
	}

	public BlArrayList() {
		items = new Object[size];
	}

	public BlArrayList(E[] items) {
		this.items = items;
	}

	@Override
	public boolean add(Object o) throws IndexOutOfBoundsException {
		if (index > items.length - 1)
			resize();
		items[index++] = o;
		return true;
	}

	private void resize() {
		items = Arrays.copyOf(items, size() + 1);
	}

	@Override
	public boolean remove(Object o) throws ClassCastException, NullPointerException, UnsupportedOperationException {
		for (int i = 0; i < size(); i++) {
			if (items[i].equals(o)) {
				changeItemsPosition(i);
				index--;
				return true;
			}
		}
		return false;
	}

	private void changeItemsPosition(int removedIndex) {
		System.arraycopy(Arrays.copyOfRange(items, 0, removedIndex), 0, items, 0, removedIndex);
		System.arraycopy(Arrays.copyOfRange(items, removedIndex + 1, size()), 0, items, removedIndex,
				(size() - 1) - removedIndex);
	}

	@Override
	public boolean isEmpty() {
		return items == null || (size <= 0 && items[0] == null);
	}

	@Override
	public boolean contains(Object o) {
		for (Object o1 : items) {
			if (o1 == null && o == null)
				return true;
			if (o1.equals(o))
				return true;
		}
		return false;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public void clear() {
		size = 1;
		index = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new BLIterator();
	}

	@Override
	public E get(int index) {
		if (index < size())
			return (E) items[index];
		return null;
	}

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < items.length; i++) {
			if (o.equals(items[i]))
				return i;
		}
		return -1;
	}

	@Override
	public int hashCode() {
		return 7 * 1 + (items.hashCode());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof BlArrayList) || this.getClass() != o.getClass())
			return false;
		BlArrayList<E> originalObject = (BlArrayList<E>) o;
		if (this.size() != originalObject.size())
			return false;
		for (int i = 0; i < size(); i++) {
			if (!this.items[i].equals(originalObject.items[i]))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		if (isEmpty())
			return null;
		for (int i = 0; i < size(); i++) {
			buffer.append(items[i]).append(",");
		}
		if (buffer.substring(1).length() <= 0)
			return "[]";
		return buffer.insert(buffer.length() - 1, "]").substring(0, buffer.length() - 1).toString();
	}

	public static void main(String[] args) {
		BlList<Integer> blInteger1 = new BlArrayList<>();
		blInteger1.add(1);
		blInteger1.add(2);
		BlArrayList<Integer> blArrayList2 = new BlArrayList<>();
		blArrayList2.add(1);
		blArrayList2.add(2);
		System.out.println(blInteger1.equals(blArrayList2));
	}
}
