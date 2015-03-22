//This is Quick select algorithm... so that 
//the (max) Kth-element can be found in order O(n) time
//isn't it cool or what?!

import java.util.ArrayList;


public class qs {
	public static void main(String [] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(78);
		arr.add(2);
		arr.add(3);
		arr.add(8);
		arr.add(5);
		System.out.println(qss(arr, 5));
		
		
	}
	
    public static int qss(ArrayList<Integer> A, int  k) {
    	int idp = A.size()-1;
    	int pv = A.get(idp);
	    ArrayList<Integer> A1 = new ArrayList<>();
	    ArrayList<Integer> A2 = new ArrayList<>();
	    for(int i : A) {
		    if(i < pv)  { 
		    	A1.add(i); 
		    } else if(i > pv){
		    	A2.add(i);
		    }
	    }
		//recusive call:
		if(k <= A1.size()) return qss(A1, k);
		if(k > A.size() - A2.size()) return qss(A2, k - (A.size() - A2.size()));
		return pv;

    }    

}
