package circularlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class to create an iterator for the reference based circular list with 
 * a CircularList and index.
 * @author Brenden Bishop
 */

@SuppressWarnings("unchecked")
public class CircularListLinkedIterator<E> implements Iterator<E> {

	/**
	* Create field variables. The first, CircularList type E,
	* the second field is declared as an int, meant to count the
	* position of nodes in the circularlist.
	*/
	protected CircularList<E> list;
	private int index;

	/**
   * Constructor for a new iterator of a circularlist of type E.
   * @param linked list created in the CircularListReferenceBased class.
   */
	public CircularListLinkedIterator(CircularList<E> list)
	{
		this.list = list;
		this.index = 0;
	}
	
	/**
   * Checks if there is an item in the next index of the list.
   * @return true if this list iterator has more elements as the 
   * iterator increments the index.
   */
	public boolean hasNext()
	{
		return (list.size() >= 1);
	}

	/**
   * Returns the next element in the list and advances the index.
   * @return item of type E if it exists.
   */
	public E next()
	{
		E e;
		try{
			e = list.get(index++);
		} catch(IndexOutOfBoundsException x){
			throw new NoSuchElementException(); 
		} 
		return e;
	}
	
	public void remove()
	{
		
	}
}