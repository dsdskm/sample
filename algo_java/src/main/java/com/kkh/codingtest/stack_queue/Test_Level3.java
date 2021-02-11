package com.kkh.codingtest.stack_queue;

public class Test_Level3 {
    public Test_Level3() {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})); // [2,1]
    }

    public static void main(String args[]) {
        new Test_Level3();
    }


    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int []{};


        /*

        날짜가 경과하면서 완성도를 체크해야함

        */

        boolean isCompleted = false;
        while (!isCompleted) {
            // 진행률 계산
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] = progresses[i] + speeds[i];
            }

            // 완성도 체크


        }

        return answer;

    }

}
