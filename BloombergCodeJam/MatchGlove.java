//Problem        : Mug Color
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_65
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Your submission should *ONLY* use the following class name
public class Problem {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        Map<String, Integer> map = new HashMap<String, Integer>();
        int match = 0;
        for (int i = 0; i < n; i++) {
            String s = stdin.next();
            if (!isPal(s)) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    String rev = rev(s);
                    if (map.containsKey(rev)) {
                        map.put(rev, map.get(rev) - 1);
                        match++;
                        if (map.get(rev) == 0) {
                            map.remove(rev);
                        }
                    } else {
                        map.put(s, 1);
                    }
                }
            }
        }

        if (!map.isEmpty()) {
            match = -1;
        }

        stdin.close();
        System.out.println(match);
    }

    public static boolean isPal(String s) {
        return s.equals(rev(s));
    }

    public static String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }

}