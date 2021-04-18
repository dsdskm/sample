package com.kkh.algo.codinginterview.ch09.sub03_stack;

public class Practice3_1 {
    public static void main(String args[]) {
        // 배열 한 개로 스택 세 개를 어떻게 구현할지 설명하라
        new Practice3_1();
    }

    public Practice3_1() {
        solution();
    }

    public void solution() {
        ThreeOneStack tos = new ThreeOneStack(15, 3);
        tos.push(0, 11);
        tos.push(1, 22);
        tos.push(2, 33);
        tos.push(2, 55);
        tos.push(2, 56);
        tos.push(2, 57);
        tos.push(2, 58);
        tos.push(2, 59);
        tos.push(2, 59);
        tos.push(2, 59);
        tos.push(2, 59);
        tos.print();
        tos.print();
    }

    class ThreeOneStack {
        private int stackArr[];
        private int stackIndexArr[];
        private int stackSize;

        public ThreeOneStack(int size, int count) {
            stackArr = new int[size];
            stackIndexArr = new int[count];
            for (int i = 1; i < stackIndexArr.length; i++) {
                stackIndexArr[i] = i * size / count;
                // 0,10,20
            }
            stackSize = size / count;

        }

        public void push(int stackIndex, int value) {
            if (stackIndexArr[stackIndex] >= stackSize * (stackIndex + 1)) {
                System.out.println("stack " + stackIndex + " is full");

            } else {
                stackArr[stackIndexArr[stackIndex]++] = value;
            }

        }

        public int pop(int stackIndex) {
            stackIndexArr[stackIndex]--;
            if (stackIndexArr[stackIndex] < stackSize * stackIndex) {
                return -1;
            }
            int ret = stackArr[stackIndexArr[stackIndex]];
            stackArr[stackIndexArr[stackIndex]] = 0;
            return ret;
        }


        public void print() {
            for (int i = 0; i < stackArr.length; i++) {
                System.out.print(stackArr[i] + " ");
            }
            System.out.println();
        }
    }
}
