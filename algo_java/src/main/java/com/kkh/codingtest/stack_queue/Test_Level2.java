package com.kkh.codingtest.stack_queue;

import java.util.Stack;

public class Test_Level2 {
    public Test_Level2() {
        System.out.println(solution(new int[]{1, 2, 3, 2, 3})); // 4,3,1,1.0
//        System.out.println(solution(new int[]{1, 1, 1, 1, 1}));
//        System.out.println(solution(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
//        System.out.println(solution(new int[]{1, 2, 1, 2, 1}));
    }

    public static void main(String args[]) {
        new Test_Level2();
    }

    public int[] solution(int[] prices) {
        //https://gurumee92.tistory.com/170
        int answer[] = new int[prices.length];

        // Stack에 경과일을 차근차근 쌓는다.
        // 하락한 경우 하락한 날수 만큼 answer에 바로 입력한다.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.empty() && prices[stack.peek()] > prices[i]) {
                int peek = stack.peek();
                stack.pop();
                answer[peek] = i - peek;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        System.out.println("print answer");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
        return answer;
    }


}
