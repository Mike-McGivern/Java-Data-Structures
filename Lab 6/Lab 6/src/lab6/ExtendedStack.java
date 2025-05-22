/**
* @author Mike McGivern 
* Lab Assignment 6 
*/

package lab6;
import java.util.Stack;
public class ExtendedStack<T> extends MyStack<T> implements ExtendedMethods<T> {
	/**
	 * counts the number of elements in the stack
	 * 
	 * @return count; the number of elements in the stack
	 */
	@Override
	public int getCurrentSize() {
		//creates temp stack, flips the stack while counting how many itterations it takes to empty stack
		//repopulates the original stack and returns the size
		int count = 0;
		MyStack<T> tempStack = new MyStack();
		while(stack.empty() != true) {
		tempStack.push(stack.pop());
		count++;
		}
		while(tempStack.empty() != true) {
			stack.push(tempStack.pop());
		}
		return count;
	}

	/**
	 * examines and returns the last element in the stack (returns null if stack is empty)
	 * functionally, this method is nearly identical to getCurrentSize save for a guard
	 * condition and a return statement before the elements are pushed back onto the stack
	 * 
	 * @return lastVal; the last value in the stack (the element on the bottom)
	 */
	@Override
	public T last() {
		//checks to see if the stack is empty, itterates through the stack, reversing it on a temp stack,
		//saves the first value on the temp stack to return, repopulates original stack
		if(this.empty()) return null;
		MyStack<T> tempStack = new MyStack();
		while(stack.empty() != true) {
			tempStack.push(stack.pop());
		}
		T toReturn = tempStack.peek();
		while(tempStack.empty() != true)
			stack.push(tempStack.pop());
		return toReturn;
	}

	/**
	 * reverses the order of the items in the stack
	 * 
	 */
	@Override
	public void reverse() {
		//creates 2 temStacks, first reverses the stack to the reverse stack
		//then the original stack is saved into temp stack by flipping the reversed stack
		//finally we flip the temp stack into the original stack, altering the original stack
		 MyStack<T> tempStack = new MyStack();
		 MyStack<T> revTempStack = new MyStack();
		 while(stack.empty() != true) {
			 revTempStack.push(stack.pop());
		 }
		 while(revTempStack.empty() != true) {
			tempStack.push(revTempStack.pop()); 
		 }
		 while(tempStack.empty() != true) {
			stack.push(tempStack.pop()); 
		 }
		
	}

	/**
	 * deletes all instances of a specified element in the stack
	 * 
	 * @param t; the element which will be sought out and deleted (every instance)
	 * 
	 * @return; the number of the instances of the element that were deleted
	 */
	@Override
	public int deleteAll(T t) {
		//creates a temp stack, itterate through the original stack
		//check each value to see if it needs to be deleted
		// counts deleted items while preserving other elements into the temp stack
		// repopulates original stack and returns the count of deleted elements
		int toReturn = 0;
		MyStack<T> tempStack = new MyStack();
		while(stack.empty() != true) {
			T val = stack.pop();
			if( t== val)
				toReturn++;
			else
				tempStack.push(val);
		}
		while(tempStack.empty() != true) {
			stack.push(tempStack.pop());
		}
		return toReturn;
	}

}
