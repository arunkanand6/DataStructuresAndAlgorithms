/* Merge Sort:-
 * -----------------
 * Stable Sorting Algorithm
 * Complexity:-
 * +----------------+---------------+
 * |Best Case	    |	O(N*logN)   |
 * |----------------|---------------|
 * |Worst Case      |	O(N*logN)   |
 * |----------------|---------------|
 * |Average Case    |	O(N*logN)   |
 * |----------------|---------------|
 * |Space           |	O(N)	    |
 * +----------------+---------------+
 */

public class MergeSort<T> {
	
	public T[] sort(T[] arr) {
		if(!((arr[0] instanceof Number)|(arr[0] instanceof Character))) {
			System.out.println("The given arr is not sortable");
			return null;
		}
		msort(0,arr.length-1,arr);
		return arr;
	}
	
	
	private void merge(int l, int m, int r, T[] arr) {
		int n1 = m - l + 1;
		int n2 = r - m;
		
		T[] L = (T[]) new Object[n1];
		T[] R = (T[]) new Object[n2];
		
		for(int i=0; i<n1; i++) {
			L[i] = arr[l+i];
		}
		
		for(int j=0; j<n2; j++) {
			R[j] = arr[m+1+j];
		}
		
		int i=0, j=0;
		
		int k=l;
		while(i<n1 && j<n2) {
			if (((Number) L[i]).doubleValue() <= ((Number) R[j]).doubleValue()) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	private void msort(int l, int r, T[] arr) {
		if(l<r) {
			int m = (l+r)/2;
			
			msort(l, m,arr);
			msort( m+1, r,arr);
			
			merge(l, m, r, arr);
		}
	}
}
