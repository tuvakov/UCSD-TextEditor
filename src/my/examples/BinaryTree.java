package my.examples;

public class BinaryTree<E> {
	
	BinaryNode<E> root;
	
	public BinaryTree(BinaryNode<E> root){
		this.root = root; 
	}

}

class BinaryNode<E> {
	
	E value;
	BinaryNode<E> parent;
	BinaryNode<E> left;
	BinaryNode<E> right;
	
	public BinaryNode(E value, BinaryNode<E> parent){
		this.value = value;
		this.parent = parent;
		this.left = null;
		this.right = null;
	}
	
	public BinaryNode(E value, BinaryNode<E> parent, BinaryNode<E> left, BinaryNode<E> right){
		this.value = value;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	
}