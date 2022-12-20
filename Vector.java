// xgv3cj
//Christian Camacho
package vector;

import java.util.Arrays;

public class Vector<T> implements List<T> {

	private T[] itemArray;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;
	private T[] newArray;
	public Vector() {
		this(INITIAL_CAPACITY);  // calls the other constructor that takes an int parameter
	}

	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.itemArray = (T[]) new Object[capacity];
		this.size = 0;
	}

	public int capacity() {
		
		return this.itemArray.length;
	}

	/**
	 * When the underlying array fills up, we need to somehow resize it to accommodate the
	 * Vectors's elements.
	 * Ignores the request if the requested new capacity is too small to fit the elements
	 * already in the Vector
	 */
	public void resize(int newCapacity) {
		if(newCapacity <= size) {
			return;
		}
		else if(newCapacity > size()) {
			this.newArray = (T[]) new Object[newCapacity];
			for(int i = 0; i < this.size(); i++) {
			newArray[i] = itemArray[i];
			
			}
		this.itemArray = newArray;}

		}
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		this.size = 0;
	}

	@Override
	public void insertAtTail(T item) {
		if(this.size == this.capacity()) {
			resize(this.capacity()*2);
		}
		resize(this.size);
		this.itemArray[size] = item;
		size++;

	}

	@Override
	public void insertAtHead(T item) {
		insertAt(0, item);
	}

	@Override
	public void insertAt(int index, T item) {
		if(index < 0 || index > size) {
			return;}
		if (this.size == this.capacity()) {
			resize(this.capacity()*2);
		}
		for(int i = size; i >= index +1; i--) {
			this.itemArray[i] = this.itemArray[i-1];
		}
		this.itemArray[index] = item;
		size++;
	}

	@Override
	public T removeAtTail() {
		if(size() != 0) {
			size--;
			return itemArray[size];
				
			}
		return null;
		}
		

	@Override
	public T removeAtHead() {
		if(size() != 0) {
			T head = itemArray[0];
			for(int i = 0; i <= size(); i++) {
				itemArray[i] = itemArray[i + 1];
			}
			size--;
			return head;
		}
		return null;
	}

	@Override
	public int find(T item) {
		for(int i = 0; i < this.size(); i ++) {
			if(this.itemArray[i].equals(item)) {
				return i;
			}
		}
	return -1;
	}

	@Override
	public T get(int index) {
		if(index >= 0 && index <= size()) {
			T value = this.itemArray[index];
			return value;
		}
		return null;
	}
		// TODO: Implement this method
	

	/*
	 * This toString() method allow you to print a nicely formatted version of your Vector. E.g.
	 *     System.out.println( myVector );
	 * It uses utility methods in the Java Arrays library.
	 */
	@Override
	public String toString() {
//		return Arrays.toString(this.itemArray); // prints entire array from 0 to capacity-1
		return Arrays.toString(Arrays.copyOfRange(this.itemArray, 0, this.size)); // prints from 0 to size-1
	}

}
