import java.util.LinkedList;
import java.util.List;

/**
 * Basically the node class from the slides just called BinaryTree itself.
 * 
 * You must implement the traversal algorithms in the static methods
 * below
 * 
 * Replace name below
 * 
 
 O(LOG(n))
 
 
            0
          1
 
 
 
 
 
 * @author mike mcgivern
 *
 * @param <E>
 */
public class BinaryTree<E> {
	E item;
	BinaryTree<E> leftSubtree;
	BinaryTree<E> rightSubtree;

	public boolean isLeaf() {
		return leftSubtree == null && rightSubtree == null;
	}

	public BinaryTree(E item) {
		this.item = item;
	}

	public BinaryTree(E item, BinaryTree<E> left, BinaryTree<E> right) {
		this.item = item;
		this.leftSubtree = left;
		this.rightSubtree = right;
	}

	public static <T> BinaryTree<T> createTree(T item) {
		return new BinaryTree<T>(item);
	}

	public static <T> BinaryTree<T> createTree(T item, BinaryTree<T> left, BinaryTree<T> right) {
		return new BinaryTree<T>(item, left, right);
	}

	/**
	 * Return a list with all the element of a tree gathered using pre-order
	 * traversal
	 * 
	 * @param <T>  the Type of the tree
	 * @param tree the tree
	 * @return a list of the tree's elements in pre-order order
	 */
	public static <T> List<T> preOrderTraversal(BinaryTree<T> tree) { //root, left, right
		
		LinkedList<T> preorder = new LinkedList<>();
		if(tree != null) {
			preorder.add(tree.item);
			preorder.addAll(preOrderTraversal(tree.leftSubtree));
			preorder.addAll(preOrderTraversal(tree.rightSubtree));
		}
		
		return preorder;
	}

	/**
	 * Return a list with all the element of a tree gathered using in-order
	 * traversal
	 * 
	 * @param <T>  the Type of the tree
	 * @param tree the tree
	 * @return a list of the tree's elements in in-order order
	 */
	public static <T> List<T> inOrderTraversal(BinaryTree<T> tree) { //left root right

		LinkedList<T> inOrder = new LinkedList<>();
		if(tree != null) {
			inOrder.addAll(inOrderTraversal(tree.leftSubtree));
			inOrder.add(tree.item);
			inOrder.addAll(inOrderTraversal(tree.rightSubtree));
		}
		
		return inOrder;
	}

	/**
	 * Return a list with all the element of a tree gathered using post-order
	 * traversal
	 * 
	 * @param <T>  the Type of the tree
	 * @param tree the tree
	 * @return a list of the tree's elements in post-order order
	 */
	public static <T> List<T> postOrderTraversal(BinaryTree<T> tree) { //left right root
				
		LinkedList<T> postOrder = new LinkedList<>();
		if(tree != null) {
			postOrder.addAll(postOrderTraversal(tree.leftSubtree));
			postOrder.addAll(postOrderTraversal(tree.rightSubtree));
			postOrder.add(tree.item);
			
		}
		
		
		return postOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((leftSubtree == null) ? 0 : leftSubtree.hashCode());
		result = prime * result + ((rightSubtree == null) ? 0 : rightSubtree.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryTree<?> other = (BinaryTree<?>) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (leftSubtree == null) {
			if (other.leftSubtree != null)
				return false;
		} else if (!leftSubtree.equals(other.leftSubtree))
			return false;
		if (rightSubtree == null) {
			if (other.rightSubtree != null)
				return false;
		} else if (!rightSubtree.equals(other.rightSubtree))
			return false;
		return true;
	}
}

