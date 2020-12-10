package com.kkh.condigtest.sort;

import java.util.Arrays;

public class CodingTest_Sort3 {

    public static void main(String agrs[]) {
        new CodingTest_Sort3();
    }

    public CodingTest_Sort3() {
//        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution(new int[]{3, 0, 6, 1, 5,4}));
    }

    public int solution(int[] citations) {
        int answer = 0;
        // n편중 h번 이상 인용된 논문이 h편
        // h의 최대값

        Arrays.sort(citations);

        int n = 1;
        int max_h = 0;
        while (true) {
            int count = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= n) {
                    count++;
                }
            }
//            System.out.println("count = " + count + " , n = " + n);
            if (count == n) {
                if (max_h < count) {
                    max_h = count;
                }
            }
            if (count < n) {
                if (max_h < count) {
                    max_h = count;
                }
                break;
            }
            n++;
        }
        answer = max_h;
        return answer;
    }
}
