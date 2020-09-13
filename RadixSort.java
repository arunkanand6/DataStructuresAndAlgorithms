/* Radix Sort:---
 * ---------------
 * Stable Sorting Algorithm
 * Complexity:-
 * +----------------+---------------+
 * |Best Case       |	O(N*K/D)    |
 * |----------------|---------------|
 * |Worst Case      |	O(N*K/D)    |
 * |----------------|---------------|
 * |Average Case    |	O(N*K/D)    |
 * |----------------|---------------|
 * |Space	    |	O(n+K)      |
 * +----------------+---------------+
 */

import java.util.Arrays;

public class RadixSort {
	
	public int[] radixSort(int[] arr) {
		int max = 0;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) max = arr[i];
		}
		return radix(max,arr);
	}
	
	private int[] radix(int max, int[] arr) {
		int d = 10;
		int e = 1;
		while(max>0) {
			int[] a = new int[arr.length];
			for(int i=0;i<arr.length;i++) {
				a[i] = (arr[i]%d)/e;
			}
			int[] range = new int[10];
			for(int i:a) {
				if(i<9) range[i+1]++;
			}
			for(int i=1;i<10;i++) {
				range[i] += range[i-1];
			}
			int[] ans = new int[arr.length];
			for(int i=0;i<arr.length;i++) {
				ans[range[a[i]]] = arr[i];
				range[a[i]]++;
			}
			max/=10;
			d*=10;
			e*=10;
			Arrays.fill(range, 0);
			Arrays.fill(a, 0);
			for(int i=0;i<arr.length;i++) {
				arr[i] = ans[i];
			}
		}
		return arr;
	}
}
