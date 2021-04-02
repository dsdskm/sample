package com.kkh.codinginterview.ch07;

import java.util.HashMap;
import java.util.Iterator;

public class P103 {
    /*
    a,b,c,d가 1~1000 사이의 정수 값 중 하나일때
    a^3+b^3 = c^3+d^3 을 만족하는 모든 자연수를 구하시오
     */

    public static void main(String args[]) {
        solution(1000);
    }

    public static void solution(int n) {
        HashMap<Integer, int[]> hash = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                hash.put((int) (Math.pow(i, 3) + Math.pow(j, 3)), new int[]{i, j});
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int sum = (int) (Math.pow(i, 3) + Math.pow(j, 3));

                if (hash.containsKey(sum)) {
                    int arr[] = hash.get(sum);
                    if(i!=arr[0] && i!=arr[1]){
                        System.out.println(i + "+" + j + "=" + arr[0] + "+" + arr[1]);
                    }
                }
            }
        }
    }
}
