package com.kkh.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.kkh.algo.Utils.print;
import static com.kkh.algo.Utils.println;

public class StackQueue {

    public static void main(String args[]) {

        new StackQueue();

    }

    public StackQueue() {
        println("Stack");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        println(String.valueOf(stack.pop()));
        println(String.valueOf(stack.pop()));
        println(String.valueOf(stack.pop()));

        println("Queue");
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        println(String.valueOf(queue.poll()));
        println("size = " + String.valueOf(queue.size()));
        println(String.valueOf(queue.poll()));
        println("size = " + String.valueOf(queue.size()));
        println(String.valueOf(queue.poll()));
        println("size = " + String.valueOf(queue.size()));
    }
}
