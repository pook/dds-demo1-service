package com.aec.demo.domain.kafka.sqlserver;

public class Entry<T, E> {
	T key;
	E value;
	public Entry(T key, E value) {
		super();
		this.key = key;
		this.value = value;
	}
	public T getKey() {
		return key;
	}
	public void setKey(T key) {
		this.key = key;
	}
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
}
