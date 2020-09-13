/* Quick Sort:---
 * ---------------
 * Unstable Sorting Algorithm
 * Complexity:-
 * +----------------+---------------+
 * |Best Case       |	O(N*logN)   |
 * |----------------|---------------|
 * |Worst Case      |	O(N^2)      |
 * |----------------|---------------|
 * |Average Case    |	O(N*logN)   |
 * |----------------|---------------|
 * |Space           |	O(1)        |
 * +----------------+---------------+
 */

public class QuickSort<T> {
	
	public T[] quickSort(T[] arr) {
		return quick(0,arr.length,arr);
		
	}
	
	private T[] quick(int l, int h,T[] arr) {
		if(l<h) {
			int j = quickUtil(l,h,arr);
			quick(l,j,arr);
			quick(j+1,h,arr);
		}
		return arr;
	}
	
	private int quickUtil(int l, int h, T[] arr) {
		T pivot = arr[l];
		int i = l;
		int j = h;
		while(i<j) {
			do {
				i++;
			}while(((Number)pivot).doubleValue()>((Number)arr[i]).doubleValue());
			do {
				j--;
			}while(((Number)pivot).doubleValue()<((Number)arr[j]).doubleValue());
			if(i<j) {
				T k = arr[j];
				arr[j] = arr[i];
				arr[i] = k;
			}
		}
		T k = arr[l];
		arr[l] = arr[j];
		arr[j] = k;
		return j;
	}
}
