/*
Name: Abigail Natucci
Assignment: Lab04
Sources consulted: List E Documentation
*/

/**
 * SingleLinkedList is a class that provides some of the
 * capabilities required by the List interface using
 * a single linked list data structure.
 * Only the following methods are provided:
 * get, set, add, remove, size, toString
 * @author Koffman and Wolfgang 
 */
public class SingleLinkedList<E>{

    // Nested Class
    /*<listing chapter="2" number="1">*/
    /** A Node is the building block for the SingleLinkedList */
    private static class Node<E> {

        /** The data value. */
        private E data;
        /** The link */
        private Node<E> next = null;

        /**
         * Construct a node with the given data value and link
         * @param data - The data value 
         * @param next - The link
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Construct a node with the given data value
         * @param data - The data value 
         */
        public Node(E data) {
            this(data, null);
        }
    }
    /*</listing>*/
    // Data fields
    /** A reference to the head of the list */
    private Node<E> head = null;
    /** The size of the list */
    private int size = 0;


    // Helper Methods
    /** Insert an item as the first item of the list.
     *	@param item The item to be inserted
     */
    private void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    /**
     * Add a node after a given node
     * @param node The node which the new item is inserted after
     * @param item The item to insert
     */
    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }
    
    /**
     * Remove the first node from the list
     * @returns The removed node's data or null if the list is empty
     */
    private E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Remove the node after a given node
     * @param node The node before the one to be removed
     * @returns The data from the removed node, or null
     *          if there is no node to remove
     */
    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Find the node at a specified index
     * @param index The index of the node sought
     * @returns The node at index or null if it does not exist
     */
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    // Public Methods
    /**
     * Get the data value at index
     * @param index The index of the element to return
     * @returns The data at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     * Set the data value at index
     * @param index The index of the item to change
     * @param newValue The new value
     * @returns The data value previously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    /**
     * Insert the specified item at the specified position in the list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices)
     * @param index Index at which the specified item is to be inserted
     * @param item The item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    /**
     * Append the specified item to the end of the list
     * @param item The item to be appended
     * @returns true (as specified by the Collection interface)
     */
    public boolean add(E item) {
        add(size, item);
        return true;
    }



    /**
     * Query the size of the list
     * @return The number of objects in the list
     */
    public int size() {
        return size;
    }

    /**
     * Obtain a string representation of the list
     * @return A String representation of the list 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                //sb.append(" ==> ");
                sb.append(", ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }
   
    
    
/*****************************************************************************/    
/******************   Implement The Following Methods  ***********************/
/*****************************************************************************/
    
    
    /**
     * Remove the item at the specified position in the list. Shifts
     * any subsequent items to the left (subtracts one from their
     * index). Returns the item that was removed.
     * @param index The index of the item to be removed
     * @returns The item that was at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
  
    public E remove(int index) {
    	if(index <0 || index >= size)
    	    throw new IndexOutOfBoundsException(index);
    	else if(size == 1) //removing the only element
    	{
    	        E removed = head.data;
    	        clear();
    	        return removed;
            }
        else if (index == 0)
        {
            E removed = head.data;
            head = head.next;
            size--;
            return removed;
        }
        else{
            Node<E> temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node<E> after = temp.next.next;
            E removed = temp.next.data;
            temp.next = after;
            size--;
            return removed;
        }
    }    
    
 
    /**
     * Remove the first occurrence of element item.
     * @param item The item to be removed
     * @return true if item is found and removed; otherwise, return false.
     */
    public boolean remove(E item) {
        if (head == null) {
            return false;
        }
        Node<E> temp = head;
        if (item.equals(temp.data)) {
            removeFirst();
            return true;
        }
        while (temp.next != null) {
            if (item.equals(temp.next.data)) {
                removeAfter(temp);
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

 
    /**
     * Insert a new item before the one at position index,
     * starting at 0 for the list head. The new item is inserted
     * between the one at position index-1 and the one formerly
     * at position index.
     * Implement this method by manipulationg the list directly, i.e., 
     * you CANNOT use any helper methods.
     * Since there already is an add method that uses helper
     * methods, this one is named add2.
     * @param index The index where the new item is to be inserted
     * @param item The item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add2(int index, E item) {
        if (index <= 0 || index > size+1) //cannot add before 0 or past end of the list
        throw new IndexOutOfBoundsException(Integer.toString(index));
        else if(index ==0 || index == 1){
            head = new Node<E>(item, head);
            size++;
        }
        else {
            Node<E> temp = head;
            for (int i = 1; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node<E>(item, temp.next);
            size++;
        }
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     */
	public void clear() {
		head = null;
		size = 0;
		
	}


    /**
     * Returns true if this list contains the specified element.
     * @param item element whose presence in this list is to be tested
     * @return true if this list contains the specified element, false if it does not
     */
	public boolean contains(E item) {
        for (Node<E> temp = head; temp != null; temp = temp.next) {
            if (temp.data.equals(item)) {
                return true;
            }
        }
        return false;
	}

    /**
     *Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     * @param item element to search for
     * @return the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
	public int indexOf(E item) {
        int index = 0;
        Node<E> temp = head;
        while (temp != null) {
            if (temp.data.equals(item)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
	}

    /**
     * Returns true if this list contains no elements, false otherwise.
     * @return true if the list is empty, false if there are elements in the list
     */
	public boolean isEmpty() {
		return (size == 0);
	}


    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     * @param item the item to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
	public int lastIndexOf(E item) {
        int counter = -1;
        int i = 0;
        Node<E> temp = head;
        while (temp != null)
        {
            if (temp.data.equals(item))
                counter = i;
            temp = temp.next;
            i++;
        }
        return counter;
	}	 
    
}//class
 
