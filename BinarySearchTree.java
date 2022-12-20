package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, root);
	}
	
	/**
	 * Helper method for inserting recursively
	 * @param data
	 * @param curNode
	 * @return a reference to the new root of the subtree
	 */
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		if(curNode == null) {
			return new TreeNode<T>(data);
		}
		else if(data.compareTo(curNode.data) < 0) {
			curNode.left = insert(data,curNode.left);
		}
		else if(data.compareTo(curNode.data) > 0) {
			curNode.right = insert(data,curNode.right);
		}
		return curNode;
	}


	/**
	 * Returns a boolean (true of false) if the element was found in a BST
	 */
	@Override
	public boolean find(T data) {
		return find(data, root);
	}
	
	// Helper method
	private boolean find(T data, TreeNode<T> curNode) {
		if(curNode == null) {   //checking root
			return false;
		}
			while (curNode != null) {
				if(data.compareTo(curNode.data) == 0){
				return true;
			}
				else if(data.compareTo(curNode.data) < 0) {
					curNode = curNode.left;
				}
				else if(data.compareTo(curNode.data) > 0) {
					curNode = curNode.right;
				}
			}
	return false;
	}	
	/**
	 * Returns the max item in the given subtree
	 */
	public T findMax() {
		return findMax(this.root);
	}
	
	// Helper method
	private T findMax(TreeNode<T> curNode) {
		while (curNode.right != null) {
			curNode = curNode.right;
		}
		return curNode.data;

	}
	
	//-----------------------------------------------------------------------------
	//EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU: (Don't change anything!)
	//WE HAVE IMPLEMENTED THE REMOVE METHOD FOR YOU
	//YOU SHOULD STILL LOOK AT THIS CODE AND TRY YOUR BEST TO UNDERSTAND IT
	//-----------------------------------------------------------------------------

	@Override
	public void remove(T data) {
		this.root = remove(data, root); // Call remove at the root of the tree
	}
	
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		/* Note the use of compareTo() in the solution! */ 
		
		if(curNode == null) return curNode;
		// if item I want to remove is smaller than the data of the current node...
		else if (data.compareTo(curNode.data) < 0) { 
			curNode.left = remove(data, curNode.left); // recursively call remove on LEFT subtree
		}
		// if item I want to remove is larger than the data of the current node...
		else if (data.compareTo(curNode.data) > 0) {
			curNode.right = remove(data, curNode.right); // recursively call remove on RIGHT subtree
		}
		else { /* Found it, time to remove */
			if(curNode.left == null && curNode.right == null)		return null;
			else if(curNode.left != null && curNode.right == null)	return curNode.left;
			else if(curNode.left == null && curNode.right != null)	return curNode.right;
			else {
				T toDel = findMax(curNode.left);
				curNode.data = toDel;
				curNode.left = remove(toDel, curNode.left);
				return curNode;
			}	
		}
		return curNode;
	}	
	
	
}
