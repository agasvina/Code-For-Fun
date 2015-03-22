import java.util.ArrayList;
import java.util.Collections;

public class HourGlass {

	
	public static int[] measurable(int g1, int g2) {
        int max = g1 < g2? g2: g1;
        int min = g1 < g2? g1: g2;
        int mod = max % min;
        int del = max - min;
        int n1 = max;
        int n2 = min; 
        int n1add = max;
        int n1mod = max;
        int plus = min+ min;
        int plus2 = max + min;
        int plus3 = max + min;
        int plus4 = max+min;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 25; i++) {
            if(temp.indexOf(n1) ==-1) temp.add(n1);
            if(temp.indexOf(n2) ==-1) temp.add(n2);
            if(temp.indexOf(n1add) ==-1) temp.add(n1add);
            if(temp.indexOf(n1mod) ==-1) temp.add(n1mod);
            if(temp.indexOf(plus) ==-1) temp.add(plus);
            if(temp.indexOf(plus2) ==-1) temp.add(plus2);
            if(temp.indexOf(plus3) ==-1) temp.add(plus3);
            if(temp.indexOf(plus4) ==-1) temp.add(plus4);
            n1 += max;
            n2 += min;
            n1add += del;
            n1mod += mod;
            plus+= min;
            plus2+=max;
            if(i%2 ==0) {
            	plus3 += max;
            	plus4 += min;
            }else {
            	plus3+= min;
            	plus4+= max;
            }

        }
        Collections.sort(temp);
        int [] resu = new int [10];
        for(int i = 0; i < resu.length;i++) {
        	resu[i] = temp.get(i);
        }
        return resu;
        
    }


}
