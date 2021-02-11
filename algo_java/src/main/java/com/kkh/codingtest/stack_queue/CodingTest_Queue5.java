package com.kkh.codingtest.stack_queue;

public class CodingTest_Queue5 {
    public static void main(String args[]) {
        new CodingTest_Queue5();
    }

    public CodingTest_Queue5() {
        System.out.println(solution(new int[]{1, 2, 3, 2, 3}));
//        System.out.println(solution(new int[]{1, 1, 9, 1, 1,1}, 0));
    }


    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    count++;
                } else if (prices[i] > prices[j]) {
                    count++;
                    break;
                }
            }
            answer[i] = count;
            count = 0;
        }
        return answer;
    }

}
