/*Time Complexity:---
 * --------------------------
 * |Creation	|	O(n)|
 * |------------|-----------|
 * |Push        |	O(1)|
 * |------------|-----------|
 * |Pop	        |	O(1)|
 * --------------------------
 */

public class MyStack<T> extends MyArrayList<T> {
	
	public void push(T e) {
		this.add(e);
	}
	
	public T pop() {
		return this.remove(this.size()-1);
	}
}
