/*Time Complexity:---
 *  -------------------------
 *  |Operations | Complexity|
 *  |-----------|-----------|
 *  |Creation	|    O(n)   |
 *  |-----------|-----------|
 *  |Insertion  |    O(1)   |
 *  |-----------|-----------|
 *  |Deletion	|    O(1)   |
 *  |-----------|-----------|
 *  |Search	|    O(n)   |
 *  |-----------|-----------|
 *  |Append	|    O(1)   |
 *  -------------------------
 *  Space Complexity = O(n) + 2( n=no.of elements + head pointer)
 */

import java.util.Collection;

public class MyCircularLinkedList<T> implements MyList<T> {
	
	//Creates a Node (Inner) Class
	private class Node{
		Node prev;		//Pointer for previous element
		Node next;		//Pointer for next element
		T value;		//Stores the value of the current node
		
		//Node (Inner) Class Constructor
		private Node(T value){
			this.value = value;	//Creates a node with the given value
		}
	}
	
	private int size;	//Stores the size of the List
	private Node head;	//Stores the head element of the list (Head Pointer)
	
	//Circular Linked List Constructor
	public MyCircularLinkedList() {
		this.size = 0;		//Initializes the size to Zero
		this.head = null;	//Initializes the head to null
	}
	
	@Override
	//Returns the size of the list
	public int size() {
		return this.size;
	}

	@Override
	//Returns true if the list is empty else false
	public boolean isEmpty() {
		if(this.size==0) return true;	//Checks the size of the element
		return false;
	}

	@Override
	//Removes all the elements from the list
	public boolean clear() {
		if(this.size==0) return false;	//Returns false if the given array is already empty
		this.size = 0;					//Re-initailizes the size to Zero
		this.head = null;				//Sets the head pointer to null
		return true;
	}

	@Override
	//Returns true if the list contains the given element else false
	public boolean contains(T e) {		
		Node node = this.head.next;		//Initializes the node with the next element from head
		if(this.head.value.equals(e)) return true;	//Checks if the given value is present in the head
		while(node!=this.head) {		//Traverse till the end of the list
			if(node.value.equals(e)) return true;	//If the given element is found returns true
		}
		return false;	//Else return false
	}

	@Override
	public boolean add(int i, T e) {
		if(i>this.size && this.size<0) {
			throw new IndexOutOfBoundsException();
		}
		if(i==0) {
			this.add(e);
			this.head = this.head.prev;
		}else {
			Node node = this.head;
			if(i<size/2) {
				int count = 0;
				while(count<i) {
					node = node.next;
					count++;
				}
				Node temp = node;
				node = new Node(e);
				node.prev = temp.prev;
				node.next = temp;
				node.prev.next = node;
				node.next.prev = node;
				this.size++;
			}else {
				int count = size;
				while(count>i) {
					node = node.prev;
					count--;
				}
				Node temp = node;
				node = new Node(e);
				node.prev = temp.prev;
				node.next = temp;
				node.prev.next = node;
				node.next.prev = node;
				this.size++;
			}
		}
		return true;
	}

	@Override
	public T get(int i) {
		if(i>=this.size) {
			throw new IndexOutOfBoundsException();
		}
		Node node = this.head;
		int count = 0;
		while(count<i) {
			node = node.next;
			count++;
		}
		return node.value;
	}

	@Override
	public T remove(T e) {
		if(head.value.equals(e)) {
			Node temp = this.head;
			this.head = this.head.next;
			this.head.prev = temp.prev;
			this.head.prev.next = this.head;
			temp = null;
			this.size--;
			return e;
		}else {
			Node node = this.head.next;
			while(node!=this.head) {
				if(node.value.equals(e)) {
					node.next.prev = node.prev;
					node.prev.next = node.next;
					this.size--;
					return e;
				}
				node = node.next;
			}
		}
		return null;
	}

	@Override
	public T remove(int i) {
		if(i>=this.size) {
			throw new IndexOutOfBoundsException();
		}
		if(i==0) {
			Node temp = this.head;
			this.head = this.head.next;
			this.head.prev = temp.prev;
			this.head.prev.next = this.head;
			this.size--;
			return temp.value;
		}
		Node node = this.head;
		if(i<size/2) {
			int count = 0;
			while(count<i) {
				node = node.next;
				count++;
			}
			T a = node.value;
			node.next.prev = node.prev;
			node.prev.next = node.next;
			this.size--;
			return a;
		}else {
			int count = size;
			while(count>i) {
				node = node.prev;
				count--;
			}
			T a = node.value;
			node.next.prev = node.prev;
			node.prev.next = node.next;
			this.size--;
			return a;
		}
	}

	@Override
	public void addAll(Collection<T> c) {
		for(T i:c) {
			this.add(i);
		}
	}

	@Override
	public void add(T e) {
		if(this.head==null) {
			this.head = new Node(e);
			this.head.next = this.head;
			this.head.prev = this.head;
		}else{
			Node node = this.head;
			while(node.next!=head) {
				node = node.next;
			}
			node.next = new Node(e);
			node.next.prev = node;
			node = node.next;
			node.next = this.head;
			this.head.prev = node;
		}
		this.size++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(this.head.value).append(", ");
		Node node = this.head.next;
		while(node!=head) {
			sb.append(node.value).append(", ");
			node = node.next;
		}
		sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1).append("]");
		String s = new String(sb);
		return s;
	}
	
}
