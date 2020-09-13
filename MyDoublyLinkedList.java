/*Time Complexity:---
 *  +-----------+-----------+
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
 *  +-----------+-----------+
 *  Space Complexity = O(n) + 2( n=no.of elements + two pointers)
 */

import java.util.Collection;

public class MyDoublyLinkedList<T> extends MyLinkedList<T> {

	private class Node{
		Node prev;
		Node next;
		T value;
		
		private Node(T value){
			this.value = value;
		}
	}
	
	private int size;
	private Node tail = null;
	private Node head = null;
	
	public MyDoublyLinkedList() {
		this.size = 0;
		this.head = this.tail = null;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size==0) return true;
		return false;
	}

	@Override
	public boolean clear() {
		if(size==0) return false;
		this.size = 0;
		this.head = new Node(null);
		this.tail = new Node(null);
		this.head.next = this.tail;
		this.tail.prev = this.head;
		return true;
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
			this.tail = this.head;
		}else {
			this.tail.next = new Node(e);
			this.tail.next.prev = this.tail;
			this.tail = this.tail.next;
		}
		this.size++;
	}

	@Override
	public boolean add(int i, T e) {
		if(i>this.size) {
			throw new IndexOutOfBoundsException();
		}
		if(i==0) {
			this.head.prev = new Node(e);
			Node node = this.head;
			this.head = this.head.prev;
			this.head.next = node;
			this.size++;
		}else if(i==size) {
			this.add(e);
		}else {
			if(i<size/2) {
				int count = 0;
				Node node = this.head;
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
				int count = size-1;
				Node node = this.tail;
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
		if(this.head.value.equals(e)) {
			this.head = this.head.next;
			this.head.prev = null;
			this.size--;
			return e;
		}
		Node node = this.head;
		while(node!=null) {
			if(node.value.equals(e)) {
				if(node==this.tail) {
					tail = tail.prev;
					tail.next = null;
					this.size--;
					return e;
				}else {
					node.prev.next = node.next;
					node.next.prev = node.prev;
					this.size--;
					return e;
				}
			}
			node = node.next;
		}
		return null;
	}

	@Override
	public T remove(int i) {
		if(i>=size) throw new IndexOutOfBoundsException();
		if(i==0) {
			T a = this.head.value;
			this.head = this.head.next;
			this.head.prev = null;
			this.size--;
			return a;
		}else if(i==size-1) {
			T a = this.tail.value;
			this.tail = this.tail.prev;
			this.tail.next = null;
			this.size--;
			return a;
		}else {
			if(i<size/2) {
				int count = 0;
				Node node = this.head;
				while(count<i) {
					node = node.next;
					count++;
				}
				T a = node.value;
				node.prev.next = node.next;
				node.next.prev = node.prev;
				this.size--;
				return a;
			}else {
				int count = size-1;
				Node node = this.tail;
				while(count>i) {
					node = node.prev;
					count--;
				}
				T a = node.value;
				node.prev.next = node.next;
				node.next.prev = node.prev;
				this.size--;
				return a;
			}
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
		while(node!=tail) {
			sb.append(node.value).append(", ");
			node = node.next;
		}
		sb.append(this.tail.value).append("]");
		String s = new String(sb);
		return s;
	}

}
