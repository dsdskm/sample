package com.kkh.algo.codejam.online_2021_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class ProblemB_Answer {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String s;
    static Character[] sorted;
    static long result;

    public static void input() throws IOException {
        s = br.readLine().trim();
    }

    public static void process() {
        sorted = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            sorted[i] = s.charAt(i);
            if (sorted[i] == '6') {
                sorted[i] = '9';
            }
        }
        Arrays.sort(sorted, Collections.reverseOrder());

        String[] numStr = new String[]{"" + sorted[0], "" + sorted[1]};

        for (int cur = 2; cur < sorted.length; ++cur) {
            if (Long.parseLong(numStr[0]) < Long.parseLong(numStr[1])) {
                numStr[0] += sorted[cur];
            } else {
                numStr[1] += sorted[cur];
            }
        }

        result = Long.parseLong(numStr[0]) * Long.parseLong(numStr[1]);
    }

    public static void output() throws IOException {
        bw.write("" + result + "\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; ++i) {
            input();
            process();
            output();
        }
    }
}