package com.kkh.codingtest.sort;

import java.util.Arrays;

public class CodingTest_Sort1 {

    public static void main(String agrs[]) {
        new CodingTest_Sort1();
    }

    public CodingTest_Sort1() {
        System.out.println(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
    }

    public int[] solution(int[] array, int[][] commands) {
        int answer[] = new int[commands.length];
        int answer_index = 0;
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int index = commands[i][2];
            int res[] = new int[end - start + 1];
            System.arraycopy(array, start - 1, res, 0, end - start + 1);
            Arrays.sort(res);
            answer[answer_index++] = res[index - 1];
        }

        return answer;
    }
}
