package com.kkh.coupang.practice;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    class MyInteger implements Comparable<MyInteger> {
        int mValue;

        public MyInteger(int mValue) {
            this.mValue = mValue;
        }

        @Override
        public int compareTo(@NotNull MyInteger o) {
            if (mValue > o.mValue) {
                return 1;
            } else if (mValue == o.mValue) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    private PriorityQueue<MyInteger> mQueue = new PriorityQueue<>();

    public PriorityQueueTest() {
    }

    public static void main(String args[]) {
        PriorityQueueTest pqt = new PriorityQueueTest();
        pqt.offer(70);
        pqt.offer(40);
        pqt.offer(20);
        pqt.offer(10);
        pqt.offer(30);
        pqt.offer(50);
        pqt.offer(60);
        pqt.offer(80);
        pqt.offer(90);

        System.out.println("poll : " + pqt.poll());
        System.out.println("poll : " + pqt.poll());
        System.out.println("poll : " + pqt.poll());
    }

    private void offer(int value) {
        System.out.println("offer value : " + value);
        mQueue.offer(new MyInteger(value));
    }

    private int poll() {
        return mQueue.poll().mValue;
    }
}
