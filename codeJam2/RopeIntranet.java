import java.util.*;
import java.io.*;

public class RopeIntranet{
    
    public static void main(String [] args) throws FileNotFoundException {
        Scanner fsn = new Scanner(new File("/home/luca/Documents/Code-For-Fun/codeJam2/input.txt"));
          int cases = fsn.nextInt();
          for(int i = 1; i <= cases; i++) {
            int tEl = fsn.nextInt();
            int [] left = new int[tEl];
            Map <Integer, Integer> temp = new HashMap<Integer, Integer>();
            for(int k = 0; k < tEl; k++) {
                left[k] = fsn.nextInt();
                temp.put(left[k], fsn.nextInt());
            }
            Arrays.sort(left);
            int j = 0; int cursor = 0; int counter = 0;
            boolean inc = true;
            while(j < left.length) {
            	if(left[j] < temp.get(left[j])) {
            		inc = true;
            		cursor = j+1;
            	} else if(left[j] > temp.get(left[j])) {
            		inc = false;
            		cursor = j-1;
            	} else {
            		j++; continue;
            	}
            	if(inc) {
            		while(cursor < left.length) {
            			if(temp.get(left[j]) > left[cursor]) {
            				counter++;
            			} else {
            				break;
            			}
            			cursor++;
            		}
            	} else {
            		while(cursor >= 0) {
            			if(temp.get(left[j]) < left[cursor]) {
            				counter++;
            			} else {
            				break;
            			}
            			cursor--;
            		}
            		
            		
            	}
            	j++;
            	
            }
            
          System.out.println("Case #"+ i +": " + counter);  counter = 0;
            
          } 
          
    }

}
