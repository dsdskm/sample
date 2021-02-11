package com.kkh.codingtest.graph;

import java.util.*;

public class CodingTest_Graph1 {
    public static void main(String args[]) {
        new CodingTest_Graph1();
    }

    public CodingTest_Graph1() {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public int solution(int n, int[][] edge) {
        int[] dist = new int[n + 1];
        boolean[][] map = new boolean[n + 1][n + 1];
        // int [][] map = new int[n+1][n+1];
        for (int i = 0; i < edge.length; i++) {
            map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = true;
            //map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = 1; // 이렇게 수행하면 에러남..
        }

        Queue<Integer> nodes = new LinkedList<Integer>();
        nodes.add(1);

        // BFS 탐색
        int maxDist = 0;
        while (!nodes.isEmpty()) {
            int i = nodes.poll();

            for (int j = 2; j <= n; j++) {
                if (dist[j] == 0 && map[i][j]) {
                    dist[j] = dist[i] + 1;
                    nodes.add(j);
                    maxDist = Math.max(maxDist, dist[j]);
                }
            }
        }

        // 가장 멀리 있는 노드가 몇 개인지 계산
        int count = 0;
        for (int d : dist) {
            if (maxDist == d)
                count++;
        }

        return count;
    }
}
