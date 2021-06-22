package com.kkh.algo.codejam.online_2021_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class ProblemC {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            int n = Integer.parseInt(br.readLine().trim());
            String arr[] = br.readLine().split(" ");
            int result = solution(n, arr);
            bw.write("" + result + "\n");
            bw.flush();
        }
    }

    public static int solution(int n, String str[]) {

        int arr[] = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        ArrayList<Integer> target = new ArrayList<>();
        target.add(202021);
        target.add(20202021);
        target.add(202002021);
        target.add(202012021);
        target.add(202022021);
        target.add(202032021);
        target.add(202042021);
        target.add(202052021);
        target.add(202062021);
        target.add(202072021);
        target.add(202082021);
        target.add(202092021);


        Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (!hash.containsKey(num)) {
                hash.put(num, 0);
            }
            hash.replace(num, hash.get(num) + 1);
        }

        int ret = 0;

        for (int i = 0; i < target.size(); i++) {
            int t = target.get(i);
            for (int j = 0; j < arr.length; j++) {
                int diff = t - arr[j];
                if (hash.containsKey(diff)) {
                    ret += hash.get(diff);
                }
            }
        }


        return ret / 2;
    }
}
