package com.kkh.algo.codility;

import java.util.Hashtable;

public class Demo {
    public static void main(String args[]) {
        new Demo();
    }

    public Demo() {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{-1,-3}));
    }

    public int solution(int[] A) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < A.length; i++) {
            hashtable.put(A[i], A[i]);
        }
        int answer = 0;
        for (int i = 1; i < 1000000; i++) {
            if (!hashtable.containsKey(i)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
