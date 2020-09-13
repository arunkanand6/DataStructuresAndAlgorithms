/*Time Complexity:---
 *  +-----------+-----------+
 *  |Operations | Complexity|
 *  |-----------|-----------|
 *  |Creation	|	O(n)|
 *  |-----------|-----------|
 *  |OfferFirst	| 	O(1)|
 *  |-----------|-----------|
 *  |OfferLast	|	O(1)|
 *  |-----------|-----------|
 *  |PollFirst	|	O(1)|
 *  |-----------|-----------|
 *  |PollLast	|	O(1)|
 *  +-----------+-----------+
 *  Space Complexity = O(n) + 2( n=no.of elements + two pointers)
 */

public class MyDeque<T> extends MyDoublyLinkedList<T>{

	public T pollFirst() {
		return this.remove(0);
	}
	
	public T pollLast() {
		return this.remove(this.size()-1);
	}
	
	public void addLast(T e) {
		this.add(e);
	}
	
	public void addFirst(T e) {
		this.add(0,e);
	}
}
