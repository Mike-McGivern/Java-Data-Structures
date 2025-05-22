package lab10;

/**
 * lab2 - Searching
 * 
 * In this lab you must complete the methods for a sequential search and binary
 * search. 
 * 
 * Replace your name below:
 * 
 * @author Shivam
 */
public class Search {

	/**
	 * sequentialSearch
	 * 
	 * A sequential search loops over the given input array and find the element
	 * that equals the value of *find*. Once found we return the index where it
	 * lies. If no elements match *find* we return -1.
	 * 
	 * @param find  - integer to find in input array
	 * @param input - integer array that is not guaranteed to be sorted
	 * @return index where find exists in input, -1 if not found
	 */
	static int sequentialSearch(int find, int[] input) { //iterates through array, if the value is find return the index
		for(int i = 0; i < input.length; i++) {
         if(input[i] == find) return i;
      }
      return -1;
	}

	/**
	 * binarySearch
	 * 
	 * A binary search works by taking the middle point in an array and inspecting
	 * it's value.
	 * 
	 * If the value is larger then what we are searching for, then we set mid + 1 as
	 * our new lower bounds.
	 * 
	 * If the value is smaller then what we are searching for, then we set index-1
	 * as our new upper bound
	 * 
	 * we continue to do this over and over until we find our value or our upper
	 * bound is no longer greater then our lower bound.
	 * 
	 * You must implement this recursively.
	 * 
	 * Good visualization of binary search:
	 * http://liveexample.pearsoncmg.com/liang/animation/web/BinarySearch.html
	 * 
	 * @param find  - integer to find in input array
	 * @param input - integer array that is guaranteed to be sorted
	 * @return index find exists in input, -1 if not found
	 */
	static int binarySearch(int find, int[] input) { //wrapper method for the recursive method.
		int low = 0;
		int high = input.length - 1;
		return recursiveBinarySearch(find, low, high, input);
	}

	static int recursiveBinarySearch(int find, int low, int high, int[] input) { //runs in logarythmic time
		//only works for sorted arrays
		 int mid = low + (high-low)/2;
		 if(high>=low) { //check for sorted
			int value = input[mid];
			if(value == find) {
				return mid; //base case
			}
			else if(value > find) { //recursive case for lowering mid because the pointer is too high
				return recursiveBinarySearch(find,low,mid-1,input);
			}
			else if (find > value) { //recursive case for rasing mid because the pointer is too low
				return recursiveBinarySearch(find,mid+1,high,input);
			}
		} 
		return -1;
	}
}
