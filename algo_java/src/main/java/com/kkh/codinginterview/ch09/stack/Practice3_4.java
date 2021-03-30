package com.kkh.codinginterview.ch09.stack;

import java.util.Stack;

public class Practice3_4 {
    public static void main(String args[]) {
        new Practice3_4();
        /*
        스택 두 개로 큐 하나를 구현한 MyQueue 클래스를 구현하라
         */
    }

    public Practice3_4() {
        solution();
    }

    private void solution() {
        /*
        1. 스택 2개가 포함된 MyQueue 클래스를 생성
        2. queue의 offer와 poll을 구현해야 함
        3. 매 값을 push하기전에 stack2의 모든 값을 stack1에 pus 한다
        4. stack1에 값을 push하고 모든 값을 pop하여 stack2에 push 하여 넣는다
        5. pop은 stack2의 값을 리턴한다
         */
        MyQueue mq = new MyQueue();
        mq.offer(1);
        mq.offer(2);
        mq.offer(3);
        mq.offer(4);
        mq.offer(5);
        System.out.println("poll : "+mq.poll());
        System.out.println("poll : "+mq.poll());
        System.out.println("poll : "+mq.poll());
        System.out.println("poll : "+mq.poll());
        System.out.println("poll : "+mq.poll());
        System.out.println("poll : "+mq.poll());
    }

    class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public void offer(int value) {
            // first
            if (stack2 == null) {
                stack2 = new Stack<>();
                stack2.push(value);
            } else {
                if (stack1 == null) {
                    stack1 = new Stack<>();
                }
                moveStack(stack2, stack1);
                stack1.push(value);
                moveStack(stack1, stack2);
            }
        }

        public int poll() {
            if (stack2 == null || stack2.isEmpty()) {
                return -1;
            }
            return stack2.pop();
        }

        private void moveStack(Stack<Integer> from, Stack<Integer> to) {
            while (!from.isEmpty()) {
                int pop = from.pop();
                to.push(pop);
            }
        }
    }
}
