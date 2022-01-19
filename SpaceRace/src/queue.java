import java.util.ArrayList;

public class Queue<T> {
	
	private Stack<T> a, b;
	private int size;
	
	public Queue() {
		a = new Stack<T>(); //in stack
		b = new Stack<T>(); //out stack
		size = 0;
	}
	
	//return Null if empty
	public T remove() {
		//check out Stack, if not empty, pop from it and return
		//if empty, transfer all elements from in Stack to out Stack
		//then pop and return from out Stack
		
		int i = 0; //index
		
		if(b.size() >= 0) {
			while(i<b.size()) {
				b.pop();
				i++;
				size++;
			}
		} else {
			while(i<a.size()) {
				b.push(a.pop());
				i++;
				size--;
			}
		}
		
		return null;
	}
	
	public void add(T el) {
		//always add to in Stack
		a.push(el);
		size++;
	}
	
	public String toString() {
		//will it be helpful to be able to print your queue anytime?
		
		
		return null;
	}

	public static void main(String[] args) {
		//design your own tests to see if your Queue is working as intended
		
		Queue test = new Queue();
		System.out.println(test.remove().toString());
		
	}

}
