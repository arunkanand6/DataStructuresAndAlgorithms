/*Time Complexity:---
 *  +-----------+-----------+
 *  |Operations | Complexity|
 *  |-----------|-----------|
 *  |Creation	|	O(n)|
 *  |-----------|-----------|
 *  |Offer	| 	O(1)|
 *  |-----------|-----------|
 *  |Poll	|	O(1)|
 *  +-----------+-----------+
 *  Space Complexity = O(n) + 1( n=no.of elements + One pointer for head)
 */

public class MyCircularQueue<T> extends MyCircularLinkedList<T> {
	
	public T poll() {
		return this.remove(0);
	}
	
	public void offer(T e) {
		this.add(e);
	}
	
}
