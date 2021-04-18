package com.kkh.algo.codinginterview.ch09.sub03_stack;

import java.util.Stack;

public class Practice3_5 {
    public static void main(String args[]) {
        new Practice3_5();
        /*
        가장 작은 값이 위로 오도록 하는 스택을 정렬하는 프로그램을 작성
        배열 등 다른 자료 구조로 복사할 수 없다.
        추가적으로 하나 정도의 스택 사용 가능

         */
    }

    public Practice3_5() {
        solution();
    }

    private void solution() {
        /*
        1. 값을 push 할때 제일 작은 값만 마지막에 push한다
        2. 모든 값이 정렬된 상태로 저장될 필요는 없다


         */
        SortedStack stack = new SortedStack();
        stack.push(5);
        stack.push(8);
        stack.push(1);
        stack.push(3);
        stack.push(11);
        //System.out.println("pop : "+stack.pop());
        System.out.println("peek : " + stack.peek());
        System.out.println("pop : " + stack.pop());
        System.out.println("peek : " + stack.peek());
        System.out.println("pop : " + stack.pop());
        System.out.println("pop : " + stack.pop());
        System.out.println("pop : " + stack.pop());
    }

    class SortedStack {
        private Stack<Integer> stack;

        public void push(int value) {
            if (stack == null || stack.isEmpty()) {
                stack = new Stack<>();
            }
            stack.push(value);
        }

        public int pop() {
            Stack<Integer> tmp = new Stack<>();
            int min = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                if (pop < min) {
                    min = pop;
                }
                tmp.push(pop);
            }

            while (!tmp.isEmpty()) {
                int pop = tmp.pop();
                if (min != pop) {
                    stack.push(pop);
                }
            }
            return min;
        }

        public int peek() {
            Stack<Integer> tmp = new Stack<>();
            int min = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                if (pop < min) {
                    min = pop;
                }
                tmp.push(pop);
            }

            while (!tmp.isEmpty()) {
                int pop = tmp.pop();
                stack.push(pop);
            }
            return min;
        }


        public boolean isEmpty() {
            if (stack == null) {
                return false;
            }
            return stack.isEmpty();
        }
    }
}
