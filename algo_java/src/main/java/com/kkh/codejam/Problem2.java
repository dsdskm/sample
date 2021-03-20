package com.kkh.codejam;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem2 {
    /*
    문제
    Albert 는 n장의 숫자 카드를 가지고 있다.
    각 카드에는 0부터 9까지 숫자 하나씩이 적혀있고, 6이나 9가 적힌 카드를 회전할 경우 구분할 수 없다 (즉, 6이 적힌 카드는 회전하면 9로 보이고, 9가 적힌 카드는 회전하면 6으로 보인다).
    Albert는 최근 두 수의 곱셈에 대해 배운터라 n장의 카드를 모두 이용하여 두 개의 수를 만든 후, 그 수의 곱이 최대가 되도록 하고 싶다.
    단, n장의 카드 모두 사용하여야 하며, 각 수는 최소 1장 (그리고 최대 n-1장)의 카드로 구성되어야 한다. 6이나 9가 적힌 카드는 Albert가 임의로 회전하여 사용할 수 있다.
    예를 들어 n = 8이고 Albert가 가진 카드가 [2, 0, 2, 0, 2, 0, 2, 1] 이라 하자.
    이 때 8장의 카드를 활용하여 "2200" 과 "2210"을 만들면 두 수의 곱은 4862000이 된다.
    혹은 "2020"과 "2021"을 만들어 곱이 4082420이 되도록 할 수도 있다.
    이 예제에서 Albert가 만들 수 있는 최대 곱은 4862000이다.
    입력으로 Albert가 가진 n장의 숫자 카드가 주어졌을 때, 달성 가능한 최대 곱을 구하시오.
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int t;
    static long input_arr[];

    public static void main(String args[]) {
        input();
    }

    public static void input() {
        try {
            t = Integer.parseInt(br.readLine());
            input_arr = new long[t];
            for (int i = 0; i < t; i++) {
                input_arr[i] = Long.parseLong(br.readLine());
            }

            for (int i = 0; i < t; i++) {
                bw.write("" + solution(input_arr[i]) + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static long solution(long num) {
        /*

        102030
        310 200 =6200 = -110
        300 210 = 6300 - -90

        0.곱하는 수의 차이가 적을 수록 곱의 값은 커진다
        1.9는 모두 6으로 뒤집는다.
        2.분리하여 정렬후 스택에 넣는다.
        3.큰 값부터 꺼내서 두 문자열에 각각 붙인다.
        -> A B -> A BB -> AA BB

         */
        //1.9는 모두 6으로 뒤집는다.
        String numStr = String.valueOf(num);
        numStr = numStr.replace('6', '9');

        //2.분리하여 정렬후 스택에 넣는다.
        char carr[] = numStr.toCharArray();
        Arrays.sort(carr);
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        for (int i = 0; i < carr.length; i++) {
            char c = carr[i];
            stack.push(Character.getNumericValue(c));
            stack2.push(Character.getNumericValue(c));
        }


        //3.큰 값부터 꺼내서 두 문자열에 각각 붙인다
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(stack.pop());
        int index = 0;
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (index < 2) {
                sb2.append(pop);
            } else {
                sb1.append(pop);
                if (index == 4) {
                    index = 0;
                    continue;
                }
            }
            index++;
        }
        long num1 = 0;
        if (!sb1.toString().equals("")) {
            num1 = Long.parseLong(sb1.toString());
        }
        long num2 = 0;
        if (!sb2.toString().equals("")) {
            num2 = Long.parseLong(sb2.toString());
        }


        long answer1 = num1 * num2;
        sb1 = new StringBuilder("");
        sb2 = new StringBuilder("");
        index = 0;
        while (!stack2.isEmpty()) {
            int pop = stack2.pop();
            if (index % 2 == 1) {
                sb1.append(pop);
            } else {
                sb2.append(pop);
            }
            index++;
        }
        num1 = 0;
        if (!sb1.toString().equals("")) {
            num1 = Long.parseLong(sb1.toString());
        }
        num2 = 0;
        if (!sb2.toString().equals("")) {
            num2 = Long.parseLong(sb2.toString());
        }


        long answer2 = num1 * num2;

        //4. 두 문자열 곱을 리턴한다
        return Math.max(answer1, answer2);

    }


}
