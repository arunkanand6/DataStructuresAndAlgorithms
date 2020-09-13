/* Bubble Sort:---
 * ---------------
 * Stable Sorting Algorithm
 * Complexity:-
 * +----------------+---------+
 * |Best Case		    |	O(N)    |
 * |----------------|---------|
 * |Worst Case		  |	O(N^2)  |
 * |----------------|---------|
 * |Average Case	  |	O(N^2)	|
 * |----------------|---------|
 * |Space			      |	O(1)		|
 * +----------------+---------+
 */

public class BubbleSort<T> {
	public T[] bubbleSort(T[] arr) {
		for(int i=0; i<arr.length; i++) {
			T temp;
			int count = 0;
			for(int j=0; j<arr.length-i-1;j++) {
				if(((Number)arr[j]).doubleValue() > ((Number)arr[j+1]).doubleValue()) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}else {
					count++;
				}
			}
			if(count==arr.length-i-1) return arr;
		}
		return arr;
	}
}
