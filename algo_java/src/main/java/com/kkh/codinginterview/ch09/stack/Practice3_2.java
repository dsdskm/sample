package com.kkh.codinginterview.ch09.stack;

import java.util.Stack;

public class Practice3_2 {
    public Practice3_2() {
        solution();
    }

    public static void main(String args[]) {
        /*
        기본적인 push와 pop 기능이 구현된 스택에서 최솟값을 반환하는 min 함수를 추가하려고 한다
        어떻게 설계하는가?
         push, pop, min 연산은 모두 O(1) 시간에 동작해야 한다
         */

        new Practice3_2();
    }

    public void solution() {
        //push 할때마다 min을 저장한다
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(15);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(44);
        System.out.println("stack min value : " + stack.getMin());
        System.out.println("stack pop : " + stack.pop());
        System.out.println("stack pop : " + stack.pop());
        System.out.println("stack pop : " + stack.pop());
        System.out.println("stack min value : " + stack.getMin());
    }

    class MyStack extends Stack<NodeWithMin> {
        private int min = Integer.MAX_VALUE;

        public int getMin() {
            if (isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().min;
            }

        }

        public void push(Integer item) {
            if (item < min) {
                min = item;
            }
            super.push(new NodeWithMin(item, min));
        }
    }

    class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }

        @Override
        public String toString() {
            return "NodeWithMin{" +
                    "value=" + value +
                    ", min=" + min +
                    '}';
        }
    }
}
