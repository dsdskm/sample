package com.kkh.condigtest.dfsbfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CodingTest_DFSBFS2 {
    public static void main(String args[]) {
        new CodingTest_DFSBFS2();
    }

    public CodingTest_DFSBFS2() {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(3, computers));

        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(3, computers2));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] network = new boolean[n];

        for (int node=0; node<n; node++) {
            if (!network[node]) {
                dfs(computers, node, network);
                answer++;
            }
        }

        return answer;
    }

    boolean[] dfs(int[][] computers, int node, boolean[] visited) {
        visited[node] = true;

        for (int idx=0; idx<computers.length; idx++) {
            if (node != idx && computers[node][idx] == 1 && visited[idx] == false) {
                visited = dfs(computers, idx, visited);
            }
        }
        return visited;
    }
}