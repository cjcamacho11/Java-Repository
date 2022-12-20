package sorting;

public class SortingAlgorithms {

	/*
	 * Swaps the elements and indices i and j in list
	 * */
	private static <T> void swap(T[] list, int i, int j) {
		if (i < 0 || i >= list.length)
			return;
		if (j < 0 || j >= list.length)
			return;
		T temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	// ####################
	// ## INSERTION SORT ## ----------------------------------------------------------------------
	// ####################
	// ## IMPORTANT: the code we've given you below has a small bug!
	// ##   You will need to look at this code and/or test, and fix the bug.
	// ####################
	/**
	 * Usually a slow sorting algorithm. Insertion sort. 
	 * @param list - An array of items
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] list) {
		for (int i = 1; i < list.length; i++) {
			T val = list[i];
			int j = i - 1;
			while (j >= 0 && val.compareTo(list[j]) < 0) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = val;
		}
	}
	
	
	// ################
	// ## MERGE SORT ## ----------------------------------------------------------------------
	// ################	
	/**
	 * Recursive Merge sort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * 
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		mergeSort(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
		//TODO: write the body of this method
		if (i < j) {
			int middle = (i + j)/2;
			mergeSort(list, i , middle);
			mergeSort(list, middle + 1, j);
			merge(list,i,middle,j);
		}
	}
	
	/**
	 * Merge method for Merge Sort algorithm.
	 * Your mergeSort algorithm will call this method as appropriate to do the merging.
	 * @param list - An array of items
	 * @param i - lower bound index
	 * @param mid - middle index
	 * @param j - upper bound index 
	 */
	public static<T extends Comparable<T>> void merge(T[] list, int i, int mid, int j) {
		if (list.length > 2 ) {
			return;
		}
		int starter = i;
		int ender = j;
		T[] merged = (T[]) new Comparable[j-i+1]; 
		int p = mid +1;
		for (int m = 0; m < merged.length; m++) {
			if(list[i].compareTo(list[p]) < 0) {
				merged[m] = list[i];
				i++;
			}
			else {
				merged[m] = list[p];
				p++;
			}
		
			if  (j < p) {
				m++;
				for (int o = i; o <= mid; o++) {
					merged[m] = list[o];
				}
			}
			if (mid < i) {
				m++;
				for(int n = p; n <= j; n++) {
					merged[m] = list[n];
					m++;
				}
			}
		}
		for (int y = starter; y <= ender; y++) {
			list[y]= merged[y-starter];
		}
		
	}

	
	// ###############
	// ## QUICKSORT ## ----------------------------------------------------------------------
	// ###############	
	/**
	 * Recursive Quicksort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * >>> Use any partition scheme that you like. 
	 * 
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		//TODO: write the body of this method
		if (i < j) {
			int val = partition(list, i , j);
			quickSort(list, i, val-1);
			quickSort(list, val +1, j);
		}
	}
	
	/**
	 * Partition method for Quicksort - Use any valid partition algorithm that you like.
	 * Your quickSort algorithm will call this method as appropriate to do the partitioning.
	 * @param list - An array of items
	 * @param i - lower bound
	 * @param j - upper bound
	 */
	public static<T extends Comparable<T>> int partition(T[] list, int i, int j) {	
		//TODO: write the body of this method
		T holder = list[j]; //pivot
		int val = i-1;
		for (int c = i; c <= j-1; c++) {
			if(list[c].compareTo(holder) < 0) {
				val++;
				swap(list, val, c);
			}
		}	
		swap(list, val +1, j);
		
		
		return val + 1; // be sure to return the right value and not 0
	
	}
	//=================================================================================
	
	public static void main(String[] args) {
		// TODO:  If you wish to do your own kind of testing
//		int [] tester = {4,2,3,8,8,10,1,7};
//		System.out.println(tester);
//		System.out.println(quickSort(tester, 4,7));
//		System.out.println(tester);

		

	}

}