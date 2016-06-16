package com.zelia.ds.stack;

import java.util.Arrays;

public class CustomStack<E> {
	private int size = 0;
	private final int DEFAULT_CAPACITY = 16;
	private Object elements[];

	public CustomStack() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void push(E e) { 
		if (size == elements.length)
			ensureCapacity(); 
		elements[size++] = e; 
	}

	public E pop() {
		@SuppressWarnings("unchecked")
		E e = (E) elements[--size];
		elements[size] = null;
		return e;
	}

	private void ensureCapacity() { 
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}
	
	public int getSize(){
		return size;
	}
}
