package com.kkh.algo.hackerrank.easy;

public class Staircase {
    public static void main(String args[]) {
        new Staircase();
    }

    public Staircase() {
        staircase(6);
    }

    public static void staircase(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }

        String print = sb.toString();
        for (int i = 0; i < n; i++) {
            print = print.substring(1);
            print += "#";
            System.out.println(print);
        }
    }
}
