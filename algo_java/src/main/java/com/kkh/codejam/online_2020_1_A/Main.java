package com.kkh.codejam.online_2020_1_A;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final char COLOR[] = { 'R', 'Y', 'B' };

    int n;
    int card[][][];

    public void init() {
        card = new int[2][3][10];
    }

    public void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 2; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                String temp = st.nextToken();

                int c = 0;
                for (int k = 0; k < 3; ++k) {
                    if (temp.charAt(0) == COLOR[k]) {
                        c = k;
                    }
                }

                int num = temp.charAt(1) - '0';

                ++card[i][c][num];
            }
        }
    }

    public void process() {

    }

    public void output() throws IOException {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (card[0][i][j] != card[1][i][j]) {
                    bw.write("CHEATER\n");
                    return;
                }
            }
        }
        bw.write("NOT CHEATER\n");
        bw.flush();
    }

    public void run() throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; ++i) {
            init();
            input();
            process();
            output();
        }
    }

    public static void main(String args[]) throws NumberFormatException, IOException {
        Main m = new Main();
        m.run();
    }
}