package com.kkh.codingtest.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LV3CodingTest_Heap3_Solution {
    /*
    I 숫자	큐에 주어진 숫자를 삽입합니다.
    D 1	큐에서 최댓값을 삭제합니다.
    D -1	큐에서 최솟값을 삭제합니다.
    이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
     */
    public static void main(String args[]) {
        LV3CodingTest_Heap3_Solution l = new LV3CodingTest_Heap3_Solution();
        System.out.println(l.solution(new String[]{"I 16","I 13","I 19","D 1",}));

    }

    public int[] solution(String[] operations) {
        /*

        1. 큐에 숫자를 삽입
        2. 큐에서 최대값 추출
        3. 큐에서 최소값 추출출
        */
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < operations.length; i++) {
            String s = operations[i];
            if (s.startsWith("I")) {
                s = s.replace("I ", "");
                int num = Integer.parseInt(s);
                minHeap.offer(num);
                maxHeap.offer(num);
            } else if (s.equals("D 1")) {
                // poll 은 최소값 추출
                int poll = minHeap.poll();
                System.out.println("poll : " + poll);
            } else if (s.equals("D -1")) {
                int poll = maxHeap.poll();
            }

        }
        int[] answer = {};
        return answer;
    }
}
