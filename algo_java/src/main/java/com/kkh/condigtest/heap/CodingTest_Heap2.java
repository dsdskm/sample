package com.kkh.condigtest.heap;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CodingTest_Heap2 {
    public static void main(String args[]) {
        new CodingTest_Heap2();
    }


    public CodingTest_Heap2() {
        System.out.println(solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));
//        System.out.println(solution(new int[]{5, 5, 5, 5, 5, 5}, 7));
    }

    class Mil {
        int day;
        int supply;

        public Mil(int day, int supply) {
            this.day = day;
            this.supply = supply;
        }

        @Override
        public String toString() {
            return "Mil{" +
                    "day=" + day +
                    ", supply=" + supply +
                    '}';
        }
    }

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        for (int i = 0; i < k; i++) {
            if (index < dates.length && i == dates[index])
                priorityQueue.add(supplies[index++]);

            if (stock == 0) {
                stock += priorityQueue.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }

}
