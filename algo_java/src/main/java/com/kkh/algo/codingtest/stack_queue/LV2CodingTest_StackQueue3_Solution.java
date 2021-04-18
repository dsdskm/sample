package com.kkh.algo.codingtest.stack_queue;

import java.util.ArrayList;
import java.util.Stack;

public class LV2CodingTest_StackQueue3_Solution {
    /*
    프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다.
    각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
    또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
    이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
    먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
    각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
    각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

    작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
    작업 진도는 100 미만의 자연수입니다.
    작업 속도는 100 이하의 자연수입니다.
    배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
    예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.

    93,30,55            1,30,5          2,1
    95,90,99,99,80,99   1,1,1,1,1,1     1,3,2
     */
    public static void main(String args[]) {
        new LV2CodingTest_StackQueue3_Solution().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        new LV2CodingTest_StackQueue3_Solution().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }

    public int[] solution(int[] progresses, int[] speeds) {
        /*
        1. stack에 역순으로 넣고 뽑으면서 계산한다
        2. 한날에 동시에 완료되는 것들은 list의 동일 원소에 업데이트 되어야 한다
         */

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack_speed = new Stack<>();
        for (int i = progresses.length - 1; i >= 0; i--) {
            stack.push(progresses[i]);
            stack_speed.push(speeds[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int day = 1;
        while (!stack.isEmpty()) {
            int peek = stack.peek();
            int speed = stack_speed.peek();
            peek += speed * day;
            if (peek >= 100) {
                stack.pop();
                stack_speed.pop();
                int last_index = result.size()-1;
                result.set(last_index, result.get(last_index) + 1);
            } else {
                result.add(0);
                day++;
            }
        }


        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) != 0) {
                list.add(result.get(i));
            }
        }

        int answer[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }
        return answer;
    }

}
