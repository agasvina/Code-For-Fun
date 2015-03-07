import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class FlowerGarden {
	
	public static ArrayList<Integer> temp = new  ArrayList<Integer>();
	public static Map<Integer, flower> flowerMap = new HashMap<Integer, flower>();
	public static boolean[] planted;
	
	public static void main(String [] args) {
		
	int [] h = 	{5,4,3,2,1};
	int [] b = 	{1,5,10,15,20};
	int [] w = 	{5,10,15,20,25};

	getOrdering(h,b,w);
	
	}
	
	
	public static boolean isBlocking(flower a, flower b) {
		if(a.value < b.value) {
			return false;
		}  else {
			if( b.bloom >= a.bloom && b.bloom <= a.wilt) {
				return true;
			} else {
				return false;
			}
			
		}
		
		
	}
	

	
	public static int [] getOrdering(int [] h, int [] b, int [] w) {
		//populate map:
		for(int i = 0; i < h.length; i++) {
			flowerMap.put(h[i], new flower(h[i], b[i], w[i]));
		}
		
		
		Arrays.sort(h);
		//lets make the map... HAHAHA
		for(int i = h.length -1; i >= 0; i--) {
			for(int k = i-1; k >= 0; k--) {
			//	if(isBlocking(a1, a2, a3, b1, b2, b3))
				if(isBlocking(flowerMap.get(h[i]), flowerMap.get(h[k]))) {
					flowerMap.get(h[i]).adj.add(flowerMap.get(h[k]));
				}
			}
			
			
		}
		//make the boolean
		planted = new boolean[h[h.length-1] + 1];
		
		for(int i = h.length -1; i >= 0; i--) {
			addToArray(flowerMap.get(h[i]));
		}
		
		int [] res = new int[temp.size()];
		for(int i = 0; i < temp.size();i++ ) {
			res[i] = temp.get(i);
			System.out.print(res[i] + " ");
		}
		
		return  res;
	}
	
	
	
	public static void addToArray(flower f) {
		//assume the planted boolean is all false, no plant is planted
		//this is recursion..
		int height = f.value;
		for(int i = 0; i < f.adj.size(); i++) {
			addToArray(f.adj.get(i));
		}
		
		if(!planted[height]) {
			temp.add(height);
			planted[height] = true;
		}
		
		
		
	}
	
	
}

class flower {
	int value; 
	int bloom; 
	int wilt; 
	public ArrayList<flower> adj;
	public flower(int h, int b, int w) {
		value = h;
		bloom = b;
		wilt = w;
		adj = new ArrayList<flower>();
	}
	
}

