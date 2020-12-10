package com.kkh.algo;

public class Prime {
    public static void main(String args[]) {
        new Prime();
    }

    public Prime() {
        prime(120);
    }

    private void prime(int num) {
        boolean[] primeNum = new boolean[121];
        primeNum[1] = true;

        for (int i = 2; i <= num; i++) {
            for (int j = 2; i * j <= 120; j++) {
                primeNum[i * j] = true;
            }
        }

        for (int i = 1; i <= num; i++) {
            if (!primeNum[i]) System.out.println(i);
        }

    }
}
