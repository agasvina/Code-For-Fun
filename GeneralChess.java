import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GeneralChess{
	
	public static void main(String [] args) {
		String [] t = {"0,0"};
		System.out.println(Arrays.toString(t));
		attackPositions(t);
		
		
	}
	public static String [] attackPositions(String [] p) {
		Map<String, Integer> temp = new HashMap<>();
		for(int k = 0; k < p.length;k++) {
				Scanner sb = new Scanner(p[k].replace(',',' '));
				int x= sb.nextInt();
				int y = sb.nextInt();
				int [] val = {1,-1,-2, 2};
				for(int i = 0; i < val.length; i++) {
					for(int j = 0; j < val.length && Math.abs(val[i]) != Math.abs(val[j]);j++) {
						System.out.println("Bummer");
						int yt = y+val[j];
						int xt = x+val[i];
						String coor = xt + "&" + yt;
						System.out.println(coor + " " +val[i] + " " + val[j]);
						if(temp.get(coor) == null) {
							temp.put(coor,1);
						} else {
							temp.put(coor, temp.get(coor) + 1);
						}
						
						 yt = y+val[i];
						 xt = x+val[j];
						 coor = xt + "&" + yt;
						System.out.println(coor + " " +val[i] + " " + val[j]);
						if(temp.get(coor) == null) {
							temp.put(coor,1);
						} else {
							temp.put(coor, temp.get(coor) + 1);
						}
					}//eofj
				}//eofi

			
		
		
		}//eofk
		ArrayList<String> tp = new ArrayList<String>();
		for(String key: temp.keySet()) {
			if(temp.get(key) == p.length)  {
				System.out.println(key);
				tp.add(key);
			}
		
		}
		Collections.sort(tp);
		for(String x : tp) {
			System.out.println(tp);
		}
		
		return null;

	
	
	}//eom	




}


class Node {
	public int x;
	public int y;

}
