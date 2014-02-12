package circularlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class to model a reference based circular list with 
 * a node and size.
 * @author Brenden Bishop
 */

 @SuppressWarnings("unchecked")
public class CircularListReferenceBased <E> implements CircularList<E>
{
	/**
	* Create field variables. The first two, nodes of type E,
	* the second field is declared as an int, meant to count the
	* number of nodes in the circularlist.
	*/
	protected Node<E> head, curr;
	protected int num_nodes = 0;

	/**
	 * Instantiates the linked list
	 */
	 public CircularListReferenceBased()
	 {
	 	head = null;
	 	num_nodes = 0;
	 }
	 /**
	  * Determines whether a list is empty.
	  * @return true if the list is empty, otherwise false
	  */
	 public boolean isEmpty()
	 {
	 	return (num_nodes == 0);
	 }

	 /**
	  * Determines the length of a list.
	  * @return the number of elements in the list without wrapping
	  */
	 public int size()
	 {
	 	return num_nodes;
	 }
	 
	 /**
	  * Removes all elements from the list.
	  */
	 public void clear()
	 {
	 	head = null;
	 	num_nodes = 0;
	 }

	 /**
	  * Adds a new item to the end of the list.
	  * @param item the new item to add
	  * @return true if the list was modified
	  */
	 public boolean add(E item)
	 {
	 	if(num_nodes == 0)
	 	{
	 		Node<E> newNode = new Node<E>(item);
	 		newNode.setNext(newNode);
	 		head = newNode;
	 	}
	 	else {
		 	curr = head;
		 	Node<E> newNode = new Node<E>(item);
		 	int i = 0;
	        while(curr.getNext() != head)
	        { 
	            curr = curr.getNext();
	        }
	      	curr.setNext(newNode);
	      	newNode.setNext(head);
  		}
	  num_nodes++;
	  return true;
	 }
	 /**
	  * Adds a new item to the list at position index.  
	  * Other items are shifted, not overwritten.
	  * @param index where to add the new item
	  * @param item the new item to add
	  * @throws IndexOutOfBoundsException if index is negative
	  */
	 public void add(int index, E item) throws IndexOutOfBoundsException
	 {
	 	if(index < 0)
	 	{
	 		throw new IndexOutOfBoundsException("Index cannot be negative int");
	 	}
		if(index >= num_nodes)
		 {
		 	index = index % (num_nodes);
		 }
	 	Node<E> addNode = new Node<E>(item);
	 	curr = head;

	 	if(index == 0)
	 	{
	 		while(curr.getNext() != head)
	 		{
	 			curr = curr.getNext();
	 		}
	 		addNode.setNext(head);
	 		curr.setNext(addNode);
	 		head = addNode;
	 	}
	 	else{
	 		for(int i = 0; i < index-1; i++)
		 		{
		 		curr = curr.getNext();
		 		}
		 		addNode.setNext(curr.getNext());
		 		curr.setNext(addNode);
			}
		num_nodes++;
	 }

	 /**
	  * Remove and return the item at the given index.
	  * @param index the position of the item to remove
	  * @return the item that was removed
	  * @throws IndexOutOfBoundsException if index is negative
	  */
	 public E remove(int index) throws IndexOutOfBoundsException
	 {
	 	if(index < 0)
	 		{
	 			throw new IndexOutOfBoundsException("Index does not exist or the list is empty");
	 		}
	 	
		if(index >= num_nodes)
		 	{
		 		index = index % (num_nodes);
		 	}

		 E delnode;
		 int i;
		curr = head;
		if(index == 0)
		{
			delnode = head.item;
			head = head.next;
		}
		else{		
		for(i = 0; i < index-1; i++)
		 	{
		 		curr = curr.getNext();
		 	}
		 	delnode = (curr.getNext()).getItem();
		 	curr.setNext((curr.getNext()).getNext());
		 	}
		num_nodes--;
		return (E)delnode;
	 }

	 /**
	  * Retrieve the item at the given index without altering the list.
	  * @param index the position of the item to retrieve
	  * @return the item at position index
	  * @throws IndexOutOfBoundsException if index is negative or list is empty
	  */
	 public E get(int index) throws IndexOutOfBoundsException
	 {
	 	if(index < 0 || isEmpty())
	 		{
	 			throw new IndexOutOfBoundsException("Index does not exist or the list is empty");
	 		}

	 	if(index >= num_nodes)
	 		{
	 			index = index % (num_nodes);
	 		}
	 	curr = head;
	 	if(index == 0)
	 	{
	 		return head.item;
	 	}
	 	else{
    	for ( int i = 0; i < index ; i++)
    		{
      			curr = curr.getNext();
    		}
      	return curr.item;
 
	 		}
	 }
	 
	 /**
	  * Generate an iterator for the list.  The iterator should 
	  * visit the items in a circular pattern.  As long as the
	  * list is not empty, it should never stop.
	  */
	 public Iterator<E> iterator()
	 {
	 	return new CircularListLinkedIterator<E>(this);
	 }

}