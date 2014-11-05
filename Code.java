import java.util.HashMap;
import java.util.Map;


public class Code {


    public static void main(String[] args) {
        String s = getNoMoreThan3("aaaabbbbbahhkkkkkjkjkjkjkjkjkjkjhkjkd");
        System.out.print(s);

    }
    
    
    
    
    public static String getNoMoreThan3(String s) {
        Map<Character, Integer>  temp = new HashMap();
        int startIdx = 0;
        int st2 = 0;
        int st3 = 0;
        int max = -1;
        int counter = 1;
        int MaxIdx = 0;
        // boolean ones = false;

        for(int i = 0; i < s.length(); i++) {
            System.out.println("star1: " +s.charAt(startIdx) + " " + counter );
            temp.put(s.charAt(i), 1);
            
            if(temp.size() > 3) {
                
                temp.clear(); temp.put(s.charAt(st3), 1); temp.put(s.charAt(st2), 1);
                
                if(max < counter) { max = counter; MaxIdx = startIdx;
                System.out.println("Max: " + max + " MaxIdx:" + MaxIdx);
                }
                startIdx = st2; st2 = st3; st3 = i;
                temp.put(s.charAt(i), 1);
                counter= st3 - startIdx+1;
                System.out.println(s.charAt(startIdx) + " " + s.charAt(st2) + " " +  counter);
                //  ones = false;
            } else {
                counter++;
            }


            if(s.charAt(st3) != s.charAt(i)) {
                st2 = st3;
                st3 = i;
                System.out.println("st2: " +s.charAt(i) );

            }
        }
        if(max < counter) { max = counter; MaxIdx = startIdx;
        System.out.println("Max: " + max + " MaxIdx:" + MaxIdx);
        }

        
        return s.substring(MaxIdx, MaxIdx+max);
        
    }
    
    
    public static String getNoMoreThan2(String s) {
        Map<Character, Integer>  temp = new HashMap();
        int startIdx = 0;
        int st2 = 0;
        int max = -1;
        int counter = 1;
        int MaxIdx = 0;
        // boolean ones = false;

        for(int i = 0; i < s.length(); i++) {
            System.out.println("star1: " +s.charAt(startIdx) + " " + counter );
            temp.put(s.charAt(i), 1);
            
            if(temp.size() > 2) {
                
                temp.clear(); temp.put(s.charAt(st2), 1);
                if(max < counter) { max = counter; MaxIdx = startIdx;
                System.out.println("Max: " + max + " MaxIdx:" + MaxIdx);
                }
                startIdx = st2; st2 = i;
                temp.put(s.charAt(i), 1);
                counter= st2 - startIdx+1;
                System.out.println(s.charAt(startIdx) + " " + s.charAt(st2) + " " +  counter);
                //  ones = false;
            } else {
                counter++;
            }


            if(s.charAt(st2) != s.charAt(i)) {
                st2 = i;
                System.out.println("st2: " +s.charAt(i) );

            }
        }
        if(max < counter) { max = counter; MaxIdx = startIdx;
        System.out.println("Max: " + max + " MaxIdx:" + MaxIdx);
        }

        
        return s.substring(MaxIdx, MaxIdx+max);
        
    }
    






}


class Polynomial{
    
    HashMap<Integer, Integer> poly;
    
    public Polynomial() {
        poly = new HashMap<Integer, Integer>();
        
    }
    
    public static Polynomial addPolynomial(Polynomial p1, Polynomial p2) {
        HashMap<Integer, Integer> cloneP2 = (HashMap<Integer, Integer>) p2.poly.clone();
        Polynomial result = new Polynomial();
        for( int key1: p1.poly.keySet()) {
            if(p2.poly.get(key1) != null) {
                result.poly.put(key1, p1.poly.get(key1) + cloneP2.get(key1) );
                p2.poly.remove(key1);
            } else {
                result.poly.put(key1, p1.poly.get(key1));
            }
        }
        if(p2.poly.size() > 1) {
            for (int key2: cloneP2.keySet()) {
                result.poly.put(key2, cloneP2.get(cloneP2));
            }
        }
        
        
        return result;
    }
    
    public static void printPoly(Polynomial p) {
        for(int key1: p.poly.keySet()) {
            System.out.print(" " + p.poly.get(key1) + "x^" + key1 + " ");
        }
        System.out.println();
    }

    public static Polynomial derivatives(Polynomial p) {
        Polynomial result = new Polynomial();
        for(int key1: p.poly.keySet()) {
            result.poly.put(key1-1, p.poly.get(key1)* key1);
        }
        return result;
    }
    
    
    
    
}



