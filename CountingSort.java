/* Counting Sort:---
 * ---------------
 * Stable Sorting Algorithm
 * Complexity:-
 * +----------------+-----------+
 * |Best Case	    |	O(N+r)  |
 * |----------------|-----------|
 * |Worst Case      |	O(N+r)	|
 * |----------------|-----------|
 * |Average Case    |	O(N+r)	|
 * |----------------|-----------|
 * |Space	    |	O(N+r)	|
 * +----------------+-----------+
 * where r = range of non negative numbers
 */

public class CountingSort {
	
	public int[] countingSort(int[] arr) {
		int n = arr.length;
		int k = 0;
		for(int i:arr) {
			if(i>k) k = i;
		}
		k++;
		int[] range = new int[k];
		for(int i:arr) {
			range[i] += 1;
		}
		int[] ans = new int[n];
		for(int i=1;i<k;i++) {
			range[i] += range[i-1];
		}
		for(int i=k-1;i>0;i--) {
			range[i] = range[i-1];
		}
		range[0] = 0;
		for(int i:arr) {
			int j = range[i];
			ans[j] = i;
			range[i]++;
		}
		return arr;
	}
}
