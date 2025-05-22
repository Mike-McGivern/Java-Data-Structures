package lab8;

/**
 *
 *
 * @param <T>
 */
/**
 * 
 *
 * @param <T>
 */
public interface MyList<T> {
	/**
	 * Adds a new entry to the end of this list. Entries currently in the list are
	 * unaffected. The list's size is increased by 1.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 */
	public void add(T newEntry);

	/**
	 * Adds a new entry at a specified position within this list. Entries originally
	 * at and above the specified position are at the next higher position within
	 * the list. The list's size is increased by 1.
	 * 
	 * @param newPosition An integer that specifies the desired position of the new
	 *                    entry.
	 * @param newEntry    The object to be added as a new entry.
	 * @throws IndexOutOfBoundsException if either newPosition < 1 or newPosition >
	 *                                   getLength() + 1.
	 */
	public void add(int newPosition, T newEntry);

	/**
	 * Removes the entry at a given position from this list. Entries originally at
	 * positions higher than the given position are at the next lower position
	 * within the list, and the list's size is decreased by 1.
	 * 
	 * @param givenPosition An integer that indicates the position of the entry to
	 *                      be removed.
	 * @return A reference to the removed entry.
	 * @throws IndexOutOfBoundsException if either givenPosition < 1 or
	 *                                   givenPosition > getLength().
	 */
	public T remove(int givenPosition);

	/** Removes all entries from this list. */
	public void clear();

	/**
	 * Replaces the entry at a given position in this list.
	 * 
	 * @param givenPosition An integer that indicates the position of the entry to
	 *                      be replaced.
	 * @param newEntry      The object that will replace the entry at the position
	 *                      givenPosition.
	 * @return The original entry that was replaced.
	 * @throws IndexOutOfBoundsException if either givenPosition < 1 or
	 *                                   givenPosition > getLength().
	 */
	public T replace(int givenPosition, T newEntry);

	/**
	 * Retrieves the entry at a given position in this list.
	 * 
	 * @param givenPosition An integer that indicates the position of the desired
	 *                      entry.
	 * @return A reference to the indicated entry.
	 * @throws IndexOutOfBoundsException if either givenPosition < 1 or
	 *                                   givenPosition > getLength().
	 */
	public T getEntry(int givenPosition);

	/**
	 * Retrieves all entries that are in this list in the order in which they occur
	 * in the list.
	 * 
	 * @return A newly allocated array of all the entries in the list. If the list
	 *         is empty, the returned array is empty.
	 */
	public T[] toArray();

	/**
	 * Sees whether this list contains a given entry.
	 * 
	 * @param anEntry The object that is the desired entry.
	 * @return True if the list contains anEntry, or false if not.
	 */
	public boolean contains(T anEntry);

	/**
	 * Gets the length of this list.
	 * 
	 * @return The integer number of entries currently in the list.
	 */
	public int getLength();

	/**
	 * Sees whether this list is empty.
	 * 
	 * @return True if the list is empty, or false if not.
	 */
	public boolean isEmpty();

	/**
	 * Additional Methods:
	 */

	/**
	 * This method will take the numbers within the list and scale it by itself,
	 * this means that if the array-based list looks something like this
	 * [1,2,0,-2,5] , after running this code the list should look like this
	 * [1,2,2,5,5,5,5,5]. Implement this method for both the array-based, and the
	 * node-based implementation of list.
	 */
	public void scaleByN();

	/**
	 * This method will remove all duplicates from the list, if the list looks like
	 * this initially [1,2,3,1,2,3,5,4,3,0] the list should then look like
	 * [1,2,3,5,4,0] after running the code. You may see how an iterator may be
	 * helpful for the completion of this task for both implementations of the list.
	 */
	public void removeDuplicates();

	

} // end ListInterface