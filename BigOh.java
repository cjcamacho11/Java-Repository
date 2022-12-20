package main;


import java.util.Vector;

public class BigOh {
	// Note: that each method has a default return value, you *must* change 
	// this as you write your solution (i.e., don’t keep “return 0”, for example, 
	// change it to the appropriate thing to return based on the method).  
	
	/* Binary Search: Should run in Theta(logn) time */
	/* Returns true if item is in the array a */
	
	public static void main(String[] args) {
		int[] testlist = {1,2,3,4,5,6,7,8,9,10};
		int[] testlist2 = {3,2,1,0,1,3,7,1,4};// 3
		int[] testlist3 = {1,2,3,1}; // 1
		int[] testlist4 = {0,9,1,10,1,4,2,7}; //2
		int[] testlist5 = {1,3,4}; //3 for triads
//		System.out.println(allPairs(testlist3));
//		System.out.println(allPairs(testlist4));
//		System.out.println(allPairs(testlist2));
//		System.out.println(allPairs(testlist5));

//		System.out.println(allTriads(testlist4));
		System.out.println(allTriads(testlist5));

	}
	
	public static boolean binarySearch(int[] a, int item) {
		int min = 0;
		int max = a.length;
		int middle = (min+max)/2;
			for(int i = 0; i < max; i++) {
				if(item == a[middle]) {
				return true;
				}
			else if (item < a[middle]) {
				middle--;
			}
			else if (item > a[middle]) {
				middle++;
			}
		}
		//Set int variablew "min" to zero, and "max" to a.length-1 (last index)
		// Continue while min is less than or equal to max
			//middle = middle element between min and max [Do this: (min+max)/2;]
			//if middle element is the item, then found !
			//if item is less than middle element
				//repeat search between min and middle-1
			//if item is more than middle element
				//repeat search between middle+1 and max	
		//If this loop exits, then the item was not found
		return false;
	}

	
	/* Max value in array: Should run in Theta(n) time */
	public static int max(int[] a) {
		int holder = 0;
		for (int i = 0; i < a.length; i++) {
			if (holder < a[i]) {
				holder = a[i];
			}
		}
		return holder;
	}
	
	/* Calls binary search n times. Counts number of successful searches */
	/* You should search for the numbers 1 through n in succession */
	/* Should run in Theta(nlogn) time */
	public static int multipleBinarySearch(int[] a) {
		//Create a for-loop that runs n times, where n is the size of the input array
	    	//  Updated 10/7: search for each value a[i] in the array in succession
		//  Call binarySearch within the loop, if it returns true, increment a counter
		//Return the counter 
		int counter = 0;
		int n = a.length;
		for( int i = 0; i < n; i++) {
			if(binarySearch(a , a[i])) {
				counter++;
			}
		}
		return counter;
	}

	
	/* Counts pairs of numbers whose sum is multiple of 5 */
	/* Should run in Theta(n^2) time */
	public static int allPairs(int[] a) {
		int counter = 0;
		if(a.length == 1) {
			if(a[0] % 5 == 0 ) {
				return 1;
			}
		}
		for (int c = 0; c < a.length; c++) {
			for (int j = 0; j < a.length; j++) {
				if ((a[c] + a[j]) % 5 == 0) {
					counter++;
				}
			}
		}
		//Create two (2) nested for-loops that go from 0 to the end of the array
		//These become two indices into the array (use to compare two elements)
		//You now are able to compare all pairs, check if the sum of two numbers is a 
		// multiple of 5. If so, increment a counter
		//Return the counter		
		return counter;
	}

	
	/* Counts the pairs of three in the list a,b,c in which a+b=c */
	/* Should run in Theta(n^3) time */
	public static int allTriads(int[] a) {
		//Similar strategy to the "allPairs method.
		//Create three (3) nested for-loops
		//Comparing three items in the list (a, b, and c), check if a+b=c. 
		// If so, increment a counter
		int counter = 0;
		if(a.length == 1) {
			if(a[0] == 0) {
			return 1;
			}
		else return 0;
		}
		for (int c = 0; c < a.length; c++) {
			for (int j = 0; j < a.length; j++) {
				for (int s = 0; s < a.length; s++) {
					if(a[c] + a[j] == a[s]){
						counter++;
					}
				}
			}
		}	
		return counter;
	}

		
	/* Finds all subsets of a */
	/* Should run in Theta(2^n) time */
	/* e..g, {1,2,3} would print {},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3} */
	public static void allSubsets(int[] a, int i, Vector<Integer> sol) {
		if(i >= a.length) {
			//Found another subset, but not printing because printing is really slow.
			return;
		}		
		allSubsets(a, i+1, sol);
		sol.add(a[i]);
		allSubsets(a, i+1, sol);
		sol.remove(sol.size()-1);
	}

}
