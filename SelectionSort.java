/*Selection Sort:-
 * ----------------------
 * Unstable Sorting Algorithm
 * Comparison Sort
 * Complexity:-
 * +----------------+---------------+
 * |Best Case       |	O(N^2)	    |
 * |----------------|---------------|
 * |Worst Case      |	O(N^2)	    |
 * |----------------|---------------|
 * |Average Case    |	O(N^2)	    |
 * |----------------|---------------|
 * |Space	    |	O(1)	    |
 * +----------------+---------------+
 */

public class SelectionSort<T> {
	
	public T[] selectionSort(T[] arr) {
		if(!((arr[0] instanceof Number)|(arr[0] instanceof Character))) {
			System.out.println("The given arr is not sortable");
			return null;
		}
		for(int i=0; i<arr.length; i++) {
			int min = i;
			for(int j=i+1; j<arr.length; j++) {
				if(((Number)arr[min]).doubleValue() > ((Number)arr[j]).doubleValue()) {
					min = j;				
				}
			}
			T temp =arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
}
