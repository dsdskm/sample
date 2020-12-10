package com.kkh.coupang.practice;

public class QueueTest {
    private static final int CAPACITY = 5;
    private int mCurrentIndex = -1;
    private int mRetIndex = 0;
    private int ARR[] = new int[CAPACITY];

    public static void main(String args[]) {
        QueueTest qt = new QueueTest();
        qt.offer(1);
        qt.offer(2);
        qt.offer(3);
        qt.offer(4);
        qt.offer(5);
        qt.offer(6);
        qt.offer(7);
        System.out.println("poll : " + qt.poll());
        System.out.println("poll : " + qt.poll());
        System.out.println("poll : " + qt.poll());
        System.out.println("peek : " + qt.peek());
        System.out.println("peek : " + qt.peek());
    }

    private void offer(int value) {
        System.out.println("offer value : " + value);
        mCurrentIndex++;
        ARR[mCurrentIndex] = value;
        if (mCurrentIndex == ARR.length - 1) {
            int temp[] = new int[ARR.length * 2];
            System.arraycopy(ARR, 0, temp, 0, ARR.length);
            ARR = temp;
            temp = null;
        }
    }

    private int poll() {
        if (mRetIndex < ARR.length - 1) {
            return ARR[mRetIndex++];
        } else {
            return -1;
        }
    }

    private int peek() {
        if (ARR.length > 0) {
            return ARR[mRetIndex];
        } else {
            return -1;
        }
    }
}
