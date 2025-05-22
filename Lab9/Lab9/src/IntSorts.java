/**
 * CS111 Lab 9
 * 
 * A collection of Integer Array sorting algorithms. You must fill in the
 * following method stubs and get all the tests to pass inside of
 * IntSortsTests.java
 * 
 * Some links have been provided
 * above each method with explanations/animations.
 * 
 * Tip: Make a swap function that takes two indexes and an array and swaps the
 * elements at those indexes. All sorts can use this swapping function.
 * 
 * Please updated your author name below:
 * 
 * @author Mike McGivern
 */
public class IntSorts {

	/**
	 * bubbleSort
	 * 
	 * sorts the provided array using the bubbleSort algorithm
	 * 
	 * See here for a detailed explanation of bubble sort:
	 * https://brilliant.org/wiki/bubble-sort/
	 * 
	 * @param input The int array that will be sorted via bubble sort. The input
	 *              arrays elements are modified to be sorted after this method call
	 * 
	 **/
	static void bubbleSort(int[] input) {
		  int n = input.length;  
	         for(int i=0; i < n-1; i++){ // first pointer  
	                 for(int j=1; j < (n-i); j++){  //second pointer
	                          if(input[j-1] > input[j]){  //comparison
	                                 swap(j,input);//swap elements  
	                         }  
	                 }
	        }  
	}

	/**
	 * selectionSort
	 * 
	 * sorts the provided array using the selectionSort algorithm
	 * 
	 * See here for a detailed explanation of selection sort:
	 * https://runestone.academy/runestone/books/published/pythonds/SortSearch/TheSelectionSort.html
	 * 
	 * @param input The int array that will be sorted via selection sort. The input
	 *              arrays elements are modified to be sorted after this method call
	 * 
	 **/
	static void selectionSort(int[] input) {
        	for(int i = 0; i < input.length-1; i++) { //first pointer
        		int index = i; // index value storage
        		   for(int j = i+1; j < input.length; j++) { // second pointer
                	   if(input[j] < input[index]) { // comparison
                		   index = j;  //index value setting
        		   }
        	   }
        		   int temp = input[index]; //swap elements
            	   input[index] = input[i];
            	   input[i] = temp;
           }
	}

	/**
	 * insertionSort
	 * 
	 * sorts the provided array using the insertion sort algorithm
	 * 
	 * See here for a detailed explanation of insertion sort:
	 * https://www.geeksforgeeks.org/insertion-sort/
	 * 
	 * @param input The int array that will be sorted via insertion sort. The input
	 *              arrays elements are modified to be sorted after this method call
	 * 
	 **/
	static void insertionSort(int[] input) {
           for(int i = 1; i < input.length; i++) { // first pointer
        	   int value = input[i];
        	   int j = i-1;
        	   while(j > -1 && input[j] > value) { // second pointer and comparison
        		   input[j+1] = input[j]; //swap
        		   j--; //increment
        		   
        	  }
        	   input[j+1] = value; // swap 
           }
	}
	static void swap(int index, int[] input) { // swaps element in question with next element in the list
       int temp = input[index-1];  
        input[index-1] = input[index];  
        input[index] = temp;  
	}
}
