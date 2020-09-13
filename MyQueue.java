/*Time Complexity:---
 *  -------------------------
 *  |Operations | Complexity|
 *  |-----------|-----------|
 *  |Creation	|	O(n)|
 *  |-----------|-----------|
 *  |Offer	| 	O(1)|
 *  |-----------|-----------|
 *  |Poll	|	O(1)|
 *  -------------------------
 *  Space Complexity = O(n) + 2( n=no.of elements + Two pointers)
 */

public class MyQueue<T> extends MyLinkedList<T>{
	
	public T poll() {
		return this.remove(0);
	}
	
	public void offer(T e) {
		this.add(e);
	}
}
