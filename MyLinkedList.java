/*Time Complexity:---
 *  -------------------------
 *  |Operations | Complexity|
 *  |-----------|-----------|
 *  |Creation	|	O(n)|
 *  |-----------|-----------|
 *  |Insertion  | 	O(1)|
 *  |-----------|-----------|
 *  |Deletion	|	O(1)|
 *  |-----------|-----------|
 *  |Search	|	O(n)|
 *  |-----------|-----------|
 *  |Append	|	O(1)|
 *  -------------------------
 *  Space Complexity = O(n) + 2( n=no.of elements + two pointers)
 */

import java.util.Collection;

public class MyLinkedList<T> implements MyList<T>{

	private class Node{
		T value;
		Node next;
		
		private Node(T value) {
			this.value = value;
			next = null;
		}
		
	}
	
	private int size;
	private Node head;
	private Node tail;
	
	public MyLinkedList() {
		size = 0;
		head = tail = null;
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		if(this.size==0) return true;
		return false;
	}

	@Override
	public boolean clear() {
		if(this.head==null) return false;
		this.head = null;
		this.size = 0;
		return false;
	}

	@Override
	public boolean contains(T e) {
		Node node = this.head;
		while(node!=null) {
			if(node.value==e) return true;
			node = node.next;
		}
		return false;
	}

	@Override
	public void add(T e) {
		if(this.head==null) {
			this.head = new Node(e);
			this.tail = null;
			this.head.next = tail;
		}else {
			this.tail = new Node(e);
			this.tail = this.tail.next;
		}
		this.size++;
	}

	@Override
	public boolean add(int i, T e) {
		if(i>this.size) {
			throw new IndexOutOfBoundsException();
		}
		int count = 0;
		Node node = this.head;
		if(i==0) {
			Node temp = this.head;
			this.head = new Node(e);
			this.head.next = temp;
		}else if(i==size-1) {
			this.add(e);
		}else {
			while(count<i-1) {
				node = node.next;
				count++;
			}
			Node temp = node.next;
			node.next = new Node(e);
			node = node.next;
			node.next = temp;
		}
		this.size++;
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
		if(this.head.value.equals(e)) {
			if(head.next==null) head = null;
			else head = head.next;
			this.size--;
			return e;
		}else {
			Node node = this.head;
			while(node.next!=null) {
				if(node.next.value.equals(e)) {
					if(node.next.next!=null) node.next = node.next.next;
					else node.next = null;
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
			T a = head.value;
			head = head.next;
			this.size--;
			return a;
		}else {
			int count = 0;
			Node node = this.head;
			while(count<i-1 && node!=null) {
				node = node.next;
				count++;
			}
			T a = node.next.value;
			node.next = node.next.next;
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node node = this.head;
		while(node!=null) {
			sb.append(node.value).append(", ");
			node = node.next;
		}
		sb.deleteCharAt(sb.length()-1).append("]");
		String s = new String(sb);
		return s;
	}

}
