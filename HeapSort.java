/* Heap Sort:--
 * ---------
 * Unstable Sorting Algorithm
 * +----------------+-----------+
 * |Best Case		    |	O(N*logN)	|
 * |----------------|-----------|
 * |Worst Case		  |	O(N*logN)	|
 * |----------------|-----------|
 * |Average Case	  |	O(N*logN)	|
 * |----------------|-----------|
 * |Space			      |	O(1)		  |
 * +----------------+-----------+
 * 
 */

public class HeapSort<T> {
	public T[] heapSort(T[] arr) {
		MyHeap<T> h = new MyHeap<>(true);
		for(T i:arr) {
			h.add(i);
		}
		int n = h.size();
		for(int i=0;i<n;i++) {
			arr[i] = h.poll();
		}
		return arr;
	}
}
