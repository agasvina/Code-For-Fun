
public class BadNeighbors {

	
	public static void main(String[] args) {
		
		//int [] A = 	{221, 118, 376, 194, 434, 965, 42, 347, 109, 611, 22, 72, 270, 213, 459, 305, 982, 749, 30, 481, 598, 578, 744, 625, 882, 224, 800, 896, 612, 480, 862, 250, 596, 464, 700, 859, 198, 962, 187, 618};
		int [] A = 	{924, 602, 959, 7, 608, 218, 523, 697, 292, 980, 881, 265, 205, 256, 198, 862, 142, 940, 715, 482, 425, 288, 791, 929, 876, 594, 704, 404, 682, 901, 719, 450, 81, 114, 738, 498, 657, 72, 966};
		getMaxProfit(A);
		
	}
	
	public static void getMaxProfit(int [] A) {
		if(A.length < 2) return;
		boolean [] first = new boolean[A.length];
		first[0] = true;
		int [] sum = new int[A.length];
		int maxTemp = 0;
		boolean boolTemp = false;
		for(int i = 0; i < A.length; i++) {
			if(i != A.length-1) {
			sum[i] = A[i];
			if(i -2 >= 0) {
				int temp = sum[i-2] + A[i];
				if(sum[i] < temp) {
					sum[i] = temp;
				if(first[i-2]) first[i] = first[i-2];
				}
			} 
			if(i - 3 >= 0 ) {
				int temp = sum[i-3] + A[i];
				if(sum[i] < temp) {
					sum[i] = temp;
					if(first[i-3]) first[i] = first[i-3];
				}
			}
			} else {
				sum[i] = A[i];
				if(i -2 >= 0) {
					int temp = 0;
					if(!first[i-2]) {
						temp = A[i] + sum[i-2];			
					} else {
						temp = A[i] + sum[i-2] - A[0];
					}
					  if(sum[i] < temp) {
						sum[i] = temp;
					}
				} 
				if(i - 3 >= 0 ) {
					int temp = 0;
					if(!first[i-3]) {
						temp = A[i] + sum[i-3];
					} else {						
						temp = A[i] + sum[i-3] - A[0];
					}
					  if(sum[i] < temp) {
						sum[i] = temp;
					}
				}	
			}		
		}//end of for
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < sum.length; i++) {
			if(max <sum[i]) max = sum[i];
		}
		
		System.out.println( "Max donation: " + max);
		
	}
	
}

