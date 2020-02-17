import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * A class to represent a binary search tree.
 * @author Koffman and Wolfgang
 *
 * Name: Abigail Natucci
 * Assignment: Lab09
 * Course/Semester: CSCI 270/Fall 2018
 * Class Section: 01
 * Instructor: Dr. Wolff
 * Sources Consulted: Textbook, Algorithm for Ordering (https://www.tutorialspoint.com/data_structures_algorithms/tree_traversal.html)
 * Known Bugs: Preorder test fails, but not sure why
 *Creative Feature(s): n/a
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>
		implements SearchTree<E> {
	
	// Data Fields
	/** Return value from the public add method. */
	protected boolean addReturn;

	/** Return value from the public delete method. */
	protected E deleteReturn;

	// Methods
	/**
	 * Starter method find. pre: The target object must implement the Comparable
	 * interface.
	 * 
	 * @param target
	 *            The Comparable object being sought
	 * @return The object, if found, otherwise null
	 */
	public E find(E target) {
		return find(root, target);
	}

	/**
	 * Recursive find method.
	 * 
	 * @param localRoot
	 *            The local subtree�s root
	 * @param target
	 *            The object being sought
	 * @return The object, if found, otherwise null
	 */
	private E find(Node<E> localRoot, E target) {
		if (localRoot == null)
			return null;

		// Compare the target with the data field at the root.
		int compResult = target.compareTo(localRoot.data);
		if (compResult == 0)
			return localRoot.data;
		else if (compResult < 0)
			return find(localRoot.left, target);
		else
			return find(localRoot.right, target);
	}

	/**
	 * Starter method add. pre: The object to insert must implement the
	 * Comparable interface.
	 * 
	 * @param item
	 *            The object being inserted
	 * @return true if the object is inserted, false if the object already
	 *         exists in the tree
	 */
	public boolean add(E item) {
		root = add(root, item);
		return addReturn;
	}

	/**
	 * Recursive add method. post: The data field addReturn is set true if the
	 * item is added to the tree, false if the item is already in the tree.
	 * 
	 * @param localRoot
	 *            The local root of the subtree
	 * @param item
	 *            The object to be inserted
	 * @return The new local root that now contains the inserted item
	 */
	private Node<E> add(Node<E> localRoot, E item) {
		if (localRoot == null) {
			// item is not in the tree, insert it.
			addReturn = true;
			return new Node<E>(item);
		} else if (item.compareTo(localRoot.data) == 0) {
			// item is equal to localRoot.data
			addReturn = false;
			return localRoot;
		} else if (item.compareTo(localRoot.data) < 0) {
			// item is less than localRoot.data
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		} else {
			// item is greater than localRoot.data
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
	}

	/**
	 * Starter method delete. post: The object is not in the tree.
	 * 
	 * @param target
	 *            The object to be deleted
	 * @return The object deleted from the tree or null if the object was not in
	 *         the tree
	 * @throws ClassCastException
	 *             if target does not implement Comparable
	 */
	public E delete(E target) {
		root = delete(root, target);
		return deleteReturn;
	}

	/**
	 * Recursive delete method. post: The item is not in the tree; deleteReturn
	 * is equal to the deleted item as it was stored in the tree or null if the
	 * item was not found.
	 * 
	 * @param localRoot
	 *            The root of the current subtree
	 * @param item
	 *            The item to be deleted
	 * @return The modified local root that does not contain the item
	 */
	private Node<E> delete(Node<E> localRoot, E item) {
		if (localRoot == null) {
			// item is not in the tree.
			deleteReturn = null;
			return localRoot;
		}

		// Search for item to delete.
		int compResult = item.compareTo(localRoot.data);
		if (compResult < 0) {
			// item is smaller than localRoot.data.
			localRoot.left = delete(localRoot.left, item);
			return localRoot;
		} else if (compResult > 0) {
			// item is larger than localRoot.data.
			localRoot.right = delete(localRoot.right, item);
			return localRoot;
		} else {
			// item is at local root.
			deleteReturn = localRoot.data;
			if (localRoot.left == null) {
				// If there is no left child, return right child
				// which can also be null.
				return localRoot.right;
			} else if (localRoot.right == null) {
				// If there is no right child, return left child.
				return localRoot.left;
			} else {
				// Node being deleted has 2 children, replace the data
				// with inorder predecessor.
				if (localRoot.left.right == null) {
					// The left child has no right child.
					// Replace the data with the data in the
					// left child.
					localRoot.data = localRoot.left.data;
					// Replace the left child with its left child.
					localRoot.left = localRoot.left.left;
					return localRoot;
				} else {
					// Search for the inorder predecessor (ip) and
					// replace deleted node's data with ip.
					localRoot.data = findLargestChild(localRoot.left);
					return localRoot;
				}
			}
		}
	}

	/**
	 * Removes target from tree.
	 * 
	 * @param target
	 *            Item to be removed
	 * @return true if the object was in the tree, false otherwise
	 * @post target is not in the tree
	 * @throws ClassCastException
	 *             if target is not Comparable
	 */
	public boolean remove(E target) {
		return delete(target) != null;
	}

	/**
	 * Determine if an item is in the tree
	 * 
	 * @param target
	 *            Item being sought in tree
	 * @return true If the item is in the tree, false otherwise
	 * @throws ClassCastException
	 *             if target is not Comparable
	 */
	public boolean contains(E target) {
		return find(target) != null;
	}

	/**
	 * Find the node that is the inorder predecessor and replace it with its
	 * left child (if any). post: The inorder predecessor is removed from the
	 * tree.
	 * 
	 * @param parent
	 *            The parent of possible inorder predecessor (ip)
	 * @return The data in the ip
	 */
	private E findLargestChild(Node<E> parent) {
		// If the right child has no right child, it is
		// the inorder predecessor.
		if (parent.right.right == null) {
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		} else {
			return findLargestChild(parent.right);
		}
	}

	/**
	 * Clears the contents of this BinarySearchTree, leaving the 
	 * tree empty.
	 */	
	public void clear() {
		root = null;
	}
	
	// ************************ Unimplemented methods*************************/
	/**
	 * Returns the number of nodes in this BinarySearchTree object.
	 * 
	 * @return the size of this BinarySearchTree object.
	 * 
	 */
	public int size(){
		return size(root);
	}

	/**
	 * @param n the node to be checked
	 * @return the children if not null, 0 if null
	 */
	private int size(Node<E> n) {
		if(n == null)
			return 0;
		else{
			return (size(n.left) + 1 + size(n.right));
		}
	}

	/**
	 * Returns the number of interior nodes in the tree.
	 * An interior node is a node that is not a leaf.
	 * 
	 * @return The number of interior nodes in the tree
	 */
	public int interiorNodes() {
		return interiorNodes(root);
	}

	/**
	 * @param n the node to be checked
	 * @return the number of interior nodes in the tree
	 */
	private int interiorNodes(Node n){
		if(n == null || n.left == null && n.right == null)
			return 0;
		else if(n.left == null)
			return 1 + interiorNodes(n.right);
		else if(n.right == null)
			return 1 + interiorNodes(n.left);
		else{
			return 1 + interiorNodes(n.left) + interiorNodes(n.right);
		}
	}

	/**
	 * Find the smallest element in the tree.
	 * 
	 * @return smallest element or null if the tree is empty.
	 */
	public E findMin() {
		if(root == null)
			return null;
		else{
			return findMin(root);
		}
	}

	/**
	 * @param n the node to be checked
	 * @return the smallest element in the tree
	 */
	private E findMin(Node<E> n) {
		if(n.left == null)
			return n.data;
		else{
			return findMin(n.left);
		}
	}


	/**
	 * Find the largest element in the tree.
	 * 
	 * @return the largest item or null if the tree is empty.
	 */
	public E findMax() {
		if(root == null)
			return null;
		else{
			return findMax(root);
		}
	}

	/**
	 * @param n the node to be checked
	 * @return the largest element in the tree
	 */
	private E findMax(Node<E> n) {
		if(n.right == null)
			return n.data;
		else{
			return findMax(n.right);
		}
	}

	/**
	 * Remove the minimum element from the tree
	 * @return true if the minimum element is removed; false otherwise
	 * @throws NoSuchElementException if the tree is empty
	 */
	public boolean removeMin() {
		if(root == null)
			throw new NoSuchElementException();
		else if(root.left == null) {
			root = root.right;
			return true;
		}
		else{
			return removeMin(root);
		}
	}

	/**
	 * @param n the node before the one to be removed
	 * @return true when the smallest element is removed
	 */
	private boolean removeMin(Node n){
		if(n.left.left == null) {
			n.left = n.left.right;
			return true;
		}
		else{
			return removeMin(n.left);
		}
	}

	/**
	 * Remove the largest element from the tree
	 * @return true if the largest element is removed; false otherwise
	 * @throws NoSuchElementException if the tree is empty
	 */
	public boolean removeMax() {
		if(root == null)
			throw new NoSuchElementException();
		else if(root.right == null) {
			root = root.left;
			return true;
		}
		else{
			return removeMax(root);
		}
	}

	/**
	 * @param n the node before the one to be removed
	 * @return true when the maximum is removed
	 */
	private boolean removeMax(Node n){
		if(n.right.right == null) {
			n.right = n.right.left;
			return true;
		}
		else{
			return removeMin(n.right);
		}
	}

	/**
	 * Returns the number of leaves in the tree
	 * @return the number of leaves in the tree
	 */
	public int leaves() {
		return leaves(root);
	}

	/**
	 * @param n the node to be checked
	 * @return 1 if leaf, recurse otherwise
	 */
	private int leaves(Node<E> n) {
		if(n == null)
			return 0;
		else if(n.left == null && n.right == null)
			return 1;
		else if(n.left==null)
			return leaves(n.right);
		else if(n.right == null)
			return leaves(n.left);
		else{
			return leaves(n.left) + leaves(n.right);
		}
	}

	/**
	 * Returns the height of the tree.  A tree with one node has
	 * a height of one.  An empty tree has a height of zero.
	 * @return returns the height of the tree
	 */
	public int height() {
		if(root == null)
			return 0;
		return height(root);
	}

	/**
	 * @param n the node to be checked
	 * @return the height of nodes in the tree
	 */
	private int height(Node n){
		if(n.left == null && n.right == null)
			return 0;
		else if(n.left == null)
			return 1 + height(n.right);
		else if(n.right == null)
			return 1 + height(n.left);
		else{
			return 1 + Math.max(height(n.left), height(n.right));
		}
	}

	/**
	 * Returns an inorder String of tree elements.
	 * 
	 * @return a string with an inorder traversal of the tree
	 */
	public String inorder() {
		if(root == null)
			return "";
		StringBuilder str = new StringBuilder();
		inorder(root, str);
		return str.toString().substring(1);
	}

	/**
	 * @param n the node to be checked
	 * @param str the stringbuilder containing the order
	 */
	private void inorder(Node<E> n, StringBuilder str) {
		if(n != null){
			inorder(n.left, str);
			str.append(" " + n.data);
			inorder(n.right, str);
		}
	}


	/**
	 * Returns a preorder String of tree elements.
	 * 
	 * @return a string with an preorder traversal of the tree
	 */
	public String preorder() {
		if(root == null)
			return "";
		StringBuilder str = new StringBuilder();
		preorder(root, str);
		return str.toString().substring(1);
	}

	/**
	 * @param n the node to be checked
	 * @param str the stringbuilder containing the order
	 */
	private void preorder(Node<E> n, StringBuilder str) {
		if(n != null){
			str.append(" " + n.data);
			preorder(n.left, str);
			preorder(n.right, str);
		}
	}

	/**
	 * Returns a postorder String of tree elements.
	 * 
	 * @return a String with a postorder traversal of the tree
	 */
	public String postorder() {
		if(root == null)
			return "";
		StringBuilder str = new StringBuilder();
		postorder(root, str);
		return str.toString().substring(1);
	}

	/**
	 * @param n the node to be checked
	 * @param str the stringbuilder containing the order
	 */
	private void postorder(Node<E> n, StringBuilder str) {
		if(n!=null) {
			postorder(n.left, str);
			postorder(n.right, str);
			str.append(" " + n.data);
		}
	}


	/**
	 * Returns a breadth-first order String of tree elements.
	 * 
	 * @return a String with a breadth-first order traversal of the tree
	 */
	public String breadthFirstOrder() {
		Queue<Node> q = new LinkedList<>();
		StringBuilder str = new StringBuilder();
		if(root == null)
			return "";
		q.offer(root);
		while(!q.isEmpty()) {
			Node n = q.poll();
			str.append(" " + n.data);
			if (n.left != null)
				q.offer(n.left);
			if (n.right != null)
				q.offer(n.right);
			}
		str.delete(0, 1); //removes empty space
		return str.toString();
	}

	/**
	 * Returns a parenthesized String representing the structure of the Binary
	 * Search Tree.  The String produced will have the following structure:
	 * "((L)N(R))" where L is the left subtree, R is the right subtree and N
	 * is the root of the subtree.  For example, if L has one child on the left
	 * and R has two children, then the string would be "(((LL)L)N((RL)R(RR)))",
	 * where LL is L's left child and RL and RR are the left and right children
	 * of R.
	 * 
	 * @return a string parenthesized string representing structure of BST tree
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		toString(root, str);
		return str.toString();
	}

	/**
	 * @param n the node to be checked/printed
	 * @param str the stringbuilder containing the order
	 */
	private void toString(Node<E> n, StringBuilder str) {
		if(n != null) {
			str.append("(");
			toString(n.left, str);
			str.append(n.data);
			toString(n.right, str);
			str.append(")");
		}
	}
	// **************  End of unimplemented methods  *********************/
}
