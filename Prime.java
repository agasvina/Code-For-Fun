import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Prime {
    
    // using the sieve.. this is become soo cool!
    public static ArrayList<Integer> findPrimeBelow(int N) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean [] pTemp= new boolean[N+1];
        int i = 2;
        pTemp[0] = pTemp[1] = true;
        while(i*i <= N) {
            if(!pTemp[i]) {
                int k = i*i;
                while (k <= N) {
                    pTemp[k] = true;
                    k+=i;
                }
            }
            i++;
        }
        for(int p = 0; p < pTemp.length; p++) {
            if(!pTemp[p]) {
                result.add(p);
            }
        }
        
        
        return result;
    }

    public static Set<Integer> findFactor(int N) {
        Set<Integer> result = new HashSet();
        boolean [] pTemp= new boolean[N+1];
        int i = 2;
        pTemp[0] = pTemp[1] = true;
        while(i*i <= N) {
            if(!pTemp[i]) {
                int k = i*i;
                while (k <= N) {
                    if(N%k == 0) {
                        result.add(k);
                        result.add(N/k);
                    }
                    k+=i;
                }

            }
            i++;
        }

        return result;
    }


    public static ArrayList<Integer> findSemiPrime(int N) {
        ArrayList<Integer> semiPrime = new ArrayList<Integer>();
        int i = 2;
        int k = 1;
        boolean [] sieve = new boolean[N+1];
        sieve[0] = true;
        sieve[1] = true;
        while(i * i <= N) {
            if(!sieve[i]) {
                k = i*i;
                while (k <= N) {
                    sieve[k] = true;
                    k+=i;
                }
            }
            i++;
        }//end of while
        //give the semiprime number
        i = 2;
        while(i*i <= N){
            if(!sieve[i]) {
                for(int j = i*i; j < N+1; j = j+i) {
                    if(j %i == 0 && !sieve[j/i]) {
                        semiPrime.add(j);
                    }
                }
            }
            i++;
        }
        //sort the semi Prime...
        Collections.sort(semiPrime);
        return semiPrime;
    }
    

    public static void main(String[] args) {
        ArrayList<Integer> result = findPrimeBelow(30);
        for(int i = 0; i < result.size(); i++) {
            System.out.print(" " + result.get(i) + " " );
        }

        System.out.println(" ");
        Set<Integer> set2 = findFactor(20);

        System.out.println(" ");

        result = findSemiPrime(30);
        for(int i = 0; i < result.size(); i++) {
            System.out.print(" " + result.get(i) + " " );
        }


    }
    
}
