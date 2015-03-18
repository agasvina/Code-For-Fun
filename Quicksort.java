public class Quicksort {
    /*
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
    */



	//write a generic comparable type
	public class Quicksort {
		 
	    private static <T extends Comparable<T>> 
	    int split(T[] list, int lo, int hi) {
	        int left=lo+1;
	        int right=hi;
	        T pivot = list[lo];
	         
	        while (true) {
	            while (left <= right) {
	                if (list[left].compareTo(pivot) < 0) {
	                    left++;
	                } else {
	                    break;
	                }
	            }
	            //right cursor can only move as long as it's greater than left. 
	            
	            while(right > left) {
	                if (list[right].compareTo(pivot) < 0) {
	                    break;
	                } else {
	                    right--;
	                }
	            }
	            //we done  with more sweep
	            if (left >= right) {
	                break; // this is to break from the outer level loop
	            }
	 
	            // swap left and right items
	            T temp = list[left];
	            list[left] = list[right];
	            list[right] = temp;
	            //advance each one step
	            left++; right--;
	        }
	         
	        // swap pivot with left-1 position
	        list[lo] = list[left-1];
	        //moving the pivot.. so it can split correctly
	        list[left-1] = pivot;
	        // return the split point
	        return left-1;
	    }
	     
	    private static <T extends Comparable<T>>
	    void sort(T[] list, int lo, int hi) {
	        if ((hi-lo) <= 0) { // fewer than 2 items
	            return;
	        }
	        //method that will split the quicksort to left and right.
	        //done the recursive call with the left and right sub array
	        int splitPoint = split(list,lo,hi);
	        sort(list,lo,splitPoint-1);  // left subarray recursion
	        sort(list,splitPoint+1,hi);  // right subarray recursion
	    }
	     
	    public static <T extends Comparable<T>>
	    void sort(T[] list) {
	        if (list.length <= 1) {
	            return;
	        }
	        sort(list,0,list.length-1);
	    }
	}



    }
