// xgv3cj
//Christian Camacho
package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements List<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		this.head = new ListNode<T>(null);
		this.tail = new ListNode<T>(null);
		head.next = tail;
		head.prev = null;
		tail.prev = head;
		tail.next = null;
		this.size = 0;
		
// go through while loop with a counter until it reaches null, return counter
	}
	
	public int size() {
		return this.size;
	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {
		this.head.next = this.tail;
		this.tail.prev = this.head;
		this.size = 0;
		/* TODO: Implement this method */  
	}
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
			ListNode <T> newNode = new ListNode<T>(data);
			newNode.next = tail;
			newNode.prev = tail.prev;
			tail.prev.next = newNode;
			tail.prev = newNode;
			this.size++;
		}	
		/* TODO: Implement this method */  
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
			newNode.prev = head;
			newNode.next = head.next;
			head.next.prev = newNode;
			head.next = newNode; 
			size ++;
		/* TODO: Implement this method */  
	}
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		ListNode<T> newNode = head.next;
		ListNode<T> newNode2 = new ListNode<T>(data);
			for (int i = 0; i <= index - 1; i++) {
				newNode = newNode.next;
			}
		newNode2.next = newNode;
		newNode2.prev = newNode.prev;
		
		newNode.prev.next = newNode2;
		newNode.prev = newNode2;
		size++;
//		insert(ListIterator,(data));

		}
	
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		ListNode<T> previousNode = it.curNode;
		ListNode<T> currentNode = new ListNode<T>(data);
		ListNode<T> nextNode = it.curNode.next;
		currentNode.prev = previousNode;
		currentNode.next = nextNode;
		nextNode.prev = currentNode;
		previousNode.next = currentNode;
		
		size++;
	}
	
	public T removeAtTail(){
		if(this.size == 0) {
			return null;
		}
		if(this.size > 1) {
		ListNode<T> newNode = tail.prev;
		newNode.prev.next = tail;
		tail.prev = newNode.prev;
		size--;
		return newNode.getData();
		}
		return null;
		/* TODO: Implement this method */  
	}
	
	public T removeAtHead(){
		if(this.size == 0) {
			return null;
		}
		ListNode<T> newNode = head.next;
		head = head.next;
		head.prev = null;
		size--;
		
		return newNode.getData();
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		if(size == 0) {
			return null;
		}
		ListNode<T> itposition = it.curNode;
		itposition.next.prev = itposition.prev;
		itposition.prev.next = itposition.next;
		itposition = it.curNode.next;
		size--;
		return itposition.getData();
		
}
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		if (size == 0) {
			return -1;
		}
		ListNode<T> newNode = head.next;
		for (int i = 0; i < size; i ++) {
			if(data.equals(newNode.getData())) {
				return i;
			}
			newNode = newNode.next;
		}
		return -1;
		}
		
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) { 
		if (index > this.size | size == 0) {
			return null;
		}
		ListNode <T> newNode = head.next;
		for(int i = 0; i < index; i ++){
			newNode = newNode.next;
		}
			T value = newNode.getData();
			
		return value;
		}

	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){
		ListIterator<T> firstNode = new ListIterator<T>(head.next);
			return firstNode;
}
	public ListIterator<T> back(){
		ListIterator<T> lastNode = new ListIterator<T>(tail.prev);
			return lastNode;
		
	}
	
	
}

