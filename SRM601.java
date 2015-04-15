import java.util.*;

public  class SRM601{

}

class WinterAndMandarins{
	public static int getNumber(int [] bags, int k) {
		Arrays.sort(bags);
		if(k ==bags.length) return bags[bags.length-1] - bags[0];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < bags.length-k+1; i++){
			int dif = bags[i+k-1] - bags[i];
			min = Math.min(dif, min);
		}//eofi
		return min;
	}

}


//import java.util.*;
class WinterAndCandies{
	static int mow;
 public int getNumber(int [] type) {
    	//this is just the number of possible element..
    	int [] count = new int[51];
    	//let's count the occurence of the element
    	for(int i = 0; i < type.length;i++) {
    		count[type[i]]++;
    	}
    	int sum = 0;
    	int prod = 1;
    	//now we calculate how many possible element we can make...
    	//wow this is really smart...
    	for(int i = 1; i < count.length;i++) {
    		prod *= count[i];
    		sum += prod;
    		if(prod == 0) break;
    	}
    	return sum;
    }
    
    
    public static void rec(int [] t, int idx, Map<Integer, Integer> mp) {
        if(idx == t.length-1) {
        	HashMap<Integer, Integer> dummy = new HashMap<Integer, Integer>();
        	dummy.putAll(mp);
        	if(dummy.get(t[idx]) == null) {
        		dummy.put(t[idx],1);
        		int max = t[idx];
        		if(max == dummy.size()) mow++;
            }
        } else {
            for(int i = idx; i < t.length; i++) {
            	HashMap<Integer, Integer> dummy = new HashMap<Integer, Integer>();
            	dummy.putAll(mp);
            	if(dummy.get(t[i]) == null) {
            		dummy.put(t[i],1);
            		int max = t[i];
            		if(max == dummy.size()) mow++;
                    rec(t, i+1, dummy);
            	}
            }
        }
    }//eom
    

}
