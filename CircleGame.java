import java.util.*;
public class CircleGame{ 
	
	public static void main(String [] args) {
		System.out.println(cardsLeft("A234459"));
	}
 
	public static  int cardsLeft(String deck) {
		int [] dummy = new int[deck.length()];
		for(int i = 0; i < deck.length(); i++) {
			if(deck.charAt(i) == 'K')  {
				dummy[i] = 13; continue;
			}
			if(deck.charAt(i) == 'T')  {
				dummy[i] = 10; continue;
			}
			if(deck.charAt(i) == 'J') {
				dummy[i] = 11; continue;
			}
			if(deck.charAt(i) == 'Q') { dummy[i] = 12; continue;
			
			}
			if(deck.charAt(i) == 'A') {
				dummy[i] = 1; continue;
			}
			dummy[i] = Integer.parseInt(deck.charAt(i)+"");
		}
		Arrays.sort(dummy);
		
		int i1 = 0;
		int i2 = dummy.length-1;
		while(i2 > i1) {
			if(dummy[i1] == 13)  {
				return 0;
			}
			if(dummy[i2] == 13) {
				dummy[i2] = -1;
				i2--; continue;
			}
			if((dummy[i2] + dummy[i1]) == 13) {
				dummy[i1] = -1;
				dummy[i2] = -1;
				i1++;
				i2--;
				continue;
			} else if (dummy[i2] + dummy[i1] < 13){
				i1++;
			} else if  (dummy[i2] + dummy[i1] > 13) {
				i2--;
			}
			}
		int counter  = 0;
		for(int i = 0; i < dummy.length;i++) {
			if(dummy[i] != -1) counter++;	
			//System.out.print(dummy[i] + " ");
		}
		//System.out.println();
		return counter;
		
	
	
	}

	//This is an elegant solution
	 public int cardsLefts(String deck) {
		    StringBuffer sb = new StringBuffer(deck);
		    for (int i=0; i < sb.length(); i++) {
		      if (sb.charAt(i) == 'K') {
		        sb.deleteCharAt(i);
		        i=-1;
		      }
		      else if (val(sb.charAt(i)) + val(sb.charAt((i+1)%sb.length())) == 13) {
		        sb.deleteCharAt(i);
		        sb.deleteCharAt((i)%sb.length());
		        i=-1;
		      }
		    }
		    return sb.length();

		  }

		  public int val(char c) {
		    if (c == 'A') return 1;
		    if (c >= '2' && c <= '9') return c - '0';
		    if (c == 'T') return 10;
		    if (c == 'J') return 11;
		    if (c == 'Q') return 12;
		    if (c == 'K') return 13;
		    System.err.println("error");
		    return -1;
		  } 




}
