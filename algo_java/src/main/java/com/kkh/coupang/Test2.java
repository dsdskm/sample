package com.kkh.coupang;

import java.util.*;

public class Test2 {
    public static void main(String args[]) {
        Test2 t = new Test2();
        System.out.println(t.solution(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 20)); //3
    }


    public int solution(int[] A, int S) {
        int psum = 0;
        int len_min = A.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            queue.offer(A[i]);
            psum = Math.max(psum, 0) + A[i];
            if (psum >= S) {
                while (psum > S) {
                    int p = queue.peek();
                    if (psum - p < S) {
                        break;
                    } else {
                        psum -= queue.poll();
                    }
                }
                len_min = Math.min(len_min, queue.size());
            }
        }
        int answer = len_min;
        return answer;
    }

}
