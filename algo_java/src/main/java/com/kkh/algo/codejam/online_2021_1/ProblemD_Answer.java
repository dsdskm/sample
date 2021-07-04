package com.kkh.algo.codejam.online_2021_1;


import java.util.stream.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ProblemD_Answer {
    static boolean possible(int dist, int[] x, int s) {
        int prev = x[0], cnt = 1;
        for (int i = 1; cnt < s && i < x.length; i++) {
            System.out.println("    x[i]:" + x[i] + " , prev:" + prev + " , x[i]-prev : " + (x[i] - prev) + " , dist:" + dist);
            if (x[i] - prev >= dist) {
                cnt++;
                prev = x[i];
            }
        }
        System.out.println("    cnt:" + cnt + " , s:" + s);
        return cnt >= s;
    }

    static int solve(int[] x, int s) {
        int n = x.length;
        if (s < 2 || s > n)
            throw new IllegalArgumentException("gg wp");
        Arrays.sort(x);
        int l = 1, r = x[n - 1];
        while (l <= r) {

            int mid = (l + r) / 2;

            boolean p = possible(mid, x, s);
            System.out.println("l : " + l + " , r : " + r + " , mid : " + mid+" possible : "+p);
            if (p)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solve(new int[]{11, 19, 24, 26, 29, 30}, 4));
        /*
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter writer = new BufferedWriter(ow);

        FastScanner in = new FastScanner();
        int t = in.nextInt();
        // -----------------------------------------------------
        while (t > 0) {
            t--;
            int n = in.nextInt();
            int s = in.nextInt();
            int[] x = new int[n];
            String[] vals = in.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(vals[i]);
            }
            writer.write(String.format("%d\n", solve(x, s)));
            writer.flush();
        }

         */
    }

    // --------------------------------------
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return "";
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
