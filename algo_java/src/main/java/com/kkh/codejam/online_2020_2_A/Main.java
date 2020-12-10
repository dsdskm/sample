package com.kkh.codejam.online_2020_2_A;

import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N;

    public static void main(String args[]) {

        solution();
    }

    static class Treasure implements Comparable<Treasure> {
        int index;
        int valueA;
        int valueB;

        public Treasure(int index, int valueA, int valueB) {
            this.index = index;
            this.valueA = valueA;
            this.valueB = valueB;
        }

        @Override
        public int compareTo(Treasure o) {
            if (this.valueB < o.valueB) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "Treasure{" +
                    "index=" + index +
                    ", valueA=" + valueA +
                    ", valueB=" + valueB +
                    '}';
        }
    }

    static class Treasure2 implements Comparable<Treasure2> {
        int index;
        int valueA;
        int valueB;

        public Treasure2(int index, int valueA, int valueB) {
            this.index = index;
            this.valueA = valueA;
            this.valueB = valueB;
        }

        @Override
        public int compareTo(Treasure2 o) {
            if (this.valueA < o.valueA) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "Treasure{" +
                    "index=" + index +
                    ", valueA=" + valueA +
                    ", valueB=" + valueB +
                    '}';
        }
    }

    private static void solution() {

        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        ArrayList<Treasure> list = new ArrayList<>();
        ArrayList<Treasure2> list2 = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 0; t < T; t++) {
            list.clear();
            list2.clear();
            N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                list.add(new Treasure(i, a, b));
                list2.add(new Treasure2(i, a, b));
            }
            Collections.sort(list);
            Collections.sort(list2);
            int res = Math.max(solve(list), solve2(list2));
            try {
                bw.write(res + "\n");
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int solve(ArrayList<Treasure> list) {
        int sumA = 0;
        int sumB = 0;
        boolean turn = true;
        for (int i = 0; i < list.size(); i++) {
            Treasure t = list.get(i);
            if (turn) {
                sumA += t.valueA;
            } else {
                sumB += t.valueB;
            }
            turn = !turn;
        }
        return sumA - sumB;
    }

    private static int solve2(ArrayList<Treasure2> list) {
        int sumA = 0;
        int sumB = 0;
        boolean turn = true;
        for (int i = 0; i < list.size(); i++) {
            Treasure2 t = list.get(i);
            if (turn) {
                sumA += t.valueA;
            } else {
                sumB += t.valueB;
            }
            turn = !turn;
        }
        return sumA - sumB;
    }

}
