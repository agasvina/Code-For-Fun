import java.util.ArrayList;


public class Permutation {

	public static void main(String [] args) {
		ArrayList<String> test = new ArrayList<>();
		test.add("a");
		test.add("b");
		test.add("c");
		findP("", test);
	}
	
	public static void findP(String app, ArrayList<String> toPerm)  {
		if(toPerm.size() == 1) System.out.println(app + toPerm.get(0));
		for(int i = 0; i < toPerm.size();i++) {
			String add = app+ toPerm.get(0);
			String temp = toPerm.remove(0);
			findP(add, toPerm);
			toPerm.add(temp);
		}
	}
	
	
	
	
}

