import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * MyHashMap
 * 
 * A custom implementation of a HashMap using buckets of size 1. Collision will
 * happen often because of this but it's okay for learning.
 * 
 * NOTE: Be sure to only use the SET method on the ArrayList to avoid the array
 * list growing larger or smaller. (Don't use remove or add methods)
 * 
 * For a description of what each method has to do visit here:
 * https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#containsKey-java.lang.Object-
 * 
 * Replace your name below:
 * 
 * @author Mike McGivern
 * 
 **/
public class MyHashMap<K, V> implements Map<K, V> {

   private ArrayList<V> table;

   private int maxTableSize = 50;
   private int tableSize = 0;

   public MyHashMap() {
      table = new ArrayList<V>();
      this.clear();
   }

   public MyHashMap(int maxSize) {
      table = new ArrayList<V>();
      maxTableSize = maxSize;
      this.clear();
   }

   @Override
   public void clear() {
      table.clear();
      tableSize = 0;
      for (int i = 0; i < maxTableSize; i++) {
         table.add(null);
      }
   }

	/**
	 * Used to get what index key maps to in the table
	 * 
	 * @param key
	 * @return int - index in table
	 */
   private int getIndex(Object key) {
      return key.hashCode() % maxTableSize;
   }

   @Override
   public boolean containsKey(Object key) {
      return this.get(key) != null; //returns boolean if the value exists
   	
   }

   @Override
   public boolean containsValue(Object arg0) {
      for(V value : table) { //loops through values
         if(value == arg0) { //if the value in the loop equals the value in question
            return true; //return true
         }
      }
      return false; //in no values are that return false
   }

   @Override
   public V get(Object key) {
      var index = getIndex(key); //finds index
      return table.get(index) ;   //returns the value at said index
   }

   @Override
   public boolean isEmpty() {
      return tableSize == 0;   
   }

   @Override
   public V put(K key, V value) {
      var index = getIndex(key); // finds index
      table.set(index, value); //sets value within table
      tableSize++; // increments size
      return value; //returns 
   }

   @Override
   public V remove(Object key) {
      var index = this.getIndex(key); //finds index
      var value = table.get(index); //sets value
      table.set(index, null); //sets table
      tableSize--; //decrements table size
      return value; //returns removed value
   	
   	
   }

   @Override
   public int size() {
      return tableSize;
   }

   @Override
   public Collection<V> values() {
      return table;
   }

	// Do not implement methods passed this point
   @Override
   public Set<Entry<K, V>> entrySet() {
   	// TODO Auto-generated method stub
      return null;
   }

   @Override
   public Set<K> keySet() {
   	// TODO Auto-generated method stub
      return null;
   }

   @Override
   public void putAll(Map<? extends K, ? extends V> arg0) {
   
   }
}
