import java.util.*;
import java.io.*;

public class T9 {
public static void main(String [] args) throws FileNotFoundException {
Map <Character, Integer> temp = new HashMap<>();
temp.put('A', 2);
temp.put('B', 22);
temp.put('C', 222);
temp.put('D', 3);
temp.put('E', 33);
temp.put('F',333);
temp.put('G', 4);
temp.put('H',44);
temp.put('I',444);
temp.put('J',5);
temp.put('K',55);
temp.put('L',555);
temp.put('M',6);
temp.put('N',66);
temp.put('O',666);
temp.put('P',7);
temp.put('Q',77);
temp.put('R',777);
temp.put('S',7777);
temp.put('T',8);
temp.put('U',88);
temp.put('V',888);
temp.put('W',9);
temp.put('X',99);
temp.put('Y',999);
temp.put('Z',9999);
temp.put((char)32, 0);
Scanner fsn = new Scanner(new File("./input.txt"));
int total = fsn.nextInt(); fsn.nextLine();
for (int i = 1; i <= total; i++) {
String t = fsn.nextLine().toUpperCase();
String [] arr = t.split("\\s+");
System.out.print("Case #"+i+":");
char prev = '!';
for(int k = 0; k < t.length(); k++) {
	String cur= temp.get(t.charAt(k))+"";
	if(cur.charAt(0) == prev) { 
	System.out.print(" ");
	System.out.print(temp.get(t.charAt(k)));
	 } else {
	System.out.print(temp.get(t.charAt(k)));
	}
	prev = cur.charAt(0);
}
	System.out.println();


}



}//eom
}//eoc
