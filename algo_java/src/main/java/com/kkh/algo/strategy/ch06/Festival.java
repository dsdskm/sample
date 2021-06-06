package com.kkh.algo.strategy.ch06;

public class Festival {
    /*
    L개의 팀을 섭외해서 페스티벌 개최
    N일간의 공연장 대여 비용을 알고 있다
    L일 이상을 연속해서 사용하되, 하루 평균 대여 비용을 최소로
    [3,1,2,3,1,2]
    (1+2+3)/3 = 2, (1+2+3+1)/4 = 1.75
    답은 1.75
     */
    public static void main(String args[]) {
        /*
        1. 순회하면서 L+a의 평균을 계속 구한다
         */
        System.out.println(solution(new int[]{3, 1, 2, 3, 1, 2}, 3));
        System.out.println(solution(new int[]{1, 2, 3, 1, 2, 3}, 3));
        System.out.println(solution(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public static float solution(int N[], int L) {
        float min = Float.MAX_VALUE;
        for (int i = 0; i < N.length; i++) {
            int baseSum = 0;
            if (i < N.length - L + 1) {
                for (int j = i; j < i + L; j++) {
                    baseSum += N[j];
                }
                min = Math.min(min, (float) baseSum / L);
                int totalSum = baseSum;
                int day = 1;
                for (int k = i + L; k < N.length; k++) {
                    totalSum += N[k];
                    float avg = (float) totalSum / (float) (L + day);
                    min = Math.min(min, avg);
                    day++;
                }
            }


        }

        return min;
    }
}
