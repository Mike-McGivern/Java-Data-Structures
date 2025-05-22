package lab8;
import java.util.Arrays;

public class AryList<T> implements MyList<T> {

	final int MAX = 256;
	int size = 0;
//Not scalable, always size 256
	T[] array = (T[]) new Object[MAX];

	@Override
	/**
	 * Adds a new entry to the end of this list. Entries currently in the list are
	 * unaffected. 
	 * 
	 * @param newEntry The object to be added as a new entry.
	 */

	public void add(T newEntry) { //checks if size allows to increment, adds param if so
		if (size < MAX)
			array[size++] = newEntry;
		

	}

	@Override
	/**
	 * Adds a new entry at a specified position within this list. Entries originally
	 * at and above the specified position are at the next higher position within
	 * the list. The list's size is increased by 1.
	 * 
	 * @param newPosition An integer that specifies the desired position of the new
	 *                    entry.
	 * @param newEntry    The object to be added as a new entry.
	 * 
	 */
	public void add(int newPosition, T newEntry) { //checks to see if bounds allow for addition, if so adds and shifts
		if (newPosition >= 0 && size < MAX && newPosition < MAX) {
			if (newPosition > size) {
				this.add(newEntry);
			}
			for (int back = size; back > newPosition; back--) {
				array[back] = array[back - 1];
			}
			array[newPosition] = newEntry;
			size++;
		}
    }

	

	@Override
	/**
	 * Removes the entry at a given position from this list. Entries originally at
	 * positions higher than the given position are at the next lower position
	 * within the list, and the list's size is decreased by 1.
	 * 
	 * @param givenPosition An integer that indicates the position of the entry to
	 *                      be removed.
	 * 
	 */
	public T remove(int givenPosition) {
		//remove element, shift all other elements over by 1
      //returns removed element
			T toReturn = array[givenPosition];
			array[givenPosition] = null;
			if(givenPosition < MAX && givenPosition >= 0 && size<MAX){
			for(int i = givenPosition; i < size; i++) {
				array[i] = array[i+1];
			}
		}
		size--;
		return toReturn;
	}

	@Override
	/** Removes all entries from this list.  
	 **/
	public void clear() { // size = 0
		T[] array = (T[]) new Object[MAX];
		size = 0;
	}

	@Override
	/**
	 * Replaces the entry at a given position in this list.
	 * 
	 * @param givenPosition An integer that indicates the position of the entry to
	 *                      be replaced.
	 * @param newEntry      The object that will replace the entry at the position
	 *                      givenPosition.
	 */
	public T replace(int givenPosition, T newEntry) { //sets a value at the given position toReturn, 
		//changes the value t the new entry returns the previous value that was removed
		T toReturn = array[givenPosition];
      array[givenPosition] = newEntry;
      return toReturn;
	}


	@Override
	/**
	 * Retrieves the entry at a given position in this list.
	 * 
	 * @param givenPosition An integer that indicates the position of the desired
	 
	 */
	public T getEntry(int givenPosition) {
		return array[givenPosition]; //returns index position
	}

	@Override
	/**
	 * Creates a new array and retrieves all entries that are in this list  by iterating in the order in which they occur
	 * in the list.
	 *
	 */

	public T[] toArray() {
		
		T[] copy = (T[]) new Object[size];
		for (int i = 0; i < size; i++) {
			copy[i] = array[i];

		}
		return copy;
	}

	@Override
	/**
	 * Checks whether this list contains a given entry.
	 * 
	 * @param anEntry The object that is the desired entry.
	 * @return True if the list contains anEntry, or false if not.
	 */
	public boolean contains(T anEntry) { //loops through to see if the parameter equals any element
		//returns boolean if it does or not
      for(int i = 0; i< size; i++) {
         if(array[i] == anEntry) return true;
      }
      return false;
	}

	@Override
	/**
	 * Gets the size of this list.
	 * 
	 * @return The integer number of entries currently in the list.
	 */
	public int getLength() {
		return array.length; //returns .length
	}

	@Override
	/**
	 * Sees whether this list is empty.
	 * 
	 * @return True if the list is empty, or false if not.
	 */
	public boolean isEmpty() {
		
		return size==0; //true false if size = 0
	}

	@SuppressWarnings("unchecked")
	/**
	 * This method will take the numbers within the list and scale it by itself,
	 * this means that if the array-based list looks something like this
	 * [1,2,0,-2,5] , after running this code the list should look like this
	 * [1,2,2,5,5,5,5,5]. Implement this method for the array-based implementation of list.
	 */
	@Override
	public void scaleByN() { //creates a loop to go through everything in the parent array
		//creates a value that is cast to an int, if this value is negitive it is tossed and size is incremented
		//else creates a nested loop that will add the elements of array[i] the amount of times of the frequency of array[i]
		//
	for(int i = 0; i < size; i++) {
		int value = (Integer)array[i];
			if(value<=0) {
				remove(i);
				i--;
			}
			else {
				int scale=value-1;
				for(int j = 0; j < scale; j++) {
					add(i,array[i]);
					i++;
				}
			}
		}
	}

	/**
	 * This method will remove all duplicates from the list, if the list looks like
	 * this initially [1,2,3,1,2,3,5,4,3,0] the list should then look like
	 * [1,2,3,5,4,0] after running the code. You may see how an iterator may be
	 * helpful for the completion of this task for the array-based implementation of list.
	 */
	@Override
	public void removeDuplicates() {//Creates a temp value to store array elements inside the loop
		// starts a loop that will save index's to the temp value, another loop nested inside of that loop
		//looks through the data structure again to determin if the saved value exists within the loop anywhere else
		//removes and resizes the ADT if so.
		T x = null;
		for(int i = 0; i < size; i++) {
			x = array[i];
			for(int j = i+1; j < size; j++) {
		
				if(array[j] == x) {
					remove(j);
					j--;
				}
			}
		}
	}
		
	
}

	
