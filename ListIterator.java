package list;

public class ListIterator<T> {
	
	/* Current node (of type ListNode) */
	protected ListNode<T> curNode; 
	
/* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) {
		this.curNode = currentNode;
	}
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() { 
		if(curNode.next == null) {
			return true;
		}
		return false;
	}
	
	public boolean isPastBeginning() { 
		if(curNode.prev == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		if (!(this.isPastEnd()) & !(this.isPastBeginning())) {
			T value = this.curNode.getData();
			return value;
		}
		
		return null;
		/* Hint: Remember to first validate the position of the Iterator */
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() {
		if(!(this.isPastEnd())) {
			this.curNode = curNode.next;
		}
		/* Hint: Remember to check IF you can move forward before you do! */
		/*       (Otherwise, do not move at all) */
	}
	
	public void moveBackward() { 
		if(!(this.isPastBeginning())) {
			this.curNode = curNode.prev;
		/* Hint: Remember to check IF you can move backwards before you do! */
		/*       (Otherwise, do not move at all) */
		}
	}
}

