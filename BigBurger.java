public class BigBurger {

	public static int maxWait(int [] ar, int [] se) {
		int tTime = 0;
		int mWait = -1;
		for(int i = 0; i < ar.length; i++) {
			if(tTime > ar[i]) {
				int temp = tTime - ar[i];
				tTime += se[i];
				mWait= Math.max(temp, mWait);
			} else {
				tTime = ar[i]+ se[i];
			
			}
		}
		if(mWait == -1) return 0;
		return mWait;
		}	
		
	
	}
