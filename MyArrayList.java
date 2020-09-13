/*Time Complexity:---
 *  -------------------------
 *  |Operations | Complexity|
 *  |-----------|-----------|
 *  |Creation   | O(n)      |
 *  |-----------|-----------|
 *  |Insertion  | O(n)	    |
 *  |-----------|-----------|
 *  |Deletion   | O(n)	    |
 *  |-----------|-----------|
 *  |Search     | O(n)	    |
 *  |-----------|-----------|
 *  |Append     | O(1)	    |
 *  -------------------------
 *  Space Complexity = O(n) ( n=no.of elements)
 */

import java.util.Collection;
@SuppressWarnings("unchecked")
public class MyArrayList<T> implements MyList<T>{
	
	private T[] arr;
	private int size = 0;
	private int capacity = 10;
	
	//Creates and returns an empty array of length 10
	public MyArrayList(){
		this.arr = (T[]) new Object[10];
	}
	
	//Creates and returns an empty array of given length
	public MyArrayList(int c) {
		this.arr = (T[]) new Object[c];
	}
	
	
	@Override
	//Returns the size of the list
	public int size() {
		return this.size;
	}

	@Override
	//Returns true if the list contains the given element else false
	public boolean contains(T e) {
		for(int i=0;i<this.size;i++) {			//Iterates over the array
			if(this.arr[i]==e) return true;		//Returns if given element is equal to any one of element
		}										//in array
		return false;
	}

	@Override
	
	//Add the given element (e) to the list
	public void add(T e) {				
		if(this.size==this.capacity) {	//Checks if there is space in the array to insert new element
			ensureCapacity();			//If array is full increases the size
		}
		this.arr[this.size] = e;		//Adds the element at the end of the list
		this.size++;					//Increments the size
	}

	@Override
	//Inserts the given element (e) to the list at the given index (i)
	public boolean add(int i, T e) {
		if(i>this.size && this.size<0) {				//Checks if the given index is valid
			throw new IndexOutOfBoundsException();		//throws IndexOutOfBoundsException is index is invalid
		}
		if(this.size==this.capacity) {	//Checks if there is space in the array to insert new element
			ensureCapacity();			//If array is full increases the size
		}
		for(int x=this.size+1;x>i;x--) {	//Moves the next elements to the next index
			this.arr[x] = this.arr[x-1];
		}
		this.arr[i] = e;				//Adds the given element (e) at the given index (i)
		this.size++;					//Increments the size
		return true;					
	}
	
	@Override
	//Returns the element at given index (i)
	public T get(int i) {
		if(i>=this.size && this.size<0) {			//Checks if the given index is valid
			throw new IndexOutOfBoundsException();	//throws IndexOutOfBoundsException is index is invalid
		}
		return this.arr[i];			//Returns the element at specified index (i)
	}

	@Override
	//Removes and returns the given element (e) from the list
	public T remove(T e) {
		int index = -1;					//initializes index to -1
		for(int i=0;i<this.size;i++) {	//Iterates over the array
			if(this.arr[i]==e) {		//If the given element is found
				index = i;				//Notes the index to the (index)
				break;					//comes out of the loop immediately
			}
		}
		if(index==-1) return null;		//Returns null if the given element is not present 
		T temp = this.arr[index];		//Keeps the element in the temp variable
		for(int i=index;i<this.size;i++) {	//Rearranges the element one index forward
			this.arr[i] = this.arr[i+1];
		}
		this.size--;					//Decrements the size by one
		this.arr[this.size] = null;		//Removes the element at the end of the array
		return temp;					//Returns the removed element
	}

	@Override
	//Removes and returns the element at the given index i
	public T remove(int i) {
		if(i>=this.size && this.size<0) {			//Checks if the given index is valid
			throw new IndexOutOfBoundsException();	//throws IndexOutOfBoundsException is index is invalid
		}
		T temp = arr[i];						//Keeps the element in the temp variable
		for(int x=i;x<this.size;x++) {			//Rearranges the element one index forward
			this.arr[i] = this.arr[i+1];
		}
		this.size--;					//Decrements the size by one
		this.arr[this.size] = null;		//Removes the element at the end of the array
		return temp;					//Returns the removed element
	}

	@Override
	//Returns true if the list is empty else false
	public boolean isEmpty() {
		if(this.size==0) return true;	//Checks the size of the element
		return false;					//Else returns false
	}
	
	//Increases the size of the list by 1.5 times(n+n/2+1)
	public void ensureCapacity() {
		int newCapacity = this.capacity+this.capacity/2+1;	//Updates the capacity
		T[] a = this.arr;									
		this.arr = (T[]) new Object[newCapacity];			//Creates a new array with updated capacity
		for(int i=0;i<this.size;i++) {			//Copies all the element from old array to new Array
			this.arr[i] = a[i];								
		}
		a = null;
	}
	
	//Returns the string representation of the list
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0;i<this.size-1;i++) {
			sb.append(arr[i]).append(",");
		}
		sb.append(arr[this.size-1]).append("]");
		String s = new String(sb);
		return s;
	}

	@Override
	//Removes all the elements from the list
	public boolean clear() {
		if(this.size==0) return false;	//Returns false if the given array is already empty
		arr = (T[]) new Object[10];		//Creates a new Array
		this.size = 0;					//Sets the size to Zero
		return true;
	}

	@Override
	//Adds all the elements in the given Collection (c) to the list
	public void addAll(Collection<T> c) {
		for(T i:c) {		//Iterates over the Collection
			this.add(i);	//Adds each element to the array
		}
	}
	
	public MyArrayList<T> sort() {
		T[] a = (T[]) new Object[this.size];
		for(int i=0;i<this.size;i++) {
			a[i] = this.arr[i];
		}
		MergeSort<T> m = new MergeSort<>();
		a = (T[]) m.sort(a);
		for(int i=0;i<this.size;i++) {
			this.arr[i] = a[i];
		}
		return this;
		
	}
	
}
