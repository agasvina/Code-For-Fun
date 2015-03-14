import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class VendingMachine {

	public static void main(String[] args) {    	
		String [] p = {"100 200 300",
		 				"600 500 400"};
		String [] pur = {"0,0,0", "1,1,10", "1,2,20",
						 "0,1,21", "1,0,22", "0,2,35"};
		
		System.out.println(motorUse(p, pur));
	}
	
	
	
	public static int motorUse(String[] p, String [] pur) {
		String [] temp = p[0].split("\\s+");
		int col = temp.length;
		int row = p.length;
		int [][] val = new int[row][col];
		ArrayList<Vending> dummy = new ArrayList<Vending>();
		for(int i = 0; i < temp.length; i++) {
			dummy.add(new Vending(i,Integer.parseInt(temp[i])));
			val[0][i] = Integer.parseInt(temp[i]);
		}
		if(p.length > 1) {
			for(int i = 1; i < p.length; i++) {
				temp = p[i].split("\\s+");
				for(int k = 0; k < temp.length;k++)  {
					dummy.get(k).value += Integer.parseInt(temp[k]);
					val[i][k] = Integer.parseInt(temp[k]);
				}
			}
		}
		int max = Collections.max(dummy, new ComparatorV()).colId;
		int cursor = max;
		int move = movement(0,max,col);
		String [] ts2 = pur[0].split(",");
		int prev = Integer.parseInt(ts2[2]);
		boolean[][] buy = new boolean[row][col];
		for(int i = 0; i < pur.length;i++) {
			String [] ts = pur[i].split(",");
			if(Integer.parseInt(ts[2]) - prev >= 5) {
				max =  Collections.max(dummy, new ComparatorV()).colId;
				move += movement(cursor,max,col);
				cursor = max;
			}
			if(buy[Integer.parseInt(ts[0])][Integer.parseInt(ts[1])]) return -1;
			move += movement(cursor, Integer.parseInt(ts[1]), col);
			cursor = Integer.parseInt(ts[1]);
			prev = Integer.parseInt(ts[2]);
			buy[Integer.parseInt(ts[0])][Integer.parseInt(ts[1])] = true;
			dummy.get(Integer.parseInt(ts[1])).value -=val[Integer.parseInt(ts[0])][Integer.parseInt(ts[1])];
		}
		
		max = Collections.max(dummy, new ComparatorV()).colId;
		move += movement(cursor,max,col);
		
		return move;
	}

	
	public static int movement(int a, int b, int length) {
		return Math.min (Math.abs(b-a) , Math.abs(a+length-b));
	}
	
}



class Vending {
	public int colId;
	public int value; 
	public Vending(int c, int v) {
		this.colId = c;
		this.value = v;
	}
	
}

 class ComparatorV implements Comparator<Vending> {
    
    @Override
    public int compare(Vending o1, Vending o2) {
        if (o1.value < o2.value) {
            return -1;
        } else if( o1.value > o2.value) {
            return 1;
        } else {
        	if(o1.colId > o2.colId) {
        		return -1;
        	} else {
        		return 1;
        	}
        	
        }
    }
    
}

