package com.kkh.codingtest.stack_queue;

import java.util.Stack;

public class CodingTest_Queue4 {
    public static void main(String args[]) {
        new CodingTest_Queue4();
    }

    public CodingTest_Queue4() {
        System.out.println(solution("()(((()())(())()))(())"));
//        System.out.println(solution(new int[]{1, 1, 9, 1, 1,1}, 0));
    }


    public int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == '(')
                stack.add(arrangement.charAt(i));
            else {
                stack.pop();
                if (arrangement.charAt(i - 1) == '(')
                    answer += stack.size();
                else
                    answer++;
            }
        }
        return answer;
    }

}
