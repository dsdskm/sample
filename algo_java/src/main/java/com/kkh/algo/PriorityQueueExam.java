package com.kkh.algo;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExam {

    class MyPQ implements Comparable<MyPQ> {

        int data;

        public MyPQ(int data) {
            this.data = data;
        }

        @Override
        public int compareTo(@NotNull MyPQ o) {
            if (data < o.data) {
                return -1;
            } else if (data == o.data) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "MyPQ{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String args[]) {
        new PriorityQueueExam();
    }

    public PriorityQueueExam() {
        PriorityQueue<MyPQ> queue = new PriorityQueue<>(10);
        queue.offer(new MyPQ(4));
        System.out.println(queue);
        queue.offer(new MyPQ(3));
        System.out.println(queue);
        queue.offer(new MyPQ(8));
        System.out.println(queue);
        queue.offer(new MyPQ(2));
        System.out.println(queue);
        queue.offer(new MyPQ(1));
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());


    }
}
