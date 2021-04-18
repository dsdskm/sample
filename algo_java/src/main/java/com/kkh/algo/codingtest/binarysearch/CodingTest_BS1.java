package com.kkh.algo.codingtest.binarysearch;

import java.util.Arrays;

public class CodingTest_BS1 {

    public static void main(String args[]) {
        new CodingTest_BS1();
    }

    public CodingTest_BS1() {
        System.out.println(solution(new int[]{120, 110, 140, 150}, 485));
//        System.out.println(solution(new int[]{120, 100, 100, 100, 100}, 600));
    }

    public int solution(int[] budgets, int M) {
        int answer = 0;

        Arrays.sort(budgets);

        long sum = 0;
        for (int budget : budgets) sum += budget;

        if (sum <= M) {
            return budgets[budgets.length - 1];
        }

        // 가장 큰 예산요청을 최대값으로 설정
        int max = budgets[budgets.length - 1];
        // 전체 예산을 예산요청의 개수로 나누어 최저값을 설정
        int min = (int) Math.floor(M / budgets.length);
        int mid = 0;
        int compareMid = 0;

        while (true) {
            mid = (int) Math.ceil((max + min) / 2);
            System.out.println("mid = " + mid+" , max = "+max);
            sum = 0;

            for (int budget : budgets) {
                System.out.println("    budget = " + budget + " , mid = " + mid);
                sum += (budget > mid) ? mid : budget;
            }
            System.out.println("sum = " + sum);

            // 더 이상 상한값의 변화가 없다면 종료
            if (mid == compareMid) {
                answer = mid;
                break;
            }

            if (sum > M) {
                max = mid;
            } else {
                min = mid;
            }
            compareMid = mid;
        }

        return answer;
    }
}
