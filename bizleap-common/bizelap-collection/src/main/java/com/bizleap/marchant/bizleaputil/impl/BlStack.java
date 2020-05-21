package com.bizleap.marchant.bizleaputil.impl;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

import com.bizleap.marchant.collection.BlList;

public class BlStack<E> implements BlList<E> {

	Object items[] = null;
	int size = -1;
	int length = 1;
	int index = 0;

	public BlStack() {
		this.items = new Object[length];
	}

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

	@Override
	public boolean add(Object o) throws ArrayIndexOutOfBoundsException {
		if (isFull())
			resize();
		items[++size] = o;
		index++;
		return true;
	}

	private boolean isFull() {
		return size() > items.length - 1;
	}

	private void resize() {
		length = size() + 1;
		items = Arrays.copyOf(items, length);
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
		size = -1;
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

	public E push(E item) {
		add(item);
		return item;
	}

	public E pop() {
		if (!empty()) {
			int lastIndex = size--;
			E item = (E) items[lastIndex];
			items[lastIndex] = null;
			index--;
			return item;
		}
		throw new EmptyStackException();
	}

	public E peek() {
		if (!empty()) {
			return (E) items[size--];
		}
		throw new EmptyStackException();
	}

	public boolean empty() {
		return size <= -1;
	}

	@Override
	public int hashCode() {
		return 7 * 1 + (items.hashCode());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof BlArrayList) || this.getClass() != o.getClass())
			return false;
		BlStack<E> originalObject = (BlStack<E>) o;
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
		BlStack<Integer> blStack = new BlStack<Integer>();
		blStack.push(4);
		blStack.push(5);
		blStack.push(6);
//		System.out.println(blStack.pop());
//		System.out.println(blStack.pop());
//		System.out.println(blStack.pop());
//		System.out.println(blStack.pop());
		System.out.println(blStack.peek());
		System.out.println(blStack.peek());
		System.out.println(blStack.peek());

		System.out.println("size: " + blStack.size());
		System.out.println(blStack);

	}
}
