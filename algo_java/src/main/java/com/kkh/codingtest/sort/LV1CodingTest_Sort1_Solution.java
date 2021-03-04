package com.kkh.codingtest.sort;

import java.util.Arrays;

public class LV1CodingTest_Sort1_Solution {

    /*
    배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
    예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
    array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
    1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
    2에서 나온 배열의 3번째 숫자는 5입니다.
    배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     */

    public static void main(String args[]) {
        LV1CodingTest_Sort1_Solution l = new LV1CodingTest_Sort1_Solution();

        System.out.println(l.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));       // 5,6,3
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int index = 0; index < commands.length; index++) {
            int[] c = commands[index];
            int i = c[0];
            int j = c[1];
            int k = c[2];

            // i ~ j 까지 자른다
            int[] new_arr = new int[j - i + 1];
            System.arraycopy(array, i - 1, new_arr, 0, j - i + 1);
            // 정렬후 k 번쨰
            Arrays.sort(new_arr);
            answer[index] = new_arr[k-1];
        }
        return answer;
    }

}
