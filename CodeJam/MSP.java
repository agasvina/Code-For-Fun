import java.util.*;
import java.io.*;

public class MSP {
public static void main(String [] args) throws FileNotFoundException {
Scanner fsn = new Scanner(new File("./input.txt"));
int total = fsn.nextInt();
for(int i = 1; i <= total; i++) {
int l = fsn.nextInt();
int [] a1 = new int[l];
int [] a2 = new int[l];
for(int k = 0; k < a1.length;k++) {
a1[k] = fsn.nextInt();
}
for(int k = 0; k < a1.length;k++) {
a2[k] = fsn.nextInt();
}
Arrays.sort(a1);
Arrays.sort(a2);
int val = 0;
for(int k = 0; k <a1.length; k++) {
val += a1[k]*a2[l-1-k];
}
System.out.print("Case #" + i+ ": ");
System.out.println(val);
}//eof
fsn.close();
}

}
