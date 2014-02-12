package circularlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class to create an iterator for the arraybased circular list with 
 * an array and index.
 * @author Brenden Bishop
 */

public class CircularListArrayIterator<E> implements Iterator<E> {

 /**
 * Create field variables. The first, and array of type E,
 * the second field is declared as an int, meant to count the
 * indexes of each element in the array.
 */
 protected CircularList<E> clist;
 private int index;
 
 /**
   * Constructor for a new iterator of an array of type E.
   * @param array created in the CircularListArrayBased class.
   */
 public CircularListArrayIterator(CircularList<E> clist)
 {
  this.clist = clist;
  this.index = 0;
 }
 
 /**
   * Checks if there is an item in the next index of the list.
   * @return true if this list iterator has more elements incrementing index.
   */
 public boolean hasNext()
 {
  if (index >= clist.size())
  {
    index = (index % clist.size());
  }
  return (index < clist.size());
  
 }
 
 /**
   * Returns the next element in the list and advances the index.
   * @return item of type E if it exists.
   */
 public E next()
 {
  E e;
  try{
   e = (E)clist.get(index++);
  } catch(IndexOutOfBoundsException x){
   throw new NoSuchElementException(); 
  } 
  return e;
 }
 
 public void remove()
 {
  
 }
}