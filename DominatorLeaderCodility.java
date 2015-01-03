/*
This is the question.. 
for the link and explanation, check this out
https://codility.com/demo/results/demo963WZG-6YZ/


A zero-indexed array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

    A[0] = 3    A[1] = 4    A[2] =  3
    A[3] = 2    A[4] = 3    A[5] = -1
    A[6] = 3    A[7] = 3

The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

    class Solution { public int solution(int[] A); } 

that, given a zero-indexed array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

Assume that:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

For example, given array A such that

    A[0] = 3    A[1] = 4    A[2] =  3
    A[3] = 2    A[4] = 3    A[5] = -1
    A[6] = 3    A[7] = 3

the function may return 0, 2, 4, 6 or 7, as explained above.

Complexity:

        expected worst-case time complexity is O(N);
        expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.


*/



public class DominatorLeaderCodility {
  //this is the solution for the codility test...
  public int solution(int[] A) {
        // write your code in Java SE 
        int value = 0;
        int size = 0;
        //We calculate the value of the most value of appear from the array
        //We keep that in the value. 
        for (int i = 0; i < A.length; i++) {
            if(size == 0) {
                size++;
                value = A[i];
            } else {
                if (value != A[i]) {
                    size -=1;
                } else {
                    size++;
                }
            }
        }
        int candidate = -1;
        if(size > 0) {
            candidate = value;
        }
        int index = -1;
        int count = 0;
        //This step determine wheter the most element of the array is more than half of array length!
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                count++;
                index = i;
            }
        }
        
        //if it's not more than half we return -1
        //otherwise we return the index... 
        //Note here we don't return the value itself..
        
        if(count > (A.length/2)) {
            return index;
        } else {
            return -1; 
        }
    
    }




}
