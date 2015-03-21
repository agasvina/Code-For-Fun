import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class ContestScore {
	
    public static String [] sortResults(String [] data) {
        Map<String, grp> temp = new HashMap<String, grp>();
        ArrayList<ArrayList<grp>> t = new ArrayList<ArrayList<grp>>();
        for(int i =0; i < data.length; i++) {
            String [] d = data[i].split("\\s+");
            temp.put(d[0],new grp(d[0], 0));
            for(int j = 1; j < d.length;j++) {
                t.add(new ArrayList<grp>());
            }
            
            for(int j = 0; j < d.length-1;j++) {
                 grp tp = new grp(d[0], Double.parseDouble(d[j+1]));
                 t.get(j).add(tp); 
            }
            
        }//eof
    
        for(int j = 0; j < t.size();j++) {
        	Collections.sort(t.get(j),new Comparator<grp>(){

				@Override
				public int compare(grp o1, grp o2) {
					if(o1.sum < o2.sum) return 1;
					return -1;
				}});        
        
        } //eofsma
        
        for(int j = 0; j < t.size();j++) {
        	for(int k = 0; k < t.get(j).size(); k++) {
        		String nm = t.get(j).get(k).name;
        		grp jr = t.get(j).get(k);
        		grp dm = temp.get(nm);
        		dm.sum += jr.sum;
        		dm.rank += k+1;
        	}
        }
        ArrayList<grp> calcu = new ArrayList<grp>();
        for(String key: temp.keySet()) {
        	calcu.add(temp.get(key));
        }
        
       	Collections.sort(calcu,new Comparator<grp>(){

				@Override
				public int compare(grp o1, grp o2) {
					if(o1.rank > o2.rank) return 1;
					if(o1.rank == o2.rank) {
						if(o1.name.compareTo(o2.name)<0) return -1;
						return 1;
						
					}
					return -1;
				}});  
        
             String [] s = new String[calcu.size()];
        DecimalFormat decim = new DecimalFormat("0.0");
        for(int j = 0; j < calcu.size(); j++) {
            Double price2 = Double.parseDouble(decim.format(calcu.get(j).sum));

        	s[j] = calcu.get(j).name + " " + calcu.get(j).rank + " " + price2;
        }
        return s;
    }//eom
    }

class grp {
    public String name;
    public double sum;
    public int rank = 0;
    public grp(String n, double s) {
        this.name = n;
        this.sum = s; 
    }
}

