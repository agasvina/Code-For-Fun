public class Quicksort {
    
    public static void QuickSort(int[] A) {
        sorts (A,0, A.length);
        
    }
    
    public static void sorts(int [] A, int s, int f) {
        if(f - s < 2) return;
        int m = divide(A,s,f);
        sorts (A, s, m);
        sorts (A, m+1, f);
    }
    
    public static int divide(int []A, int s, int f) {
        int m = A[A.length-1];
        int firstHigher = s;
        for(int i = s; i < f; i++) {
           if(A[i] < m) {
               swap(A, i, firstHigher);
               firstHigher++;
           }
        }
        swap(A, firstHigher, f-1);
        return firstHigher;
    }
    

    public  static void swap(int [] A,int i,int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[i] = tmp;
    }
    
    }
