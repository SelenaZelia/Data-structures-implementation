package com.zelia.ds.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Minimal implementation of a map
 * A map represents a data structure in which 
 * collections of unique key and collections 
 * of values are stored where each key is 
 * associated with one value. 
 */
public class CustomMap<K, V> {
	// Elements count
	private int size;
	private int DEFAULT_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private CustomEntry<K, V>[] values = new CustomEntry[DEFAULT_CAPACITY];

	public void Clear() {
		for (int i = 0; i < size; ++i) {
			values[i] = null;
			values = Arrays.copyOf(values, DEFAULT_CAPACITY);
		}
		size = 0;
	}

	/*
	 * Make sure there is no null element between two entry
	 */
	private void condenseArray(int start) {
		for (int i = start; i < size; ++i)
			values[i] = values[i + 1];
	}

	/*
	 * Return true if the map already got an entry using that key
	 */
	public boolean containsKey(K key) {
		for (int i = 0; i < size; ++i)
			if (values[i].getKey().equals(key))
				return true;
		return false;
	}

	/*
	 * Return true if the map already got an entry using that value
	 */
	public boolean containsValue(V value) {
		for (int i = 0; i < size; ++i)
			if (values[i].getValue().equals(value))
				return true;
		return false;
	}

	/*
	 * Verify that the array isn't full, if it is : double capacity
	 */
	private void ensureCapacity() {
		if (size == values.length) {
			int newSize = values.length * 2;
			values = Arrays.copyOf(values, newSize);
		}
	}

	/*
	 * Return the value associated to the key
	 */
	public V get(K key) {
		for (int i = 0; i < size; ++i)
			if (values[i] != null)
				if (values[i].getKey().equals(key))
					return values[i].getValue();
		return null;
	}

	/*
	 * Check that the array is empty > ? check all the array or just the size ?
	 * <
	 */
	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}

	/*
	 * Return the keyset
	 */
	public Set<K> keySet() {
		Set<K> set = new HashSet<>();
		for (int i = 0; i < size; ++i) {
			set.add(values[i].getKey());
		}
		return set;
	}

	/*
	 * Add a new entry
	 */
	public void put(K key, V value) {
		boolean insert = true;
		// if it already exists, just update the value
		for (int i = 0; i < size; ++i) {
			if (values[i].getKey().equals(key)) {
				values[i].setValue(value);
				insert = false;
			}
		}
		// else create a new one
		if (insert) {
			ensureCapacity(); // double the capacity if needed
			values[size++] = new CustomEntry<K, V>(key, value);
		}
	}

	/*
	 * Remove an entry
	 */
	public void remove(K key) {
		for (int i = 0; i < size; ++i) {
			if (values[i].getKey().equals(key)) {
				values[i] = null;
				size--;
				condenseArray(i);
			}
		}
	}

	/*
	 * Return the element count
	 */
	public int size() {
		return size;
	}

	/*
	 * Just used for testing
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < size; ++i) {
			s += values[i].getKey() + ": " + values[i].getValue() + " ; ";
		}
		return s;
	}
}
