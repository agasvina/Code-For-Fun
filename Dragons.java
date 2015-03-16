import java.util.*;
public class Dragons {
	public static String snaug(int [] initFood, int round) {
	
		ArrayList<RNum> temp = new ArrayList<RNum>();
		for (int i = 0; i <initFood.length; i++) {
			temp.add(new RNum(initFood[i]));
		}
		for(int i = 0; i < round; i++) {
			RNum UD23 = RNum.add( RNum.add(temp.get(0), temp.get(1)), RNum.add(temp.get(4), temp.get(5)) );			
			RNum FB01 = RNum.add( RNum.add(temp.get(2), temp.get(3)), RNum.add(temp.get(4), temp.get(5)) );
			RNum RL45 = RNum.add( RNum.add(temp.get(2), temp.get(3)), RNum.add(temp.get(0), temp.get(1)) );
			temp.clear();
			temp.add(divBy4(FB01));
			temp.add(divBy4(FB01));
			temp.add(divBy4(UD23));
			temp.add(divBy4(UD23));
			temp.add(divBy4(RL45));
			temp.add(divBy4(RL45));

			
		}
		String res = "";
		if (temp.get(2).d != 1) {
				res =  temp.get(2).n + "/" + temp.get(2).d; }
		else {
				res += temp.get(2).n;
		}
	
		return res;
	}

	public static RNum divBy4(RNum a) {
		RNum res = new RNum(a.n, a.d *4);
		res.reduction();
		return res;
	}

}


class RNum {
	public int n;
	public int d;
	public RNum(int n, int d) {
		this.n = n;
		this.d = d;
	}
	public RNum (int inte) {
		this.n = inte;
		this.d = 1;
	
	}
	public void reduction() {
		int smallest = 1;
		int gcd = 1;
		smallest = (n < d) ? n: d;
		for(int loop = 2; loop <= smallest; ++loop) {
		 if(n % loop == 0 && d % loop == 0 ) gcd = loop;
		}
		n /= gcd;
		d /= gcd;
	} 
	
	public static RNum add( RNum a, RNum b) {
		RNum res = new RNum(1,1);
		res.n = (a.n*b.d) + (b.n * a.d);
		res.d = a.d * b.d;
		res.reduction();
		return res;
	
	}
	

}
