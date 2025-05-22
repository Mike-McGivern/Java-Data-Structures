package lab6;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {

	Queue<T> queue = new LinkedList<T>();

	/*
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions, returning true upon
	 * success and throwing an IllegalStateException if no space is currently
	 * available.
	 */
	public boolean add(T in) {
		
		return queue.add(in);
	}

	/*
	 * Retrieves and removes the head of this queue, or returns null if this queue
	 * is empty.
	 */
	public T poll() {
		
		return queue.poll();
	}

	/*
	 * Retrieves, but does not remove, the head of this queue, or returns null if
	 * this queue is empty.
	 */
	public T peek() {
	    
		return queue.peek();
	}
}
