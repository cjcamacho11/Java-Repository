package sorting;

import java.util.Arrays;

enum SortType { SYSTEM, MERGE, QUICK, INSERTION };  // MERGE_HYBRID, QUICK_RAND // these 2 not used in Fall 2022


public class TimingSorts {
	
	public static void main(String[] args) {
		
		final int SIZE = 50000; // make a set of lists that are this size
		
		Integer[] randomList = makeRandomList(SIZE);  // list in random order
		
		Integer[] ascendingList = randomList.clone();  // list in sorted order
		Arrays.sort(ascendingList);
		
		Integer[] descendingList = new Integer[SIZE];  // list in reverse sorted order
		for (int i=0; i < SIZE; ++i)
			descendingList[SIZE-i-1] = ascendingList[i];
		
//		System.out.println(Arrays.toString(ascendingList));
//		System.out.println(Arrays.toString(descendingList));
		
		// make two lists that are "almost" sorted
		Integer[] almostSorted1 = makeAlmostSorted1(ascendingList, 0.2); // change last 10% of the list to be random values
//		System.out.println(Arrays.toString(almostSorted1));
		Integer[] almostSorted2 = makeAlmostSorted2(ascendingList, SIZE/10); // see method definition below
//		System.out.println(Arrays.toString(almostSorted2));
		
		
		// The loop below times all the sorts on all the lists.
		// It does this for the same size list, but you may need to change the size for insertion sort
		//   and maybe quicksort if you don't do randomized partition in order to avoid run-time issues
		     
		for (SortType s: SortType.values()) {

			long elapsed = timeSort(s, randomList);
	        System.out.println("Time for sort " + s + " on random list:        " + elapsed + " ms, n=" + SIZE);
	        
	        elapsed = timeSort(s, ascendingList);
	        System.out.println("Time for sort " + s + " on ascending list:     " + elapsed + " ms, n=" + SIZE);
	        
	        elapsed = timeSort(s, descendingList);
	        System.out.println("Time for sort " + s + " on descending list:    " + elapsed + " ms, n=" + SIZE);
	        
	        elapsed = timeSort(s, almostSorted1);
	        System.out.println("Time for sort " + s + " on almostSorted1 list: " + elapsed + " ms, n=" + SIZE);
	        
	        elapsed = timeSort(s, almostSorted2);
	        System.out.println("Time for sort " + s + " on almostSorted2 list: " + elapsed + " ms, n=" + SIZE);

	        System.out.println();
		}
		System.out.println("** All done!");
	}

	private static long timeSort(SortType theSort, Integer[] list) {
		Integer[] listCopy = list.clone();  // we'll sort a copy of the list
        long startTime = System.currentTimeMillis(); //start timer
        switch (theSort) {
        case SYSTEM:
        	Arrays.sort(listCopy);
        	break;
		case INSERTION:
			SortingAlgorithms.insertionSort(listCopy);
			break;
		case MERGE:
			SortingAlgorithms.mergeSort(listCopy);
			break;
		
		case QUICK:
			try {  // may fail -- see notes in in-lab instructions
				SortingAlgorithms.quickSort(listCopy);
			}
			catch (java.lang.StackOverflowError e) {
		        System.out.println("**** quicksort FAILED on list shown on next line with StackOverflowError exception ****");
			}
			break;
//		case QUICK_RAND:
////			SortingAlgorithms.quickSortRand(listCopy); // for Fall 2022, you didn't have to write this method
//			break;
//		case MERGE_HYBRID:   // for Fall 2022, you didn't have to do this one!
////			SortingAlgorithms.mergeSortHybrid(listCopy);
//			break;
		default:
			break;
        }        
	    long endTime = System.currentTimeMillis();
		
		return endTime-startTime;
	}
	

	// an almost sorted list, version #1
	// We update the last percentage of elements of a sorted list to be random
	private static Integer[] makeAlmostSorted1(Integer[] ascendingList, double percentToChange) {
		Integer[] list = ascendingList.clone();
		int size = ascendingList.length;
		int numberToChange = (int) (percentToChange * list.length);
		for (int i = size-numberToChange; i < size; i++)
			list[i] = (int) (Math.random() * 3 * size);
		return list;
	}

	// an almost sorted list, version #2
	// Divide the list up into smaller sections (sublists), and reverse the items in each section.
	// But all items in 1st section are smaller than those in 2nd section, etc.
	private static Integer[] makeAlmostSorted2(Integer[] ascendingList, int numSections) {
		Integer[] list = ascendingList.clone();
		int size = ascendingList.length;
		int sectionSize = size / numSections;
		int numPairs = sectionSize/2;
		
		for (int s=0; s < numSections; ++s) {
			int first = s * sectionSize;
			int last = first + sectionSize - 1;
			// reverse the list items in the section
			for (int ct=0; ct < numPairs; ++ct) {
				Integer tmp = list[first];
				list[first] = list[last];
				list[last] = tmp;
				++first;
				--last;
			}
		}	
		return list;
	}


	private static Integer[] makeRandomList(int size) {
		Integer[] list = new Integer[size];
		for (int i = 0; i < size; i++)
			list[i] = (int) (Math.random() * 3 * size);
		return list;
	}

}