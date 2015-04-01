import java.util.*;
public class RegularSeason{
	
	public static String[] finalStandings(String[]t, int r){
		ArrayList<Score> temp = new ArrayList<>();
		for(int i = 0; i < t.length; i++)  temp.add(new Score());
		for(int i = 0; i < t.length; i++)  {
			String [] tp = t[i].split("\\s+");
			temp.get(i).ss = tp[0];
			for(int j = 1; j < tp.length; j++) {
				if(i != j-1) {
				int p1 = Integer.parseInt(tp[j]);
				double stemp = (double) p1*r/100;
				temp.get(i).sd += stemp;
				temp.get(j-1).sd += (double) r - stemp;	
				}//eoif
			
		}//eofj
		}//eofi
		for(int i = 0; i < temp.size(); i++) {
			temp.get(i).si = (int) Math.round(temp.get(i).sd);
		}
		Collections.sort(temp, new Comparator<Score>() {
			
			@Override 
			public int compare( Score o1, Score o2) {
				if(o1.si < o2.si) { return 1; }
				 else if(o1.si == o2.si) {
						if(o1.ss.compareTo(o2.ss) < 0) {
							return -1; 
						} else { return 1; }
					
				 }
				return -1; 
			}
		
		});
	String [] rst = new String[temp.size()];
	for(int j = 0; j < rst.length; j++) {
		rst[j] = temp.get(j).ss + " " + temp.get(j).si;
	
	}
	return rst;
	
	}//eom




}//eoc

class Score {
	public double sd = 0;
	public int si = 0;
	public String ss = "";
	
	
}
