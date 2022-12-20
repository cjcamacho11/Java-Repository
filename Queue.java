//xgv3cj
//Christian Camacho
package queue;

/* You SHOULD use your custom built linked list for this */
import list.LinkedList;

/**
 * A Linked-List based Queue
 *
 * @param <T>
 */
public class Queue<T> implements IQueue<T>{

	private LinkedList<T> list;
	
	/**
	 * Constructor: Initialize the inner list
	 */
	public Queue(){
		/* TODO: Implement this method */  
		list = new LinkedList<T>();
	}
	
	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() { 
		return list.size();
	}
	
	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		list.insertAtTail(data);
		/* TODO: Implement this method */  
		/* Hint: Which method in LinkedList.java already accomplishes this? */ 
	}
	
	/**
	 * Simply remove data from the head of the list, throw exception if list is empty.
	 */
	public T dequeue(){	
		if (list.size() == 0) {
		throw new IllegalStateException();
		}
		return list.removeAtHead();
		/* TODO: Implement this method */  
		/* Hint: Which method in LinkedList.java already accomplishes this? */  
	}
	
}
