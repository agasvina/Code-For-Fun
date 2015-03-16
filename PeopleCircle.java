public class  PeopleCircle {

	public static String order(int nM, int nF, int k) {
	
		int [] a = new int[nM+nF];
		int  cur = 0;
		int inc = k-1;
		for(int i = 0; i < nF; i++) {
			int delete =getInd(cur, a.length, k);
			while(a[delete] != 1) {
				delete++;
				if(delete > a.length) delete = 0;
				
			}
			a[delete] = 1; //change into female;
			cur = delete +1;
			if(cur > a.length) cur = 0;
		}
		String s = "";
		for(int i = 0; i < a.length; i++)
			if(i == 0) { s += "M"; 
			} else { s+= "F";}
		return s;
	}
	
	
	public static int getInd(int id, int l, int k) {
		int c = -1;
		int d = l - id;
		if(d >= ((k-1)%l)) {
			c = d + ((k-1) %l); }
		else {
			c = ((k-1) - (l-id)) %l;
		}
		return c;
		
	
	}
	
	}

/*
An Elegant solution found online:
import java.util.Arrays;
 
public class PeopleCircle{
    public String order(int numMales, int numFemales, int K){
        char[] ret = new char[numMales+numFemales];
        int pos = ret.length-1;
        Arrays.fill(ret, 'M');
        for(int i = 0; i < numFemales; i++){
            for(int j = 0; j < K; ){
                pos = (pos+1)%ret.length;
                //notes if the current position is female we skip. thus the value of j stay the same
                while the value of pos increasing in circle... 
                if(ret[pos] == 'M') j++;
            }
            ret[pos] = 'F';
        }
        //this is one of a neat way to build a string.. WOW
        return new String(ret);
    }
}*/
	
