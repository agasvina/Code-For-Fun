//make a shortest palindrome.
import java.util.ArrayList;


public class codeCon {

    static ArrayList<Integer> frontier = new ArrayList<Integer>(); 
    static ArrayList<Integer> temp = new ArrayList<Integer>();
    public static void main(String [] args) {
        
            
        String test = "cuted";
        int p1 = ((test.length()/2)-1);
        int p2 = p1+1;
        int mid = p1;
        int counter = 0;
        if(test.length() < 1) return;
        if(test.length() == 3) {
        	p1 = test.length()/2;
        	p2 = p1+1;
        	mid = p1;
        } 
        
        for(int i = 0; i < test.length(); i++) {
        	frontier.add((int) test.charAt(i));
        }
        
        while (p2 < test.length()) {
            if(p1 >= 0) {
	           if(frontier.get(p2) == frontier.get(p1)) {
	               p1--; p2++; counter=0; continue; 
	           }
	           if(frontier.get(p2) != frontier.get(p1)) {
	              p2=p1+1; p1--; counter++; 
	           }
	           if (counter == 2) {
	        	   //reset mid;
	        	   temp = new ArrayList<Integer>();
	        	   mid--; p1 = mid; p2 = p1+1;
	        	   continue;
	           }
	           
           } else {
        	   temp.add(frontier.get(p2)); p2++;
           }

           }
      System.out.println(frontier.size()+temp.size());

        
    }
    
    
    
    
}

