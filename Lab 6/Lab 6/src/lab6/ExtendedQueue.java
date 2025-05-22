/**
* @author Mike McGivern  
* Lab Assignment 6
* 
*/
package lab6;
import java.util.LinkedList;
public class ExtendedQueue<T> extends MyQueue<T> implements ExtendedMethods<T>  {

	/**
	 * counts the number of elements in the queue
	 * 
	 * @return count; the number of elements in the queue
	 */
	@Override
	public int getCurrentSize() { 
		//creates temp que, loops through counting, returns count, repopulates original que
		int size = 0;
		MyQueue<T> tempQue = new MyQueue();
		while(queue.peek() != null) {
			tempQue.add(queue.poll());
			size++;
		}
		while(tempQue.peek() != null) {
			queue.add(tempQue.poll());
		}
		return size;
	}

	/**
	 * examines and returns the last element in the queue (returns null if queue is empty)
	 * 
	 * @return lastVal; the last value in the queue (the element farthest in the back)
	 */
	@Override
	public T last() {
		//creates temp stack, reverses que into stack, gets the top element off of stack toReturn, 
		//repopulates original que
		 MyStack<T> tempStack = new MyStack();
		  while(queue.peek() != null) {
			  tempStack.push(queue.poll());
		  }
		  while(tempStack.empty() != true) {
			  queue.add(tempStack.pop());
		  }
		T val = queue.peek();
		  while(queue.peek() != null) {
			  tempStack.push(queue.poll());
		  }
		  while(tempStack.empty() != true) {
			  queue.add(tempStack.pop());
		  }
		return val;
	}

	/**
	 * reverses the order of the items in the queue
	 * 
	 */ 
	@Override
	public void reverse() {
		//creates temp stack to reverse que, adds new order of values to original que
		  MyStack<T> tempStack = new MyStack();
		  while(queue.peek() != null) {
			  tempStack.push(queue.poll());
		  }
		  while(tempStack.empty() != true) {
			  queue.add(tempStack.pop());
		  }
		
	}

	/**
	 * deletes all instances of a specified element in the queue
	 * 
	 * @param t; the element which will be sought out and deleted (every instance)
	 * 
	 * @return; the number of the instances of the element that were deleted
	 */
	@Override
	public int deleteAll(T t) {
		//creates a temp queue, saves the current que value, checks to see if it is the value in question
		//if it is the value in question, count and pass it, else add it back to a temp que that will 
		//repopulate the original que
		int toReturn = 0;
		MyQueue<T> tempQueue = new MyQueue();
		while(queue.peek() != null) {
				T val = queue.poll();
				if(t == val)
					toReturn++;
				else
					tempQueue.add(val);
				
		}
		while(tempQueue.peek() != null) {
			queue.add(tempQueue.poll());
		}
		return toReturn;
	}


}
