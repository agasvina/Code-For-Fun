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



public static String longestSubstring(String x, int lh) {
		Map<Character, Integer> temp = new HashMap<>();
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);temp.put(x.charAt(0), 1);
		int sidx = 0; int max = 0;
		for(int i = 0; i < x.length(); i++) {
			if(x.charAt(arr.get(arr.size()-1)) != x.charAt(i) ) {
				arr.add(i);
				if(temp.get(x.charAt(i)) == null){
					temp.put(x.charAt(i), 1);
				} else {
					temp.put(x.charAt(i), temp.get(x.charAt(i))+1);
				}
			}
			if(temp.size() > lh) {
				int l = i -  arr.get(0);
				if(max < l) {
					sidx = arr.get(0);
					max = l;
				}
				char t = x.charAt(arr.get(0));
				 if(temp.get(t) == 1) {
					 temp.remove(t);
				} else {
					temp.put(t, temp.get(t)-1);
				}
				arr.remove(0);
				
			}
		}
		if(max ==0 && sidx == 0 && temp.size() == lh) return x;
		return x.substring(sidx, sidx+max);
	}
	
	Priorityqueue
	
import javax.script.*;
public class CalculateUsingJavascript{
	public static int evaluate(String s) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		int res = 0;
		try {
		res = (int) engine.eval(s);
		
		} catch(Exception e) {}
		return res;
	
	}//eom


}//eoc
