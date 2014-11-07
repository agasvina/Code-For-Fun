import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Sorting {

    static void merge(int[] a, int[] l, int[] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
    }

    public static int[] merge(int[] A, int[]B) {
        int[]mergeArr = new int[A.length+B.length];
        int Aidx = 0; int Bidx = 0; int idx = 0;
        while(Aidx < A.length  && Bidx < B.length ) {
            if(A[Aidx] <= B[Bidx]) {
                mergeArr[idx] = A[Aidx];
                Aidx++; idx++;
            } else {
                mergeArr[idx] = B[Bidx];
                Bidx++; idx++;
            }
        }
        //populate the rest
        if(Aidx < A.length) {
            for(int i = idx; i < mergeArr.length; i++) {
                mergeArr[i] = A[Aidx]; Aidx++;
            }
        } else {
            for(int i = idx; i < mergeArr.length; i++) {
                mergeArr[i] = B[Bidx]; Bidx++;
            }
        }

        return mergeArr;
    }

    public static ArrayList<Integer> findingDivisor(int N) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 1;
        int res = 0;
        while (i * i < N) {
            if(N%i == 0) {
                result.add(i);
                //for the divided as well: N/i
                result.add(N/i);
            }
            i++;
        }
        if(i*i == N) {
            result.add(i);
        }
        return result;
    }


    public int solution2(String S) {
        // write your code in Java SE 8
        ArrayList<Integer> divisor =  findingDivisor(S.length());
        Collections.sort(divisor);
        int div = 0;
        
        divisor:
            for(int i = 0; i < divisor.size(); i ++) {
                div = divisor.get(i);
                for (int j = 0; j < divisor.get(i); j++) {
                    for(int k = j+divisor.get(i); k < S.length(); k = k + divisor.get(i)) {
                        if(S.charAt(j) != S.charAt(k)) continue divisor;
                    }
                }
                return S.length()/div;
            }
        
        
        return 1;
    }

    public static int[] MergeSort(int [] A) {
        if (A.length > 1) {
            int[] left = Arrays.copyOfRange(A, 0, A.length/2);
            int[] right = Arrays.copyOfRange(A, (A.length/2),A.length);
            for(int i = 0; i < left.length; i++) {
                System.out.print("Left: " + left[i]);
            }
            System.out.println();
            for(int i = 0; i < right.length; i++) {
                System.out.print("Right: " + right[i]);
            }
            System.out.println();
            MergeSort(left);
            MergeSort(right);
            merge(A, left,right);
            for(int i = 0; i < A.length; i++) {
                System.out.print(" " + A[i]);
            }
            System.out.println("length: " + A.length);
            return A;
        } else {
            return A;
        }
    }
    
    
    public static String nonDup(String s) {
        String temp = "";
        Map<Character, Integer> sMap = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            if( sMap.get(s.charAt(i)) == null ) {
                sMap.put(s.charAt(i), 1);
            } else {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i))+ 1);
            }
        }
        for(char ch : sMap.keySet()) {
            if(sMap.get(ch) == 1) {
                temp = temp + ch;
            }
        }
        
        return temp;
    }

}
