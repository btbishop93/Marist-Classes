package vacsys;
import java.util.ArrayList;

/**
* Interface of VacSysHeap
*/

public interface VacSysPriorityQueue<T> {
	
	public ArrayList<T> getHeap();
	
	public String remove();
	
	public void clear();
	
	public int size();
	
	public void addArray(ArrayList<T> array);
}
