package com.kkh.algo.codingtest.dynamic;

public class LV3CodingTest_DP2_Solution {
    public static void main(String args[]) {
        LV3CodingTest_DP2_Solution l = new LV3CodingTest_DP2_Solution();
        System.out.println(l.solution(new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        }));    //30

    }

    int max = 0;

    public int solution(int[][] triangle) {

        /*
        삼각형의 높이는 1 이상 500 이하입니다.
        삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
        1. 모든 합을 구해본다
        -> 좌대각 = i+1, 우대각=i+1,j+1
        2. 중복으로 겹치는 경우는 큰 수를 선택한다
        triangle배열을 대체해간다
        부모 값중 큰 값으로 대체 한다
         */

        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                // right top check
                int rightTop = 0;
                if (j < triangle[i - 1].length) {
                    // right top 있다
                    rightTop = triangle[i - 1][j];
                }

                // left top check
                int leftTop = 0;
                if (j - 1 >= 0) {
                    // left top 있다
                    leftTop = triangle[i - 1][j - 1];
                }
                //System.out.println("t:" + triangle[i][j] + " , leftTop : " + leftTop + " , rightTop : " + rightTop);
                triangle[i][j] += Math.max(leftTop, rightTop);
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        //getSum(triangle, 0, 0, triangle[0][0]);

        return answer;
    }

    private void getSum(int[][] triangle, int i, int j, int sum) {
        //좌로 내려가는 경우 i가 triangle 행보다 크면 안된다
        if (i == triangle.length - 1 || j == triangle.length - 1) {
            max = Math.max(max, sum);
            System.out.println("sum : " + sum + " , i : " + i + " , j : " + j);
            return;
        }
        int left = triangle[i + 1][j];
        int right = triangle[i + 1][j + 1];
//        System.out.println("left sum : " + (left + sum) + " , right sum : " + (right + sum));
        getSum(triangle, i + 1, j, left + sum);
        getSum(triangle, i + 1, j + 1, right + sum);
    }

}
