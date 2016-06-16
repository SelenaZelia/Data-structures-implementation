package com.zelia.ds.map;

public class CustomEntry<K,V> {
	private final K key;
	protected V value;
	
	public CustomEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey(){
		return key;
	}
	
	public V getValue(){
		return value;
	}
	
	public void setValue(V value){
		this.value = value;
	}
}
