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

/*
MY STUDYCS SOLUTION

//For this problem, you may assume you can use the Stack we started together in class
public class Queue<T>{

    //instance vars to be added by student
    private Stack<T> a, b;
	private int size;

    //constructor to be added by student
    public Queue() {
		a = new Stack<T>(); //in stack
		b = new Stack<T>(); //out stack
		size = 0;
	}
	
    //remove and return the element at the beginning of the list
    public T remove(){
        int i = 0; //index
		
		
		if(b.size() == 1) {
		    size--;
		    return b.pop();
		}
		else if(b.size() > 1) {
			//while(i<b.size()) {
			    size--;
			    //b.pop is last in, first out
			    //need to return first in, first out
			    b.pop();
			    b.pop();
				return b.pop();
				//i++;
			//}
		} else if (b.size() == 0) {
		    size = 0;
		    return null;
		} else /*(a.size() > 0)*/ {
		    i = 0;
			while(i<a.size()) {
				b.push(a.pop());
				i++;
				//size--;
				//remove();
			}
			size--;
			return b.pop();
		}
    }

    //add element at the end of the list
    public void add(T el){
        b.push(el);
		size++;
    }

    //return a String representation of the list
    //formatted as [el1, el2, el3, ..., elN]
    public String toString(){
        return "";
    }


    public int size(){
      return size;
    }

}

*/
