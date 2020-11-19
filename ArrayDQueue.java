/**
 * COM212 Data Structures
 * DQueue implementation with Array
 *
 */

public class ArrayDQueue<E> {
	
	private int capacity = 100;
	private E[] data;
	private int f = 0;	// current index for the first element
	private int r = 0;	// current index for the last element
	private int size = 0;

	@SuppressWarnings("unchecked")
	
	public ArrayDQueue() {
		data = (E[])(new Object[capacity]);
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size==0;}
	
	public void addFirst(E e) {
		// full?
		if (size() == data.length) {
			System.out.println("Error: queue is full.");
			return;
		}
		
		if (size != 0)
			f = ( ( (f-1) % capacity ) + capacity ) % capacity;	// why?
		
		data[f] = e;
				
		size++;
	}
	
	public void addLast(E e) {
		// full?
		if (size() == data.length) {
			System.out.println("Error: queue is full.");
			return;
		}
		
		if (size != 0)
			r = (r+1) % capacity;

		data[r] = e;
		size++;
	}

	public E removeFirst() {
		// empty?
		if (isEmpty()) {
			System.out.println("Error: queue is empty.");
			return null;
		}
		
		E val = data[f];
		data[f] = null;
		f = (f+1) % capacity;
		size--;
		return val;
	}
	
	public E removeLast() {
		// empty?
		if (isEmpty()) {
			System.out.println("Error: queue is empty.");
			return null;
		}
		
		E val = data[r];
		data[r] = null;
		r = ( ( (r-1) % capacity ) + capacity ) % capacity;
		size--;
		return val;
	}
	
	public E getFirst() {
		// empty?
		if (isEmpty()) {
			System.out.println("Error: stack is empty.");
			return null;
		}
		
		return data[f];
	}
	
	public E getLast() {
		// empty?
		if (isEmpty()) {
			System.out.println("Error: stack is empty.");
			return null;
		}
		
		return data[r];
	}
	
	public String toString() {
		
		// go over all elements
		if (isEmpty())
			return "The list is empty";
		
		String outstr = "Elements in the DQueue:\n";
		int index;
		for (int i=f; i<f+size; i++) {
			index = i % capacity;
			outstr = outstr + data[index].toString() + "\n";	
		}
		
		return outstr;	
	}
	
	public static void main(String[] args) {
		
		ArrayDQueue<String> myDQueue = new ArrayDQueue<String>();
		myDQueue.addFirst("Jose");
		myDQueue.addFirst("Jazmin");
		myDQueue.addLast("Amanda");
		System.out.println(myDQueue);
		myDQueue.removeFirst();
		System.out.println(myDQueue);
		myDQueue.removeLast();
		System.out.println(myDQueue);
	}
}