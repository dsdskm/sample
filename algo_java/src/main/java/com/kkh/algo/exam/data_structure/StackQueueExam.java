package com.kkh.algo.exam.data_structure;

import java.util.*;

public class StackQueueExam {
    public static void main(String args[]) {
        stack();
        queue();
        heapQueue();
        deque();
    }

    private static void deque() {
        System.out.println("deque");
        Deque<Integer> deque = new LinkedList<>();
        deque.add(5);
        deque.add(10);
        deque.add(9);
        deque.add(1);
        deque.add(4);
        deque.add(3);
        deque.add(7);

        int pollFirst = deque.pollFirst();
        int pollLast = deque.pollLast();

        System.out.println("pollFirst : "+pollFirst+" , pollLast : "+pollLast);
    }

    private static void heapQueue() {
        System.out.println("heapQueue");
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());        // 역순
        pq.add(5);
        pq.add(1);
        pq.add(9);
        pq.add(3);
        pq.add(6);
        pq.add(10);
        pq.add(2);

        while (!pq.isEmpty()) {
            int poll = pq.poll();
            System.out.println("poll : " + poll);
        }
    }

    private static void queue() {
        System.out.println("queue");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(3);
        queue.offer(1);
        queue.offer(5);
        queue.offer(10);
        queue.offer(9);
    }

    private static void stack() {
        System.out.println("stack");
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(10);
        stack.push(9);
    }

}
