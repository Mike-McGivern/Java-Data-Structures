import java.util.Collection;

/**
 * 
 * Replace name below
 * 
 * @author mike mcgivern
 *
 */
public class BinarySearchTree {
	BinaryTree<Integer> tree; // if null this means it's an empty tree

	/**
	 * Checks if a int x is in the BinarySearchTree
	 * 
	 * @param x the integer to search for
	 * @return true if x is in the tree, false otherwise
	 */
	public boolean contains(int x) { // wrapper method for BST contains
		return contains(tree,x);
	}

	/**
	 * Recursive private method to check for an Integer in a BST
	 * 
	 * 
	 * @param t BinaryTree to search
	 * @param x Integer to search for
	 * @return true if x is in the tree, false otherwise
	 */
	private boolean contains(BinaryTree<Integer> t, int x) { // BST 

		if(t == null) { //base case
			return false;
		}
		else { // if the item is on the left
			if(x < tree.item) {
				return contains(tree.leftSubtree,x);
			}
			if(x > tree.item) { //if the item is on the right
				return true;
			}
		}
		
		return false;     
	}

	/**
	 * Add a item in a BST.
	 * 
	 * Add must enforce the BinaryTree to obey the laws of a BST
	 * 
	 * 
	 * @param x Integer to add
	 */
	public void add(Integer x) { //wrapper method for add
		tree = add(tree, x);

	}              

	/**
	 * Private method to Add a item in a BST, Recursively
	 * 
	 * Add must enforce the BinaryTree to obey the laws of a BST
	 * 
	 * 
	 * @param t BinaryTree to add to
	 * @param x Integer to add
	 * 
	 * createTree(T item, BinaryTree<T> left, BinaryTree<T> right)
	 * 
	 * 
	 */
	private BinaryTree<Integer> add(BinaryTree<Integer> t, Integer x) { //BST method
		if(tree == null) {
			return BinaryTree.createTree(x, tree.leftSubtree, tree.rightSubtree); // creates tree in a default manner 
		}
		else if (x < tree.item) { // if its on the left
			return BinaryTree.createTree(t.item, add(tree.leftSubtree,x), tree.rightSubtree); //create tree with a left addition
		}
		else if (x > tree.item) { // if its on the right
			return BinaryTree.createTree(t.item, tree.leftSubtree, add(tree.rightSubtree, x)); //create tree with a right addition
		}
		return null;
	}

	/**
	 * Adds a collection to the BinaryTree
	 * 
	 * This must still enforce the rules of the BST
	 * 
	 * 
	 * @param collection
	 */
	public void addAll(Collection<Integer> collection) { //a looped quadratic method
		//that will add everything in a single BST
		for(Integer i: collection) {
			tree = add(tree, i);
		}                
}
}