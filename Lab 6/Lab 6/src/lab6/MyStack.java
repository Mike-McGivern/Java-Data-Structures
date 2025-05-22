package lab6;

import java.util.Stack;
import java.util.EmptyStackException;

public class MyStack<T> {
	Stack<T> stack = new Stack<T>();

	/*
	 * Pushes an item onto the top of this stack.
	 */
	public T push(T in) {
		
		
		
		return stack.push(in);
	}

	/*
	 * Removes the object at the top of this stack and returns that object as the
	 * value of this function.
	 */
	public T pop() {
		return stack.pop();
	}

	/*
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 */
	public T peek() {
		return stack.peek();
	}

	/*
	 * Tests if this stack is empty.
	 */
	public boolean empty() {
		return stack.empty();
	}
}
