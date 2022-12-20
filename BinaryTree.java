package tree;
import java.io.File;
import java.util.Scanner;

public class BinaryTree<T> {


	protected TreeNode<T> root = null;
//	public static void main(String args[]) throws Exception{
//		File file = new File ("C:\\Downloads\\TheArtOfWar.txt");
//		Scanner sC = new Scanner(file);
//		ArrayList <String> pussy = new ArrayList();
//		while (sC.hasNextLine()) {
//			System.out.println(sC.add.pussy());
//		}
//	}
	
	/* Tree Traversal methods */
	
	//HINT for three traversal methods: you can call toString() on the node's 
	//     data when you are executing the "root" command on a given node 
	//     (e.g. curNode.data.toString() + " ";) // Note the space added at the end
	
	public String getInOrder() {
		return getInOrder(root); // call getInOrder starting at the root!
	}
	private String getInOrder(TreeNode<T> curNode) {
		if(curNode == null) {
			return " ";
		}
		String leftside = getInOrder(curNode.left);
		String rightside = getInOrder(curNode.right);
		return leftside + (curNode.data.toString() + " ") + rightside;
	}
	
	public String getPreOrder() {
		return getPreOrder(root); // call getPreOrder starting at the root! 
	}
	private String getPreOrder(TreeNode<T> curNode) {
		if(curNode == null) {
			return " ";
		}
		String leftside = getPreOrder(curNode.left);
		String rightside = getPreOrder(curNode.right);
		return (curNode.data.toString() + " ") + leftside + rightside;
	}	
	
	public String getPostOrder() {
		return getPostOrder(root);  // call getPostOrder starting at the root! 
	}
	private String getPostOrder(TreeNode<T> curNode) {
		if(curNode == null) {
			return " ";
		}
		String leftside = getPostOrder(curNode.left);
		String rightside = getPostOrder(curNode.right);
		return leftside + rightside + (curNode.data.toString() + " ");
	}


	//------------------------------------------------------------------------
	//EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU
	//YOU SHOULD STILL LOOK AT THIS CODE
	//------------------------------------------------------------------------
	
	/* A somewhat more pretty print method for debugging */
	public void printTree() {
		printTree(this.root, 0);
		System.out.println("\n\n");
	}
	private void printTree(TreeNode<T> curNode, int indentLev) {
		if(curNode == null) return;
		for(int i=0; i<indentLev; i++) {
			if(i == indentLev - 1) System.out.print("|-----");
			else System.out.print("      ");
		}
		System.out.println(curNode.data);
		printTree(curNode.left, indentLev+1);
		printTree(curNode.right, indentLev+1);
	}
	
	//TODO: Look at these methods and think about how they might be useful for this assignment
	public int height() {
		return height(root);
	}
	
	/* Computes the height of the tree on the fly */
	protected int height(TreeNode<T> node) {
		if(node == null) return 0;
		return node.height;
	}


	public String toString() {
		return treeString(this.root).trim().replaceAll("\\s+\\)", ")");
	}
	private String treeString(TreeNode<T> curNode) {
	if (curNode == null) {
		return "null ";
		}
	if (curNode.left == null & curNode.right == null) {
		return curNode.data + " ";
	}
	String res = "(" + curNode.data + " " + treeString(curNode.left) +
			treeString(curNode.right) + ") ";
	return res;
	}
	

public void copyOf(BinaryTree<T> source) {
this.root = copyRecursive(source.root);
}
public TreeNode<T> copyRecursive(TreeNode<T> sourceNode) {
	if (sourceNode == null) {
		return null;
	}
	TreeNode<T> copyNode = new TreeNode<T>(sourceNode.data);
	copyNode.left = copyRecursive(sourceNode.left);
	copyNode.right = copyRecursive(sourceNode.right);
	return copyNode;
	}
}
