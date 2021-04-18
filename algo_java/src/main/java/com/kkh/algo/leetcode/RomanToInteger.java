package com.kkh.algo.leetcode;

import java.util.Hashtable;
import java.util.Stack;

public class RomanToInteger {
    public static void main(String args[]) {
        new RomanToInteger();
    }

    public RomanToInteger() {
        System.out.println(romanToInt("III"));  //3
        System.out.println(romanToInt("IV"));  //3
    }

    public int romanToInt(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<>();
        ht.put('I', 1);
        ht.put('V', 5);
        ht.put('X', 10);
        ht.put('L', 50);
        ht.put('C', 100);
        ht.put('D', 500);
        ht.put('M', 1000);

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int num = ht.get(c);
            sum += num;
            System.out.println(c + " , " + num);
        }

        return sum;
    }
}
