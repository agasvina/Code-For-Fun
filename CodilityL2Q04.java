//Solution for codility Lesson2-04


class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int [] dummy = new int[N+1];
        int maxCum = 0;
        int max = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == (N+1)) {
            dummy = new int[N+1];
            maxCum = max;
            } else {
                dummy[A[i]]++;
                if(max < (dummy[A[i]] + maxCum) ) max = (dummy[A[i]] + maxCum);
            }
    }
        int [] res = new int[N];
        for(int i = 0; i < res.length; i++) {
            res[i] = dummy[i+1] + maxCum;
        }
        return res;

    }
