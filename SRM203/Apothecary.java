import java.util.*;
public class Apothecary{
		public static int [] balance(int w) {
		ArrayList<Integer> temp = new ArrayList<>();
		int delta = w;
		int sum = 0;
		while (delta != 0) {
			int pow = log(Math.abs(delta), 3) ;
			int addval = (int) Math.pow(3, pow);
			if(delta > 0) {
				temp.add(addval);
				sum += addval;
			} else {
				temp.add( -1 * addval);
				sum -= addval;
			}
			delta = w-sum;
		}
		int [] result = new int[temp.size()];
		Collections.sort(temp);
		for(int i = 0; i < temp.size();i++) result[i] = temp.get(i);
		
		return result;
	}
	
	static int log(int x, int base)
	{
	    return  (int) Math.round((Math.log(x) / Math.log(base)));
	}
	


}
