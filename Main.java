import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map;

class Animal {
   String ID;
   String animalName;
   String kingdom;
   String phylum;
   String subphylum;
   String animalClass;
   String animalOrder;
   String family;
   String genus;

   // Constructor and other methods...
}

class AnimalNode {
   String key;
   Animal value;
   AnimalNode next;

   // Constructor and other methods...
}

class AnimalChain {
   AnimalNode head;

   // Constructor and other methods...
}

class Hashing {
   static final int TABLE_SIZE = 887;
   AnimalChain[] hashTable = new AnimalChain[TABLE_SIZE];

   static int calculateHashCode(String key) {
      int hashCode = 0;
      for (int i = 0; i < key.length(); i++) {
         hashCode += (i + 1) * (int) key.charAt(i);
      }
      return hashCode;
   }

   static int calculateHashFunction(int hashCode) {
      return hashCode % TABLE_SIZE;
   }
   /*
    @Override
   public V remove(Object key) {
      var index = this.getIndex(key); //finds index
      var value = table.get(index); //sets value
      table.set(index, null); //sets table
      tableSize--; //decrements table size
      return value; //returns removed value
   	
   	
   }
   */
   //----------------------------------------------
   static void insert(Animal animal) {
      // Calculate hash code and hash function
      // Insert into the hash table
   }
   //---------------------------------------------
   static void printResults(Hashtable<String, int[][]> hashtable, String key) {
      if (hashtable.containsKey(key)) {
         int[][] array = hashtable.get(key);
         for (int[] row : array) {
            for (int value : row) {
               System.out.print(value + " ");
            }
            System.out.println();
         }
      } else {
         System.out.println("Array not found in the Hashtable.");
      }
   }
}  

   /*
      collision detection for bucket size one to look over data in excel automatically
   */ 
public class Main {
   public static void main(String args[]) {
      //int TABLE_SIZE = 887;
      int size = 0;
      Animal AnimalArr[] = new Animal[size];
      AnimalChain[] hashTable = new AnimalChain[size];
   //make a node and node class
      calculateHashCode();
   }
   public static int calculateHashCode(String key) {
      int hashCode = 0;
      for (int i = 0; i < key.length(); i++) {
         hashCode += (i + 1) * (int) key.charAt(i);
      }
      return hashCode;
   }
   public static int calculateHashFunction(int hashCode, int size) {
      return hashCode % size;
   }
   
   // @Override
   public Animal remove(Object key) {
      var index = this.getIndex(key); //finds index
      var value = table.get(index); //sets value
      table.set(index, null); //sets table
      tableSize--; //decrements table size
      return value; //returns removed value
   	
   	
   }
   
   //----------------------------------------------
   static void insert(Animal animal) {
      // Calculate hash code and hash function
      // Insert into the hash table
   }
   //---------------------------------------------
   static void printResults(Hashtable<String, int[][]> hashtable, String key) {
      if (hashtable.containsKey(key)) {
         int[][] array = hashtable.get(key);
         for (int[] row : array) {
            for (int value : row) {
               System.out.print(value + " ");
            }
            System.out.println();
         }
      } else {
         System.out.println("Array not found in the Hashtable.");
      }
   }
   //@Override
   //public void putAll(Map<? extends K, ? extends V> arg0) {
   
   //}
   /*
    @Override
   public void clear() {
      table.clear();
      tableSize = 0;
      for (int i = 0; i < maxTableSize; i++) {
         table.add(null);
      }
   }
   */

	/**
	 * Used to get what index key maps to in the table
	 * 
	 * @param key
	 * @return int - index in table
	 */
   public Animal get(Object key, int size) { // WE DONT NEED THIS
      int index = (int)getIndex(key, size); //finds index
      
      ////------------------------6
      return hashTable.get(index) ;   //returns the value at said index
      //-----------------------------8
   }
   public int getIndex(Object key, int maxTableSize) {
      return key.hashCode() % maxTableSize;
   }
   //*/
   //@Override
   public boolean containsKey(Object key) {
      return this.get(key) != null; //returns boolean if the value exists
   	
   }

   //@Override
   public boolean containsValue(Object arg0) {
   /*for(Node : chain) { */
      for(Animal value : hashTable) { //loops through values
         if(value == arg0) { //if the value in the loop equals the value in question
            return true; //return true
         }
      }
    //}
      return false; //in no values are that return false
   }
  //--*************************************************************
   //public static void main(String[] args) {
      //add all data within table once collisiosns are figured out
      // print hashcode index
      //contains(animal obj[index ele of i]);
      //ANIMAL OBJ KEYS 2 ELE
      //ARRLIST INDEX DELETION
      //DOUBLELY LINKED LIST PARRELLE TO ARRALIST 
      //ArrayList AnimalArrL = new ArrayList<Animal>();
       // CREATE NODES CLASS
      //dictionary with 2 key types
      
      
      
   //}
   //@Override
   /**
    * Adds a new entry to the end of this list. Entries currently in the list are
    * unaffected. 
    * 
    * @param newEntry The object to be added as a new entry.
    */
   
   public void add(Animal newEntry) { //checks if size allows to increment, adds param if so
      if (size < MAX)
         array[size++] = newEntry;
   	
   
   }

   //@Override
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
   public void add(int newPosition, Animal newEntry) { //checks to see if bounds allow for addition, if so adds and shifts
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

	

   //@Override
   /**
    * Removes the entry at a given position from this list. Entries originally at
    * positions higher than the given position are at the next lower position
    * within the list, and the list's size is decreased by 1.
    * 
    * @param givenPosition An integer that indicates the position of the entry to
    *                      be removed.
    * 
    */
   public Animal remove(int givenPosition) {
   	//remove element, shift all other elements over by 1
      //returns removed element
      Animal toReturn = array[givenPosition];
      array[givenPosition] = null;
      if(givenPosition < MAX && givenPosition >= 0 && size<MAX){
         for(int i = givenPosition; i < size; i++) {
            array[i] = array[i+1];
         }
      }
      size--;
      return toReturn;
   }

   //@Override
   /** Removes all entries from this list.  
    **/
   public void clear() { // size = 0
      Animal[] array = (Animal[]) new Object[MAX];
      size = 0;
   }

   //@Override
   /**
    * Replaces the entry at a given position in this list.
    * 
    * @param givenPosition An integer that indicates the position of the entry to
    *                      be replaced.
    * @param newEntry      The object that will replace the entry at the position
    *                      givenPosition.
    */
   public Animal replace(int givenPosition, Animal newEntry) { //sets a value at the given position toReturn, 
   	//changes the value t the new entry returns the previous value that was removed
      Animal toReturn = array[givenPosition];
      array[givenPosition] = newEntry;
      return toReturn;
   }
   public Animal getEntry(int givenPosition) {
      return array[givenPosition]; //returns index position
   }

   //@Override
   /**
    * Creates a new array and retrieves all entries that are in this list  by iterating in the order in which they occur
    * in the list.
    *
    */
   
   public Animal[] toArray() {
   	
      Animal[] copy = (Animal[]) new Object[size];
      for (int i = 0; i < size; i++) {
         copy[i] = array[i];
      
      }
      return copy;
   }

   //@Override
   /**
    * Checks whether this list contains a given entry.
    * 
    * @param anEntry The object that is the desired entry.
    * @return True if the list contains anEntry, or false if not.
    */
   public boolean contains(Animal anEntry) { //loops through to see if the parameter equals any element
   	//returns boolean if it does or not
      for(int i = 0; i< size; i++) {
         if(array[i] == anEntry) 
            return true;
      }
      return false;
   }

   //@Override
   /**
    * Gets the size of this list.
    * 
    * @return The integer number of entries currently in the list.
    */
   public int getLength() {
      return array.length; //returns .length
   }

   //@Override
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
   //@Override
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
   //@Override
   public void removeDuplicates() {//Creates a temp value to store array elements inside the loop
   	// starts a loop that will save index's to the temp value, another loop nested inside of that loop
   	//looks through the data structure again to determin if the saved value exists within the loop anywhere else
   	//removes and resizes the ADT if so.
      Animal x = null;
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