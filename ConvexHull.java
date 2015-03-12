import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class ConvexHull {

	public static void main(String [] args) {
		int [] x = {0,0,-3,-3,3,3};
		int  [] y = {-1,1,-3,3,-3,3};
//		int []x = {1, 2, 2, 4, 4, 6, 6, 5};
//		int []y = {0, 2,-2, 4,-4, 2,-2, 0};
//		
//		int [] x = {10,9,8,7,6,5,4,3,2,1};
//		int [] y = {1,4,9,16,25,36,49,64,81,100};

		int [] res = findPath(x, y);
		for(int i = 0; i < res.length;i++) {
			System.out.print(" " + res[i]);
		}
	}
	
	static Map<Integer, PointRobot> temp = new HashMap<Integer, PointRobot>();
	static ArrayList<PointRobot> tempD = new ArrayList<PointRobot>();
	
	
	public static int[] findPath(int [] x, int [] y) {
		//generate the point...
		int iLeftMost = -1;
		int maxPoint = Integer.MIN_VALUE;
		for(int i = 0; i < x.length;i++) {
			if(maxPoint < x[i]) {
				maxPoint = x[i]; iLeftMost = i;
			} else if(maxPoint == x[i]) {
				if(y[iLeftMost] > y[i]) {
					maxPoint = x[i]; iLeftMost = i;
				}
			}
			//generate new point... HAHAHAHAHA
			temp.put(i,new  PointRobot(i,x[i], y[i]));
			tempD.add(temp.get(i));
		}
		
		// update the degree.. 
		PointRobot leftMost = temp.get(iLeftMost);
		for(int i = 0; i < tempD.size(); i++) {
			PointRobot rTemp = tempD.get(i);
			rTemp.degree = Math.toDegrees(Math.atan2(rTemp.y-leftMost.y, rTemp.x - leftMost.x));
			if (rTemp.degree < 0) rTemp.degree += 360;
		}
		
		Collections.sort(tempD, new ComparatorP());
		boolean [] explored = new boolean[tempD.size()];
		explored[iLeftMost] = true;
		//System.out.println(iLeftMost);
		//for(int i = 0; i < tempD.size();i++) System.out.print(tempD.get(i).degree);
		ArrayList<Integer> points = new ArrayList<Integer>();
		points.add(tempD.get(0).idx);
		int now = 0; 
		int next=1;
		int next2=2;
		while(next2 < tempD.size() ) {
			if(PointRobot.isLeftTurn(tempD.get(now), tempD.get(next), tempD.get(next2))) {
				now = next;
				next = next2;
				next2++;
				points.add(tempD.get(now).idx);
				explored[tempD.get(now).idx] = true;
			} else {
				next= next2;
				next2++;
			}
			
			if(next2 == tempD.size()) {
				explored[tempD.get(next).idx] = true;
				points.add(tempD.get(next).idx);
				break;
				}
		}
		//find the lowest point of the remaining 
		while(true) {
			tempD.clear();
			for(int i =0; i < temp.size();i++) {
				if(!explored[temp.get(i).idx]) {
					tempD.add(temp.get(i));
				}
			}
			if(tempD.size() == 1)  {points.add(tempD.get(0).idx); break;}
			//find the bottom most...
			maxPoint = Integer.MAX_VALUE;
			for(int i = 0; i <tempD.size();i++) {
				if(maxPoint > tempD.get(i).y) {
					maxPoint =tempD.get(i).y; iLeftMost = tempD.get(i).idx;
				} else if(maxPoint == tempD.get(i).y) {
					if(temp.get(iLeftMost).x < tempD.get(i).x) {
						maxPoint = tempD.get(i).y; iLeftMost = tempD.get(i).idx;
					}
				}
			}
			points.add(iLeftMost);
			explored[iLeftMost] = true;
			if(points.size() == temp.size()) break;
			 leftMost = temp.get(iLeftMost);
			for(int i = 0; i < tempD.size(); i++) {
				PointRobot rTemp = tempD.get(i);
				rTemp.degree = Math.toDegrees(Math.atan2(rTemp.y-leftMost.y, rTemp.x - leftMost.x));
			}
			
			Collections.sort(tempD, new ComparatorP());
			//if()
			 now = 0; 
			 next=1;
			 next2=2;
			while(next2 < tempD.size() ) {
				if(PointRobot.isLeftTurn(tempD.get(now), tempD.get(next), tempD.get(next2))) {
					now = next;
					next = next2;
					next2++;
					points.add(tempD.get(now).idx);
					explored[tempD.get(now).idx] = true;
				} else {
					next= next2;
					next2++;
				}
				
				if(next2 == tempD.size()) {
					explored[tempD.get(next).idx] = true;
					points.add(tempD.get(next).idx);
					break;
					}
			}
		}
		int[] res = new int[points.size()];
		for(int i = 0; i < res.length;i++) {
			res[i] = points.get(i);
		}
		
		return res;
	}
	
	
	
}



class PointRobot {
	int idx;
	public double degree;
	int x;
	int y;
	public PointRobot(int i, int x, int y) {
		this.idx = i;
		this.x = x;
		this.y = y;
		degree = -1;
	}
	
	public static  boolean isLeftTurn(PointRobot a, PointRobot b, PointRobot c) {
		return ((b.x-a.x)*(c.y-a.y)) - ((b.y-a.y) *(c.x-a.x)) >= 0;
	}
	
}

 class ComparatorP implements Comparator<PointRobot> {
    
    @Override
    public int compare(PointRobot o1, PointRobot o2) {
        if (o1.degree < o2.degree) {
            return -1;
        } else if( o1.degree > o2.degree) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
