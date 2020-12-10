package com.kkh.coupang.practice;

public class StackTest {

    private static final int CAPACITY = 5;
    private int mCurrentIndex = -1;
    private int ARR[] = new int[CAPACITY];

    public StackTest() {

    }

    public static void main(String args[]) {
        StackTest st = new StackTest();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        System.out.println("pop : " + st.pop());
        System.out.println("pop : " + st.pop());
        System.out.println("pop : " + st.pop());
        System.out.println("peek : " + st.peek());
        System.out.println("peek : " + st.peek());

    }


    private void push(int value) {
        System.out.println("push value : " + value);
        mCurrentIndex++;
        ARR[mCurrentIndex] = value;
        if (mCurrentIndex == ARR.length - 1) {
            int temp[] = new int[ARR.length * 2];
            System.arraycopy(ARR, 0, temp, 0, ARR.length);
            ARR = temp;
            temp = null;
        }
    }

    private int peek() {
        if (mCurrentIndex >= 0) {
            return ARR[mCurrentIndex];
        } else {
            return -1;
        }
    }

    private int pop() {
        if (mCurrentIndex >= 0) {
            int ret = ARR[mCurrentIndex];
            ARR[mCurrentIndex] = -1;
            mCurrentIndex--;
            return ret;
        } else {
            return -1;
        }
    }

}
