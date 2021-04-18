package com.kkh.algo.codingtest.heap;

import java.util.PriorityQueue;

public class LV2CodingTest_Heap1_Solution {

    /*
    섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
     모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
     */
    public static void main(String args[]) {
        LV2CodingTest_Heap1_Solution l = new LV2CodingTest_Heap1_Solution();
        System.out.println(l.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(l.solution(new int[]{9, 2, 12, 1, 10, 3}, 10000));
        System.out.println(l.solution(new int[]{0, 0, 0, 0, 0, 0}, 1));
    }


    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        //우선순위 큐에 음식 담아주기
        for (int i : scoville) {
            priorityQueue.add(i);
        }

        //가장 덜 매운 음식의 스코빌 지수가 K보다 작다면 반복한다.
        while (!priorityQueue.isEmpty() && priorityQueue.peek() < K){
            Integer lessSpicy = priorityQueue.poll();
            if (!priorityQueue.isEmpty()) {
                Integer secondLessSpicy = priorityQueue.poll();
                //가장 덜 매운 음식 2가지를 섞고, 다시 큐에 넣는다.
                priorityQueue.add(lessSpicy + secondLessSpicy * 2);
                answer++;
            } else {
                return -1;
            }
        }
        return answer;
    }
}
