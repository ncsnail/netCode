package org.wind.pro.util;

public class Pair<T,U> {
	
	private T first;
	private T second;
	
	private U third;
	
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public T getSecond() {
		return second;
	}
	public void setSecond(T second) {
		this.second = second;
	}
	
	
	public <E extends Comparable> E getTeset(E a){
		return a;
	}

	
}
