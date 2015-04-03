//THIS IS REALLY AWESOME!! OKAY 
/*
First of all you can convert the Base 10 to any number using this: method
    Integer.toString(int i,int radix); 
        Isn't it really cool or what????? I just realize that 
        there is a build in function for this.. 
        I am so happy.... 
        
        And then if you really neeed to convert any base to base 10..
        You can simply use this method below... 
        Integer.parseInt(int i, int radix);
        
        Note: radix is base.... 

*/

import java.util.*;
public class BaseMystery {
		
	public static int[] getBase(String eq) {
		String [] n = eq.split("[+=]");
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 2; i <=20; i++) {
			try {
				int a = Integer.parseInt(n[0], i);
				int b = Integer.parseInt(n[1],i);
				int c = Integer.parseInt(n[2], i);
				if(a + b == c) res.add(i);
			} catch (Exception e) {
				//do nothing...
			}
		}
		int [] result = new int[res.size()];
		for(int i = 0; i < res.size(); i++) result[i] = res.get(i);
		
		return result;
	}



}
