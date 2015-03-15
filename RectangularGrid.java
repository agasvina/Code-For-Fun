
public class RectangularGrid {

	public static void main(String [] args) {
		System.out.println(grid(998, 999));
		
	}
	
	public static long grid(int x, int y) {
		long res = 0;
		int b = (x>y)? x: y;
		for(int i = 1; i <= b; i++) {
			for (int j = 1; j <= b; j++) {
				if(i == j) continue;
				long temp1 = (1 + (x-i) )*((y-j) + 1);
				res += (temp1 < 0)? 0: temp1;
			}
		}
		
		return res;
	}
}

