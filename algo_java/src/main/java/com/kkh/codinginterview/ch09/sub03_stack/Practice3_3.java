package com.kkh.codinginterview.ch09.sub03_stack;

import java.util.ArrayList;
import java.util.Stack;

public class Practice3_3 {
    public Practice3_3() {
        solution();

    }

    public static void main(String args[]) {
        /*
        SetOfStacks를 구현하라
        여러 개의 스택으로 구성되어 있으며, 이전 스택이 지정된 용량을 초과하는 경우 새로운 스택을 생성해야한다
        push와 pop은 동일하게 동작해야 한다
         */
        new Practice3_3();
    }


    private void solution() {
        /*
        1. Integer Stack ArrayList를 포함하고 있는 SetOfStacks 클래스를 생성한다
        2. max stack size를 5라고 가정한다
        3. 현재 사용중인 스택을 가리키는 current_stack_index와 현재 사용중인 스택의 사이즈를 가리키는 current_stack_size를 변수를 사용한다
        4. 매 push / pop 할때마다 current_size를 체크한다
        4-1. push하는 경우 current_size가 max이면 새로 stack을 생성하여 추가한후 리스트에 추가
        4-2. pop하는 경우 pop 이후에 current_stack_index와 current_stack_size를 업데이트한다
        5. 특정 하위 스택에 대해서 pop을 수행하는 popAt(int index)
        6. side 검증
         */
        SetOfStacks sos = new SetOfStacks();
        sos.push(1);
        System.out.println("pop : " + sos.pop());
        System.out.println("pop : " + sos.pop());
        System.out.println("pop : " + sos.pop());
    }

    class SetOfStacks {
        private static final int MAX_STACK_SIZE = 5;
        private int currentStackIndex = 0;
        private ArrayList<Stack<Integer>> stackList;

        public void push(int value) {
            // first
            if (stackList == null) {
                stackList = new ArrayList<>();
                addNewStack(value);
            } else {
                Stack<Integer> stack = stackList.get(currentStackIndex);
                if (stack.size() == MAX_STACK_SIZE) {
                    addNewStack(value);
                    currentStackIndex++;
                } else {
                    stack.push(value);
                }
            }
        }

        private void addNewStack(int value) {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(value);
            stackList.add(newStack);
        }

        public int pop() {
            if (stackList.size() == 0) {
                return -1;
            }
            Stack<Integer> stack = stackList.get(currentStackIndex);
            int ret = stack.pop();
            if (stack.isEmpty()) {
                stackList.remove(currentStackIndex);
                currentStackIndex--;
            }
            return ret;
        }

        public int popAt(int index) {
            currentStackIndex = index;
            return pop();
        }


    }
}
