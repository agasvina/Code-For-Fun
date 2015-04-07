import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        String ns = stdin.nextLine();
        int n = Integer.parseInt(ns);
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String col = stdin.nextLine();
            arr[i] = col;
        }
        stdin.close();

        StringBuilder out = new StringBuilder();
        int len = arr[0].length();
        for (int i = 0; i < len; i++) {
            Map<Character, Integer> counter = new HashMap<Character, Integer>();
            for (int j = 0; j < n; j++) {
                Character c = arr[j].charAt(i);
                if (counter.containsKey(c)) {
                    counter.put(c, counter.get(c) + 1);
                } else {
                    counter.put(c, 1);
                }
            }
            int max = 0;
            Character ch = 0;
            for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
                int count = entry.getValue();
                if (count > max) {
                    ch = entry.getKey();
                    max = count;
                }
            }
            out.append(ch);
        }
        System.out.println(out.toString());
    }
}
