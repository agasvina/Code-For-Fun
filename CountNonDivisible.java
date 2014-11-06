
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
* Just some solution for codility task: CountNonDivisible
*/
class CountNonDivisible {
//Worst time Complexity: O(NLogN)
    public int[] solution(int[] A) {
            HashMap<Integer, Integer> temp = new HashMap<Integer,Integer>();
        HashMap<Integer, Integer> dummy = new HashMap<Integer,Integer>();

        for(int i  = 0; i < A.length; i++) {
            if(temp.get(A[i]) != null) {
                temp.put(A[i], 1 + temp.get(A[i]));
            } else {
                temp.put(A[i], 1);
                
            }
            
        }
        
        //clone to map..
        //finding the divisor
        int total = A.length;
        int i;

        
        //we find the prime number..
        int[] res = new int[A.length];
        int divisor = 0;
        for(int k = 0; k < A.length; k++) {
            i = 1;
            while (i * i <=A[k] ) {
                if(A[k]%i == 0) {
                    if(temp.get(i) != null && dummy.get(i) == null) {
                        dummy.put(i, temp.get(i));
                        divisor = temp.get(i)+ divisor;
                    }
                    if(temp.get(A[k]/i) != null && dummy.get(A[k]/i) == null) {
                        dummy.put(A[k]/i, temp.get(A[k]/i));
                        divisor = temp.get(A[k]/i)+ divisor;
                    }

                }
                i++;
                if(i*i == A[k]) {
                if(temp.get(i) != null && dummy.get(i) == null) {
                    dummy.put(i, temp.get(i));
                    divisor = temp.get(i)+ divisor;
                }
                }
            }
            res[k] = A.length - divisor;
            divisor = 0;
            dummy.clear();

        }

        return res;
       
}
}
