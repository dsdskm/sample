package com.kkh.codingtest.dynamic;

import java.util.Arrays;

public class LV3CodingTest_DP3_Solution {
    public static void main(String args[]) {
        LV3CodingTest_DP3_Solution l = new LV3CodingTest_DP3_Solution();
        System.out.println(l.solution(3, 4, new int[][]{{2, 2}}));
    }

    int answer = 0;

    public int solution(int m, int n, int[][] puddles) {
        /*
        https://velog.io/@ajufresh/등굣길
        시작 [1,1]    종료 [m,n]
        물잠긴 지역은 0개이상 10개이하

        brute force로 찾다가 물을 만나면 멈춘다
         */

        int arr[][] = new int[n + 1][m + 1];

        arr[1][1] = 1;
        for (int p[] : puddles) {
            arr[p[1]][p[0]] = -1;
        }


        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                // 웅덩이는 0 으로 바꾸고 넘어간다.
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                } else {
                    if (i == 1) {
                        arr[i][j] += arr[i][j - 1];
                    } else {
                        arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 1000000007;
                    }
                }

                //마지막 값 answer
                if (j == arr[i].length - 1) {
                    answer = arr[i][j];
                }
            }
        }

        //goSchool(1, 1, m, n, puddles);
        return answer;
    }

    private void goSchool(int x, int y, int m, int n, int[][] puddles) {
        System.out.println("goSchool x:" + x + ",y:" + y + ",m:" + m + ",n:" + n);
        for (int i = 0; i < puddles.length; i++) {
            if (x == puddles[i][0] && y == puddles[i][1]) {
                return;
            }
        }

        if (x + 1 <= m) {
            goSchool(x + 1, y, m, n, puddles);
        }

        if (y + 1 <= n) {
            goSchool(x, y + 1, m, n, puddles);
        }

        if (x == m && y == n) {
            //System.out.println("goSchool x:" + x + ",y:" + y + ",m:" + m + ",n:" + n);
            answer = answer + answer % 1000000007;
            return;

        }
    }
}
