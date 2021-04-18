package com.kkh.algo.codingtest.stack_queue;

import java.util.Stack;

public class LV2CodingTest_StackQueue2_Solution {
    /*
    초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
    가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

    prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
    prices의 길이는 2 이상 100,000 이하입니다.
    입출력 예
    prices [1,2,3,2,3]
    return [4,3,1,1,0]

     */


    public static void main(String args[]) {
        int prices[] = {1, 2, 3, 2, 3};
//        new LV2CodingTest_StackQueue1_Solution().solution(prices);
        new LV2CodingTest_StackQueue2_Solution().solution2(prices);
    }

    public int[] solution2(int[] prices) {
        int answer[] = new int[prices.length];

        Stack<Integer[]> stack = new Stack();
        for (int i = prices.length - 2; i >= 0; i--) {
            int day = 0;

            while (!stack.isEmpty() && stack.peek()[0] >= prices[i]) {
                day += stack.pop()[1];
            }

            answer[i] = stack.push(new Integer[]{prices[i], day + 1})[1];
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static int[] solution(int[] prices) {
        int answer[] = new int[prices.length];
        Stack<int[]> stack = new Stack<>();

        /*
        1. 뒤쪽부터 순회한다(len -2부터)
        2. prices[i] > prices[i+1] => answer[i] = 1 연속 값을 비교했을때 하락했다면 해당 주가는 1일 유지
        3. prices[i] > prices[i+1] 에서 작은 값을 stack에 쌓는다
        4. prices[i] <= prices[i+1] => 스택을 돌면서(pop) 스택값이 prices[i]보다 작을때까지 pop
        5. 유지 기간 = 멈춘 index - i, 스택 끝까지 가면 length -i - 1
         */

        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > prices[i + 1]) {
                answer[i] = 1;
                stack.push(new int[]{i+1, prices[i + 1]});
            } else {
                while (!stack.isEmpty() && (stack.peek()[1] >= prices[i])) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    answer[i] = prices.length - i - 1;
                } else {
                    answer[i] = stack.peek()[0] - i;
                }
            }
        }

//        for (int i = 0; i < answer.length; i++) {
//            System.out.println(answer[i]);
//        }
        return answer;
    }

}
