import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Test {

	public static void main(String [] args) throws FileNotFoundException {
		//Scanner fsn = new Scanner(new File("/cs/home/as362/Code-For-Fun/Code-For-Fun/CodeJam/test.txt"));
		String [] b = {"ALICE 0 1 -1 3",
			 "BOB 1 0 2 -4",
			 "CAROL -1 2 0 2",
			 "DAVID 3 -4 2 0"};
		formMap(b);
		for(int k : temp.keySet()) {
			System.out.println(Arrays.toString(temp.get(k)));
		}
		
//		for(int k = 2; k <= 3; k++) {
//			System.out.println(k);
//		}
//
int [] t =  {0,1,2,3};
		pCom(t, "", 0, 3, 1,0, new ArrayList<Integer>());
		
	
	}
	
	static Map<Integer, int []> temp = new HashMap<>();
	
	public static void formMap(String [] people) {
		for(int i = 0; i < people.length; i++) {
			String [] t = people[i].split("\\s+");
			int [] val = new int[people.length];
			for(int k = 1; k < t.length; k++) {
				val[k-1] = Integer.parseInt(t[k]);
			}
			temp.put(i, val);
		}
	}
	
	public static void pCom(int [] a, String app, int id, int num, int te, int sum,  ArrayList<Integer> ar) {
		if(te == num ) {
			int idp = id-1;
			for(int i = id; i < a.length; i++) {
				System.out.println(app+ a[i] +"Sum: " + sum);
			}
		} else {
			int iter = 1;
			for(int i = id; i <= (a.length - num +1); i++) {
				ArrayList<Integer> t = (ArrayList<Integer>) ar.clone();		
				if(t.size() )
				int idx = i+1; int s = sum; 
				for(int k = te+1; k <= num; k++) {
					s += temp.get(id)[idx];
					System.out.print( "Bamp: " + i + "-" + idx + " "+temp.get(i)[idx] + " ");
					idx++; if(idx >= a.length) break;
				}
				iter++;
				System.out.println("Sum: " +s);
				pCom(a, app+a[i], i+1,num, te+1,s, t);
			}
			
			
		}
		
		
		
	}
}

