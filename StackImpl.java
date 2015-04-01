import java.util.*;

public class StackImpl{
	
	public static void main(String [] args) {
		StackImpl dummy = new StackImpl();
		dummy.push(3);
		dummy.push(2);
		dummy.push(-1);
		dummy.push(5);
		dummy.push(4);
		System.out.println(dummy.getMax());
		System.out.println(dummy.pop());
		System.out.println(dummy.pop());
		System.out.println("Maximum number now has change: "+ dummy.getMax());
	}


	ArrayList<Integer> m; 
	ArrayList<Integer> maxVal;
	int max; 
	
	public StackImpl() {
		m = new ArrayList<Integer>();
		maxVal = new ArrayList<Integer>();
		max = Integer.MIN_VALUE;
	}

	public int pop()  throws NoSuchElementException {
	//this will delete the top element of the stack
	 if(m.size() == 0) throw new NoSuchElementException();
	 maxVal.remove(maxVal.size()-1);
	 return m.remove(m.size()-1);
	}

	public void push(int z) {
		max = Math.max(max, z);
		m.add(z);
		maxVal.add(max);
	}

	public int getMax() {
		return maxVal.get(maxVal.size()-1);
	}
	
//the explanation of this is in THIS:
//http://stackoverflow.com/questions/3435926/insert-delete-max-in-o1
 	

}
