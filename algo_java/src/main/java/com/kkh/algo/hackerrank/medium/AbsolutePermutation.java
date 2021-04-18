package com.kkh.algo.hackerrank.medium;

import java.util.Arrays;

public class AbsolutePermutation {
    public static void main(String args[]) {
        absolutePermutation(4, 2);
        absolutePermutation(2, 1);
        absolutePermutation(3, 0);
        absolutePermutation(3, 2);
    }

    static int[] absolutePermutation(int n, int k) {

        /*
        +k -k 로 만들 수 있는 모든 배열을 찾아봄
        원소가 고유한 게 있다면 해당 배열을 리
        n<=10^5

        1 2 3 4

        1       3
        2 4 0 2 4 0
         */
        int arr[] = new int[n];
        int pos[] = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
            if (i - k <= 0) {
                pos[i - 1] = i + k;
            } else {
                pos[i - 1] = i - k;
            }
        }
        int answer[] = pos.clone();
        // check
        Arrays.sort(pos);
        for(int i=0;i<pos.length;i++){
            if(pos[i]!=i+1){
                return new int[]{-1};
            }
        }
        return answer;

    }

}
