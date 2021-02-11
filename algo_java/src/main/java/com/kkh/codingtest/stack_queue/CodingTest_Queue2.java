package com.kkh.codingtest.stack_queue;

public class CodingTest_Queue2 {
    public static void main(String args[]) {
        new CodingTest_Queue2();
    }

    public CodingTest_Queue2() {
        System.out.println(solution(new int[]{6, 9, 5, 7, 4}));
        //System.out.println(solution(new int[]{3, 9, 9, 3, 5, 7, 2}));
//        System.out.println(solution(new int[]{1, 5, 3, 6, 7, 6, 5}));
//        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7}));
        //System.out.println(solution(new int[]{7, 8, 7, 8, 7, 8, 7}));
//        System.out.println(solution(new int[]{9, 8, 7, 6, 5, 4, 3}));
    }

    public int[] solution(int heights[]) {
        int[] answer = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] > heights[j]) {
                    answer[j] = i + 1;
                }
            }
        }

        return answer;

    }
}
