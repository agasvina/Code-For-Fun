import java.util.*;
import java.io.*;

/*
Note:
I run in terminal for generated the output file.
java Solution >> out.txt
*/

public class Solution {
	public static void main (String [] args)throws FileNotFoundException {
		Scanner fsn = new Scanner(new File("./input.txt"));
		      int total = fsn.nextInt();
		for(int k = 0; k < total; k++) {
			int money = fsn.nextInt();
			int items = fsn.nextInt();
			int counter = -1;
			Map <Integer, Integer> temp = new HashMap<>();
			Map <Integer, ArrayList<Integer>> temp2 = new HashMap<>();
			int [] arr = new int[items];			
			for(int i = 0; i < items; i++) {
				arr[i] = fsn.nextInt();
				if(temp.get(arr[i]) != null) {
					int idx = temp.get(arr[i]);
					temp2.put(counter, new ArrayList<Integer>());
					temp2.get(counter).add(idx);
					temp2.get(counter).add(i);
					temp.put(arr[i], counter);
					counter--;
				} else {
					temp.put(arr[i], i);
				}
			}
			Arrays.sort(arr);
			int id1 = 0; int id2 = arr.length-1;
			while(id1 != id2) {
				if(arr[id2] > money) {
					id2--; 				
				} else if (arr[id2] + arr[id1] > money) {
					id2--; 
				} else if (arr[id2] + arr[id1] < money) {
					id1++;
				} else if ((arr[id1] + arr[id2]) == money) {	
					break;
				} 
			}
			int v1 = temp.get(arr[id1]); int v2 = temp.get(arr[id2]);
			if(v1 < 0)  { int t = v1; v1 = temp2.get(v1).get(0); temp2.get(t).remove(0); }
			if(v2 < 0)  { int t = v2; v2= temp2.get(v2).get(0); temp2.get(t).remove(0); }
			if(v1 > v2) {
				System.out.println("Case #"+(k+1)+":"+(v2+1) +" " +(v1+1));
			} else {
				System.out.println("Case #"+(k+1)+":"+(v1+1) +" " +(v2+1));
			}



		}

	}//eom

}//eoc
