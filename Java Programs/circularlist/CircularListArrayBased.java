package circularlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class to model an arraybased circular list with 
 * an array and size.
 * @author Brenden Bishop
 */

@SuppressWarnings("unchecked")
public class CircularListArrayBased <E> implements CircularList<E>
{

   /**
 * Create field variables. The first, and array of type E,
 * the second field is declared as an int, meant to count the
 * number of elements in the array.
 */
 protected E[] arr1;
 protected int arr_items;

 /**
 * Creates the default array of size 16
 */
  public CircularListArrayBased()
  {
   arr1 = (E[])new Object[16]; 
   arr_items = 0;
  }
  /**
   * Determines whether a list is empty.
   * @return true if the list is empty, otherwise false
   */
  public boolean isEmpty()
  {
   return (arr_items == 0);

  }
  /**
   * Determines the length of a list.
   * @return the number of elements in the list without wrapping
   */
  public int size()
  {
   return arr_items;
  }
  
  /**
   * Removes all elements from the list.
   */
  public void clear()
  {
   arr1 = null;
  }

  /**
   * Grows the array size by size + ((size*3)/2) + 1
   * Copies original array into new array with new size
   */
  public void grow()
  {
   int arr_size = (int)(((arr1.length*3.0)/2.0)+ 1);
   E[] newArray = (E[])new Object[arr_size];
     for(int n = 0; n < arr1.length; n++)  
        {  
       newArray[n] = arr1[n];
        }

    arr1 = newArray;
    newArray = null;
  }

  /**
   * Adds a new item to the end of the list.
   * @param item the new item to add
   * @return true if the list was modified
   */
  public boolean add(E item)
  {
   if(arr_items == size())
    {
      grow();
 }  
  arr1[arr_items++] = item;
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
   
   if (index >= size())
    {
     index = index % (size());
    }

   if(arr_items == arr1.length)
    {
      grow();
    } 
   E[] tempArray = (E[])new Object[arr1.length];
   int n;
    for(n = 0; n < index; n++)
      {
       tempArray[n] = arr1[n];
      }

 tempArray[n] = item;
 n++;
 tempArray[n] = arr1[n-1];
 n++;
 while(n < size())
 {
  tempArray[n] = arr1[n-1];
  n++;
 }
    tempArray[n] = arr1[n-1];
    arr1 = tempArray;
    arr_items++;
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
    throw new IndexOutOfBoundsException("That index does not exist");
   }
   
   if (index >= size())
    {
    index = index % (size());
    }

    E[] tempArray = (E[]) new Object[arr1.length]; 
    E del_item;
    int n;
    for(n = 0; n < index; n++)
      {
       tempArray[n] = arr1[n];
      }
    del_item = arr1[n];
 while(n < arr1.length-1)
 {
  tempArray[n] = arr1[n+1];
  n++;
 }
    arr1 = tempArray;
    arr_items--;
    return del_item;
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
   else
   {
    if(index >= size())
    {
    index = index % (size());
    return arr1[index];
   }
   else 
    return arr1[index];
   }
  }
  
  /**
   * Generate an iterator for the list.  The iterator should 
   * visit the items in a circular pattern.  As long as the
   * list is not empty, it should never stop.
   */
  public Iterator<E> iterator()
  {
   return new CircularListArrayIterator<E>(this);
  }

}