import java.util.*;
import java.io.*;


public class Rev {
public static void main(String [] args) throws FileNotFoundException {
Scanner fsn = new Scanner(new File("./input.txt"));
int total = fsn.nextInt();fsn.nextLine();
for(int i = 1; i <= total;i++) {
	String [] temp = fsn.nextLine().split("\\s+");
	System.out.print("Case #"+ i+": ");
	for(int k = temp.length-1; k >= 0; k--) {
	System.out.print(temp[k] + " ");
	}
	System.out.println();
}

}

}
