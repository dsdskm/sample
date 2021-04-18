package com.kkh.algo.hackerrank.medium;

import java.util.PriorityQueue;

public class BiggerIsGreater {
    public static void main(String args[]) {
        System.out.println(biggerIsGreater("lmno"));
        System.out.println(biggerIsGreater("dcba"));
        System.out.println(biggerIsGreater("dcbb"));
        System.out.println(biggerIsGreater("abdc"));
        System.out.println(biggerIsGreater("abcd"));
        System.out.println(biggerIsGreater("fedcbabcd"));

    }


    static String biggerIsGreater(String w) {
        char c[] = w.toCharArray();
        boolean visited[] = new boolean[c.length];
        char output[] = new char[c.length];
        PriorityQueue<String> pq = new PriorityQueue<>();
        perm(c, output, visited, 0, c.length, c.length, pq);
        String answer = "no answer";
        boolean searched = false;
        while (!pq.isEmpty()) {
            System.out.println("pq size : "+pq.size());
            String poll = pq.poll();
            if (searched) {
                answer = poll;
                break;
            }
            if (poll.equalsIgnoreCase(w)) {
                searched = true;
            }
        }
        return answer;
    }

    private static void perm(char[] c, char[] output, boolean[] visited, int depth, int n, int r, PriorityQueue pq) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i]);
            }
            if (!pq.contains(sb.toString())) {
                pq.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = c[i];
                perm(c, output, visited, depth + 1, n, r, pq);
                visited[i] = false;
            }
        }
    }

}
