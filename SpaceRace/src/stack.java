import java.util.ArrayList;

public class Stack<T> {
	
	//data
	private ArrayList<T> data; //int[] data, String[] myStr
	private int size; //# of elements in stack - not storage space size
	
	public Stack() {
		data = new ArrayList<T>(); //initialize array to have 10 spaces
		size = 0;
	}
	
	//getter for size
	public int size() {
		return size;
	}
	
	//push - add element to list
	public void push(T el) {
		data.add(0, el);
		size += 1; //update size
	}
	
	//pop - remove and return element from list
	//		should be from the "top" of the list
	public T pop() {
		//remove and return element from the top of the list
		//update other relevant instance vars
		T value = data.get(0);
		data.remove(0);
		size -= 1;
		return value;
		
	}
	
	
	public static void main(String[] arg) {
		
		//Add lines of code to test if implementation
		// of Stack works
		System.out.println(data);
		
	}
	
}
