package tree;


/**
 * Self-balancing AVL Tree
 * @author CS 2100 Team
 *
 * @param <T>
 */
 
 // Don't worry about this class for the first assignment in the module.
 // You WILL use this class in the second assignment on AVL trees.

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		curNode = super.insert(data, curNode);
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		curNode = balance(curNode);
		return curNode;
	}
	
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//right heavy
		if (balanceFactor(curNode) > 1) { 
			if(balanceFactor(curNode.right) >= 0) {
				 curNode = rotateLeft(curNode);
			 }
			else {
			 	curNode.right = rotateRight(curNode.right);
			 	curNode = rotateLeft(curNode);
			 	}
		}
		//printTree();
		//left heavy
		if(balanceFactor(curNode) < -1) {  
			 if(balanceFactor(curNode.left) <= 0) {
				 curNode = rotateRight(curNode);
			 }
			 else {
			 	curNode.left = rotateLeft(curNode.left);
			 	curNode = rotateRight(curNode);
			 }
		}
		//printTree();
		return curNode;
	}

	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		if(curNode == null) {
			return null;
		}
		TreeNode<T> newRoot = curNode.left; 
		curNode.left = newRoot.right;
		newRoot.right = curNode;
		
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right))+1;

		return newRoot; //new root
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		if(curNode == null) {
			return null;
		}
		TreeNode<T> newRoot = curNode.right;
		curNode.right = newRoot.left;
		newRoot.left = curNode;
		
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right))+1;

		return newRoot; // new root
	}
	
	private int balanceFactor(TreeNode<T> node) {
		if (node == null) {
			return 0;
		}
		else {
		return height(node.right) - height(node.left);
		}
	}
	
	@Override
	public void remove(T data) {
//	* Call remove starting at the root of the tree /
	this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
//	* Call BST remove before balancing, use “super” to achieve this /
	curNode = super.remove(data, curNode);
//	* Handle the case when remove returns null /
	if(curNode == null) {
		return null;
	}
//	* update the height of this node if necessary (if no change, that’s OK) /
	curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
//	* rotate if necessary (call balance() method to balance the node) /
	curNode = this.balance(curNode);
	return curNode;
	}
}
