package com.kkh.codinginterview.ch09.sub03_stack;

import java.util.Stack;

public class PracticeExam {
    public static void main(String args[]){
        new PracticeExam();
    }

    public PracticeExam(){
        PracticeStack ps = new PracticeStack();
        ps.push(1);
        ps.push(2);
        ps.push(3);
        ps.push(4);
        ps.push(5);
        ps.print();
        ps.pop();
    }

    class PracticeStack{
        Stack<Integer> stackA = new Stack<Integer>();
        public void push(int v){
            stackA.push(v);
        }

        public void print(){
           printStack(stackA);
        }
        private void printStack(Stack<Integer> s){
            Stack<Integer> stack = s;
            while(!stack.isEmpty()){
                System.out.println(stack.pop());
            }
        }

        public int pop(){
            return stackA.pop();
        }
    }
}
