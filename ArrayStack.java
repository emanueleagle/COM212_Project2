/**
 * COM212 Data Structures
 * Stack implementation with Array
 */

public class ArrayStack<E> {
	
	private int capacity = 100;
	private E[] elements;
	private int t = -1;

	@SuppressWarnings("unchecked")

	public ArrayStack() {
		elements = (E[])(new Object[capacity]);
	}
	
	public int size() { return t+1; }
	public boolean isEmpty() { return t==-1;}
	
	public void push(E e) {
		// full?
		if (size() == elements.length) {
			System.out.println("Error: stack is full.");
			return;
		}
		
		elements[++t] = e;
	}
	
	public E pop() {
		// empty?
		if (isEmpty()) {
			System.out.println("Error: stack is empty.");
			return null;
		}
		E val = elements[t];
		elements[t] = null;
		t--;
		return val;
	}
	
	public E top() {
		// empty?
		if (isEmpty()) {
			System.out.println("Error: stack is empty.");
			return null;
		}
		
		return elements[t];
	}
	
	public String toString() {
		
		// go over all elements
		if (isEmpty())
			return "The list is empty";
		
		String outstr = "Elements in the stack:\n";
		for (int i=0; i<t+1; i++) {
			outstr = outstr + elements[i].toString() + "\n";	
		}
		
		return outstr;	
	}
	
	public static void main(String[] args) {
		
		ArrayStack<String> myStack = new ArrayStack<String>();
		myStack.push("Jose");
		myStack.push("Amanda");
		System.out.println(myStack);
	}
}