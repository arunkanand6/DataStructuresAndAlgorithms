/* Insertion Sort:---
 * --------------------
 * Stable Sorting Algorithm
 * Comparison Sort
 * Complexity:-
 * +----------------+---------+
 * |Best Case	    |	O(N)  |
 * |----------------|---------|
 * |Worst Case	    |	O(N^2)|
 * |----------------|---------|
 * |Average Case    |	O(N^2)|
 * |----------------|---------|
 * |Space	    |	O(1)  |
 * +----------------+---------+
 */

public class InsertionSort<T> {
	
	public T[] insertionSort(T[] arr) {
		if(!((arr[0] instanceof Number)|(arr[0] instanceof Character))) {
			System.out.println("The given arr is not sortable");
			return null;
		}
		int i, j;
		T temp, key;
		for(i=1; i<arr.length; i++) {
			key = arr[i];
			j=i-1;
			while(j>=0 && ((Number)key).doubleValue()<((Number)arr[j]).doubleValue()) {
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				j--;
			}
		}
		return arr;
	}
}
