import java.util.Collection;

public interface MyList<T> extends MyCollection<T>{
	
	//Returns true if the list contains the given element else false
	public boolean contains(T e);
	
	//Add the given element (e) to the list
	public void add(T e);
	
	//Inserts the given element (e) to the list at the given index (i)
	public boolean add(int i, T e);
	
	//Returns the element at given index (i)
	public T get(int i);
	
	//Removes and returns the given element (e) from the list
	public T remove(T e);
	
	//Removes and returns the element at the given index i
	public T remove(int i);
	
	//Adds all the elements in the given Collection (c) to the list
	public void addAll(Collection<T> c);
	
}
