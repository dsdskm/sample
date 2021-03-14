package com.kkh.codingtest.dfsbfs;

public class LV2CodingTest_DFS1_Solution {
    public static void main(String args[]) {
        LV2CodingTest_DFS1_Solution l = new LV2CodingTest_DFS1_Solution();
        System.out.println(l.solution(new int[]{1, 1, 1, 1, 1}, 3)); //5
//        System.out.println(l.solution(new int[]{1, 2, 3, 4, 5}, 3)); //5
    }

    public int solution(int[] numbers, int target) {
        /*
        1. 재귀 호출하면서 덧셈,뺄샘 반복한다
         */

        int answer = cal(numbers, 0, target, 0);
        return answer;
    }

    private int cal(int[] numbers, int index, int target, int result) {
        if (index == numbers.length) {
            //System.out.println(space + text + " result : " + result);
            if (result == target) {
                return 1;
            } else {
                return 0;
            }

        }
        return cal(numbers, index + 1, target, result + numbers[index]) +
                cal(numbers, index + 1, target, result - numbers[index]);
    }

    public int solution_best(int[] numbers, int target) {
        return DFS(numbers, target, 0, 0);
    }

    public int DFS(int[] numbers, int target, int index, int num) {
        if (index == numbers.length) {
            return num == target ? 1 : 0;
        } else {
            return DFS(numbers, target, index + 1, num + numbers[index])
                    + DFS(numbers, target, index + 1, num - numbers[index]);
        }
    }

}
