package circularlist;

/**
 * Class to create an Object Node to be used 
 * in a circular linked list.
 * @author Brenden Bishop
 */

public class Node<E>
{
	/**
	* Create field variables of type E, the first a item of a node,
	* the second field being the Node of type E.
	*/
  protected E item;
  protected Node<E> next;
  
  /**
   * Creates the node of item newItem.
   * @param node newItem of type E
   */
  public Node(E newItem)
  {
    item = newItem;
    next = null;
  }
  
  /**
  * Creates the node of item newItem, and points it to node nextNode.
   * Returns the next element in the list and advances the index.
   * @param the item newItem of type E, and node nextNode of type E.
   */
  public Node(E newItem,Node<E> nextNode)
  {
    item = newItem;
    next = nextNode;
  }
  
  /**
   * Sets the item at the current node to newItem.
   * @param the newItem of type E.
   * @return item of type E if it exists.
   */
  public void setItem(E newItem)
  {
    item = newItem;
  }
  
  /**
   * Returns the item of the current node being called.
   * @return the item value at the current node.
   */
  public E getItem()
  {
    return item;
  }
  
  /**
   * Sets the current nodes pointer to the nextNode.
   * @param node nextNode of type E.
   */
  public void setNext(Node<E> nextNode)
  {
    next = nextNode;
  }
  
  /**
   * Returns the next node in the linkedlist.
   * @return the next node of type E if it exists.
   */
  public Node<E> getNext()
  {
    return next;      
  }
}
