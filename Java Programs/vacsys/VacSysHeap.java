package vacsys;
import java.util.ArrayList;

/** 
* The implementation of VacSysPriorityQueue
* contains methods for creating the heap, getHeap,
* heapRebuild, remove a node from the heap,
* clear the heap, add a patient to the heap,
* and add a patient to an arrayList within the heap.
*/
public class VacSysHeap<T> implements VacSysPriorityQueue<T> {
 
 private ArrayList<T> heap;
 
 /**
 * Default constructor for initializing the heap
 */
 public VacSysHeap()
 {
  heap = new ArrayList<T>();
 }
 
 /**
 * Method to return the VacSysHeap
 * @param heap
 */
 public ArrayList<T> getHeap()
 {
  return heap;
 }
 
 /**
 * Method to rebuild the the heap based on comparing
 * the children with their parents, trickling up.
 * If the child node's priority value is greater than it's parent then they swap,
 * Otherwise, move onto the next child index to be compared.
 * This is called for each add of the patient array list, of a certain priority value,
 * to the vacsys heap system. 
 * @param int index, the index you want to start the rebuild from.
 */
 @SuppressWarnings("unchecked")
 private void heapRebuild(int currNode)
 {
	int parentNode = (currNode-1) / 2;
	ArrayList<T> parent = (ArrayList<T>) heap.get(parentNode);
	
	if(((parentNode*2) + 2) < heap.size() )
	{
	ArrayList<T> leftChild = (ArrayList<T>) heap.get((parentNode*2) + 1);
	ArrayList<T> rightChild = (ArrayList<T>) heap.get((parentNode*2) + 2);
	
	if((((Patient<T>) leftChild.get(0)).compareTo((Patient<T>)rightChild.get(0))) > 0)
	  {
		if((((Patient<T>)leftChild.get(0)).compareTo((Patient<T>)parent.get(0))) > 0)
		{
			ArrayList<T> temp = parent;
			heap.set(parentNode, (T)leftChild);
			heap.set(((parentNode*2) + 1), (T) temp);
		}
	  }
	else {
		if((((Patient<T>)rightChild.get(0)).compareTo((Patient<T>)parent.get(0))) > 0)
			{
				ArrayList<T> temp = parent;
				heap.set(parentNode, (T)rightChild);
				heap.set(((parentNode*2) + 2), (T) temp);
			}
	  	}
	
 	}
	
	else{
		if(((parentNode*2) + 1) < heap.size() )
		{
		ArrayList<T> leftChild = (ArrayList<T>) heap.get((parentNode*2) + 1);
		if((((Patient<T>)leftChild.get(0)).compareTo((Patient<T>)parent.get(0))) > 0)
			{
				ArrayList<T> temp = parent;
				heap.set(parentNode, (T)leftChild);
				heap.set(((parentNode*2) + 1), (T) temp);
			}
		}
	}
	if(parentNode != 0)
	{
	heapRebuild(parentNode);
	}
	
 }
 /**
 * Method to trickle down the the heap after item is removed
 * @param int index, the index you want to start the trickleDown from.
 */
@SuppressWarnings("unchecked")
public void trickleDown(int index)
 {
	if(index < heap.size()-1)
	{
	ArrayList<T> root = (ArrayList<T>) heap.get(index);
	
	if(((index*2) + 2) < heap.size())
	{
	ArrayList<T> leftChild = (ArrayList<T>) heap.get((index*2) + 1);
	ArrayList<T> rightChild = (ArrayList<T>) heap.get((index*2) + 2);
	
	if((((Patient<T>) leftChild.get(0)).compareTo((Patient<T>)rightChild.get(0))) > 0)
	  {
		if((((Patient<T>)leftChild.get(0)).compareTo((Patient<T>)root.get(0))) > 0)
		{
			ArrayList<T> temp = root;
			heap.set(index, (T)leftChild);
			heap.set(((index*2) + 1), (T) temp);
			trickleDown((index*2) + 1);
		}
		
	  }
	else {
		if((((Patient<T>)rightChild.get(0)).compareTo((Patient<T>)root.get(0))) > 0)
			{
				ArrayList<T> temp = root;
				heap.set(index, (T)rightChild);
				heap.set(((index*2) + 2), (T) temp);
				trickleDown((index*2) + 2);
			}
	  	}
 	}
	else{
		if(((index*2) + 1) < heap.size())
		{
		ArrayList<T> leftChild = (ArrayList<T>) heap.get((index*2) + 1);
		if((((Patient<T>)leftChild.get(0)).compareTo((Patient<T>)root.get(0))) > 0)
			{
				ArrayList<T> temp = root;
				heap.set(index, (T)leftChild);
				heap.set(((index*2) + 1), (T) temp);
			}
		}
	}
   }
 }
 
 /**
 * Removes the top node from the VacSysHeap and returns it
 * @return string patient
 */
 @SuppressWarnings({ "unchecked" })
 public String remove() 
 {
	 Patient<T> patient;
	 if(heap.size() > 0)
		{
		 	ArrayList<T> root = (ArrayList<T>) heap.get(0);
		 	patient = (Patient<T>) root.remove(0);
		 	if(root.size() == 0)
		 	{
		 		ArrayList<T> lastNode = (ArrayList<T>) heap.get(size()-1);
		 		heap.set(0, (T) lastNode);
		 		heap.remove(size()-1);
		 		trickleDown(0);
		 	}
		 	return patient.toString();
		 }
	 return "";
 }
 
 /**
 * Clears out the entire VacSysHeap
 */
 @Override
 public void clear() 
 {
  heap = null;
 }
 /**
  * Size of the heap
  */
 public int size()
 {
	 return heap.size();
 }
 
 /**
 * Adds an Arraylist, which is the list of patients who have the same 
 * priority queue, to VacSysHeap.
 */
 @SuppressWarnings("unchecked")
 public void addArray(ArrayList<T> array)
 {
	 heap.add((T) array);
	 
	 if(heap.size() > 0)
	 {
		 heapRebuild(heap.size()-1);
	 }
 }
 
}
